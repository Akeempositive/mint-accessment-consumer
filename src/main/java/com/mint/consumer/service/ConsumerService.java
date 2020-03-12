package com.mint.consumer.service;

import com.mint.consumer.model.VerifyCardResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "com.ng.vela.even.card_verified")
    public void listenWithHeaders(
            @Payload String received,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(
                "Received Message: succesful " + received
                        + "from partition: " + partition);
    }
}