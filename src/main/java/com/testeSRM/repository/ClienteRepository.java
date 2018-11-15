package com.testeSRM.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testeSRM.model.ClienteVO;

public interface ClienteRepository extends MongoRepository<ClienteVO, String> {
}
