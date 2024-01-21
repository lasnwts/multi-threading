package ru.usb.multithreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Component
public class CallableThread implements Callable<Long> {

    Logger logger = LoggerFactory.getLogger(CallableThread.class);

    @Override
    public Long call() throws Exception {
        logger.info("Started :{}", Thread.currentThread().getId());
        Thread.sleep(1000 * Math.round(Math.random()*2));
        logger.info("Finished:{}", Thread.currentThread().getId());
        return Thread.currentThread().getId();
    }
}
