package com.example.test.demo.test.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.test.demo.test.crudrepository.MetaDataRepository;
import com.example.test.demo.test.model.MetaData;
import com.example.test.demo.test.service.MetaDataService;

@Controller
@MultipartConfig(maxFileSize = 16177215) //can accept file size upto 16MB
public class FileUploadController {
	
	private static String fileName = "/Users/kapil/Desktop/";
	

	@Autowired
	MetaDataService metaDataService;
	
	@GetMapping("/")
	public String index() {
		return "hello";
	}
	
	
	//RedirectAttributes - extends the Model interface to redirect to particular page
	@PostMapping( value = "/upload")
	public String uploadfile(@RequestParam("uploadedFile") MultipartFile uploadedFile, RedirectAttributes redirectAttributes) {
		
		
	
		 
		//validation to check if file is empty or not
		if(uploadedFile.isEmpty()) {    
			redirectAttributes.addFlashAttribute("message", "please select a file to upload");
			return "redirect:/uploadStatus";  //redirect to the error page
		}
		
		try {
			
			
			
			MetaData data = new MetaData();
			byte bytes[] = uploadedFile.getBytes();
			
			//use to performs the operations on the files
			Path path = Paths.get(fileName+uploadedFile.getOriginalFilename());
			
			System.out.println(path); //files stored at this location
			
			
			Files.write(path, bytes);
			data.setFileContentType(uploadedFile.getContentType());
			data.setFileName(uploadedFile.getOriginalFilename());
			data.setSize(uploadedFile.getSize());
			String fileData = new String(bytes);
			data.setFileData(fileData);
			
			
			metaDataService.save(data);  //saving the entity in the database
			redirectAttributes.addFlashAttribute("message", "You have successfully uploaded " +uploadedFile.getOriginalFilename());
		
			
			
		}catch(IOException io) { //to handle the file exception e.g FileNotFoundException
			io.printStackTrace();
		} finally {
			System.out.println("Program Exectued");
		}
		
		
		return "redirect:/uploadStatus";
		
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}
	
}