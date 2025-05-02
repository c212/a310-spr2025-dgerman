package com.devcases.springboot.crud.library.repository;

import com.devcases.springboot.crud.library.entity.Quote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {
}
