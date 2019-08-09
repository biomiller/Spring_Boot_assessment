package com.bae.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bae.entity.Search;

public interface SearchRepository extends MongoRepository<Search,Long> {}