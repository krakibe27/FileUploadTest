package com.example.test.demo.test.crudrepository;



import com.example.test.demo.test.model.MetaData;

import org.springframework.data.repository.CrudRepository;


public interface MetaDataRepository extends CrudRepository<MetaData, Long>{

	@SuppressWarnings("unchecked")
	MetaData save(MetaData m);

}
