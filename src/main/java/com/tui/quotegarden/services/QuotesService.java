package com.tui.quotegarden.services;

import com.tui.quotegarden.model.Quote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface QuotesService {

    public Optional<Quote> getQuoteByExternalId(String externalId);

    public Page<Quote> getQuotesByAuthor(String author, Pageable page) throws Exception;

    public Page<Quote> getQuotes(Pageable page);
}
