package com.mint.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mint.consumer.model.VerifyCardResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "com.ng.vela.even.card_verified")
    public void listenWithHeaders(
            @Payload String received,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) throws JsonProcessingException {
        VerifyCardResponse verifyCardResponse = objectMapper.readValue(received, VerifyCardResponse.class);
        System.out.println(
                "Received Message: succesful " + received
                        + "from partition: " + partition);
    }
}