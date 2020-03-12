package com.mint.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mint.consumer.model.VerifyCardResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.jvm.hotspot.utilities.Assert;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConsumerServiceTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Autowired
    private ConsumerService consumerService;

    //Unit Testing for JSonMapper for published message
    @Test
    void listenWithHeaders() throws JsonProcessingException {
        String received = "{ \"success\":true, \"payload\" : {\"scheme\" :\"mastercard\", \"bank\":\"FIRST\", \"type\":\"debit\"}}";
        VerifyCardResponse verifyCardResponse = consumerService.getResponseFromJson(received);
        Assert.that(verifyCardResponse.isSuccess(), "The API is not accessible. Third party api not valid/bad network connection");
        Map<String, String> payload = verifyCardResponse.getPayload();
        Assert.that(payload.get("scheme").equals("mastercard"), "The Scheme of 5399 is no longer mastercard. Probably an outdated result expected");
        Assert.that(payload.get("bank").equals("FIRST"), "The BIN of First bank is no longer 539923. Expectation and requirements has changed");
    }

}