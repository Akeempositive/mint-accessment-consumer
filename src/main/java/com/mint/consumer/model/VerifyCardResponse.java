package com.mint.consumer.model;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.util.HashMap;
import java.util.Map;

public class VerifyCardResponse implements Deserializer {

    private boolean success;

    private Map<String, String> payload;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }

    public VerifyCardResponse(){
        this.success= false;
    }

    public String toString(){
        return "Successful";
    }

    @Override
    public void configure(Map configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        return null;
    }

    @Override
    public void close() {

    }
}