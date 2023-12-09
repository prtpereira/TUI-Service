package com.tui.quotegarden.integration.controllers;

import com.tui.quotegarden.controllers.QuotesController;
import com.tui.quotegarden.services.QuotesService;
import com.tui.quotegarden.utils.DatabaseMock;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@AutoConfigureMockMvc
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuotesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private DatabaseMock databaseMock;

    private final QuotesController quotesController;

    @MockBean
    private QuotesService quotesService;

    public QuotesControllerTest(QuotesController quotesController) {
        this.quotesController = new QuotesController(quotesService);;
        this.quotesService = Mockito.mock(QuotesService.class);
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(quotesController).build();
        databaseMock.populateDB();
    }

    private final static String GET_QUOTES_BY_ID_ENDPOINT = "/api/quotes?id=";
    private final static String GET_QUOTES_BY_AUTHOR_ENDPOINT = "api/quotes?author=Gates&page=2&size=5";
    private final static String GET_ALL_QUOTES_ENDPOINT = "/api/quotes?page=1&size=10";


    @Test
    public void getQuotesById() throws Exception {
        final String BILL_GATES_FEAR_QUOTE_EID = "5eb17aaeb69dc744b4e7629e";

        mockMvc.perform(
            MockMvcRequestBuilders
                .get(GET_QUOTES_BY_ID_ENDPOINT + BILL_GATES_FEAR_QUOTE_EID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.author", Matchers.is("Bill Gates")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.genre", Matchers.is("fear")))
            .andExpect(MockMvcResultMatchers.jsonPath("$._id", Matchers.is("5eb17aaeb69dc744b4e7629e")));
    }

    @Test
    public void getQuotesByAuthor() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get(GET_QUOTES_BY_AUTHOR_ENDPOINT)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.aMapWithSize(10)));
    }

    @Test
    public void getAllQuotes() throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get(GET_ALL_QUOTES_ENDPOINT)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.aMapWithSize(15)));
    }

}
