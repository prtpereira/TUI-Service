package com.tui.quotegarden.unit.services;

import com.tui.quotegarden.model.Quote;
import com.tui.quotegarden.repositories.QuoteRepository;
import com.tui.quotegarden.services.QuotesService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuotesServiceTest {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private QuotesService quotesService;

    @Test
    public void getQuoteById() {
        final String BILL_GATES_FEAR_QUOTE_EID = "5eb17aaeb69dc744b4e7629e";

        Optional<Quote> quote = quotesService.getQuoteByExternalId(BILL_GATES_FEAR_QUOTE_EID);
        Optional<Quote> internalQuote = quoteRepository.findByExternalId(BILL_GATES_FEAR_QUOTE_EID);

        Assertions.assertEquals(quote.get(), internalQuote.get());
    }
}