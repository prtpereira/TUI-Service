package com.tui.quotegarden.repositories;

import com.tui.quotegarden.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface QuoteRepository extends MongoRepository<Quote, String> {

    Optional<Quote> findByExternalId(String externalId);

    Page<Quote> findByAuthor(String author, Pageable page);

}
