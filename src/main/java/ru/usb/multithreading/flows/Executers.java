package ru.usb.multithreading.flows;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.usb.multithreading.CallableThread;
import ru.usb.multithreading.restclient.StudyRest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class Executers {

    @Autowired
    StudyRest studyRest;

    Logger logger = LoggerFactory.getLogger(Executers.class);

    //Кол-во потоков задаем
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    //Для получения информации из CallableClass
    List<CallableThread> tasks = new ArrayList<>();

    private Thread thread;

    public void getTask(String url) {

        logger.info("Запуск потока");
        CountDownLatch cdl = new CountDownLatch(5);
        executorService.execute(new MyThread(cdl, url));
        logger.info("Поток завершен");
//        executorService.shutdown();


    }

    class MyThread implements Runnable {
        String uRL;
        CountDownLatch latch;

        MyThread(CountDownLatch c, String urls) {
            latch = c;
            uRL = urls;
            new Thread(this);
        }

        public void run() {
            logger.info("Запуск getREcs потока id={}", Thread.currentThread().getId());
            studyRest.getREcs(uRL);
            logger.info("Поток getREcs завершен id={}", Thread.currentThread().getId());
        }
    }


}
