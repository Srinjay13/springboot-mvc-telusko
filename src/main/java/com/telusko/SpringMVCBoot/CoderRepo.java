package com.telusko.SpringMVCBoot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telusko.SpringMVCBoot.model.Coder;

public interface CoderRepo extends JpaRepository<Coder, Integer>{

	List<Coder> findByCoderName(String coderName); //Query DSL
	
	//In JPQL we need to pass the name of the entity and not the table, remember that and it is case sensitive
	@Query("from Coder where coderName = :coderName")
	List<Coder> find(String coderName);

}
