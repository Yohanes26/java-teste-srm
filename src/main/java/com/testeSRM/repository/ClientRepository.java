package com.testeSRM.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testeSRM.model.ClientVO;

public interface ClientRepository extends MongoRepository<ClientVO, String> {
}
