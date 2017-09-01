package com.example.test.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.test.demo.test.model.MetaData;
import com.example.test.demo.test.service.MetaDataService;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ApplicationTests {

	
	//mockito uses to mock the dummy functionality and data to do independent testing
	@Mock
	MetaDataService metaDataService;

	
	
	@Before
	public void test() {
		metaDataService = Mockito.mock(MetaDataService.class);
	}
	
	@Test
	public void contextLoads() {
		
		byte[] arr = new byte[20000000];  //dummy data
		
		String s = new String(arr);
		
		MetaData data = new MetaData();
		assertNotNull(data);
		data.setFileData(s);
		data.setId(1L);
		data.setFileContentType("text");
		data.setFileName("file1.txt");
		
		when(metaDataService.save(data)).thenReturn(data);
		
		//Mockito.verify(metaDataService, times(1)).save(data);
		
	}

}
