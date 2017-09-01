package com.example.test.demo.test.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.demo.test.crudrepository.MetaDataRepository;
import com.example.test.demo.test.model.MetaData;
import com.example.test.demo.test.service.MetaDataService;

@Service
public class MetaDataServiceImpl implements MetaDataService{

	private MetaDataRepository metaDataRepository;
	
	@Autowired
	public MetaDataServiceImpl(MetaDataRepository metaDataRepository) {
		
		this.metaDataRepository = metaDataRepository;
	}
	
	@Override
	public MetaData save(MetaData m) {
		UUID uniqueKey = UUID.randomUUID();
		
		MetaData m2 = new MetaData(m.getFileContentType(),m.getFileName(),m.getSize(),m.getFileData());
		m2.setId(uniqueKey.getLeastSignificantBits());
		return metaDataRepository.save(m2);
	}

}
