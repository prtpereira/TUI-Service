package com.tui.quotegarden.controllers;

import com.tui.quotegarden.model.Quote;
import com.tui.quotegarden.services.QuotesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api")
public class QuotesController {
    private final QuotesService quotesService;

    QuotesController(QuotesService quotesService) {
        this.quotesService = quotesService;
    }

    @GetMapping("/quotes")
    public ResponseEntity<Object> getQuote(@RequestParam(required = false) String id,
                                           @RequestParam(required = false) String author,
                                           Pageable page) throws Exception {

        if (id != null) {
            Optional<Quote> optionalQuote = quotesService.getQuoteByExternalId(id);

            if (optionalQuote.isPresent())
                return ResponseEntity.ok().body(optionalQuote.get());
            else {

                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("message", "Quote with id '" + id + "' not found.");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
            }
        } else {
            if (author != null) {
                Page<Quote> quotes = quotesService.getQuotesByAuthor(author, page);
                return ResponseEntity.ok().body(quotes);

            } else {
                Page<Quote> pQuotes = quotesService.getQuotes(page);
                return ResponseEntity.ok().body(pQuotes);
            }
        }
    }
}