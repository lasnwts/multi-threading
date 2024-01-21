package ru.usb.multithreading.restclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class StudyRest {


    Logger logger = LoggerFactory.getLogger(StudyRest.class);

    RestTemplate restTemplate = new RestTemplate();


    public String getREcs(String urlReuest) {
        // create headers
        HttpHeaders headers = new HttpHeaders();

        // create request
        HttpEntity request = new HttpEntity(headers);

        logger.info("Запрос getREcs , url={}", urlReuest);

        try {
            Thread.sleep(8000);
        } catch(InterruptedException ex) {}

        // make a request
        ResponseEntity<String> response = restTemplate.exchange(urlReuest,
                HttpMethod.GET, request,
                String.class);
        //MtsNumber[] mtsNumbers= response.getBody();
        String recordCalls = response.getBody();
        logger.info("<<<<<<<<Ответ Response code:{}", response.getStatusCode());
        logger.info("Response body={}", recordCalls);

        try {

            Thread.sleep(2500);
        } catch(InterruptedException ex) {}

        return recordCalls;
    }

    //https://jsonplaceholder.typicode.com/posts/1/comments
}
