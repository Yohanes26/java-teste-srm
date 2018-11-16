package com.testeSRM.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testeSRM.model.JurosVO;

public interface JurosRepository  extends MongoRepository<JurosVO, String> {

}
