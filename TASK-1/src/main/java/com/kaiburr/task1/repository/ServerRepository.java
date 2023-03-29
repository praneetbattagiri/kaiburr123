package com.kaiburr.task1.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.kaiburr.task1.model.Server;



@Repository
public interface ServerRepository extends MongoRepository<Server, String> {

	List<Server> findByName(String nm);
}