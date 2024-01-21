package ru.usb.multithreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.usb.multithreading.flows.Executers;
import ru.usb.multithreading.restclient.StudyRest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootApplication
public class MultiThreadingApplication implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(MultiThreadingApplication.class);


	@Autowired
	StudyRest studyRest;

	@Autowired
	Executers  executers;

    public static void main(String[] args) {
        SpringApplication.run(MultiThreadingApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

		logger.info("Executers start");
	    executers.getTask("https://jsonplaceholder.typicode.com/posts/1");
		executers.getTask("https://jsonplaceholder.typicode.com/posts/2");
		executers.getTask("https://jsonplaceholder.typicode.com/posts/3");
		executers.getTask("https://jsonplaceholder.typicode.com/posts/4");
		executers.getTask("https://jsonplaceholder.typicode.com/posts/5");
		executers.getTask("https://jsonplaceholder.typicode.com/posts/6");
		executers.getTask("https://jsonplaceholder.typicode.com/posts/7");
		executers.getTask("https://jsonplaceholder.typicode.com/posts/7");
		executers.getTask("https://jsonplaceholder.typicode.com/posts");
		executers.getTask("https://jsonplaceholder.typicode.com/comments?postId=1");
		executers.getTask("https://jsonplaceholder.typicode.com/posts/1/comments");
		logger.info("Executers stop");

/*
		//Кол-во потоков задаем
        ExecutorService executorService = Executors.newFixedThreadPool(10);

		//Для получения информации из CallableClass
		List<Future<Long>> tasks = new ArrayList<>();

		//Видео по задаче на YouTube
        logger.info("URL::https://www.youtube.com/watch?v=GtHe_wzJsWo");

		String s = studyRest.getREcs("https://jsonplaceholder.typicode.com/posts/1/comments");
		//https://jsonplaceholder.typicode.com/comments?postId=1
		//https://jsonplaceholder.typicode.com/posts
		//https://jsonplaceholder.typicode.com/posts/1


		logger.info("s={}", s);

        logger.info("---------------Старт-----------------");

		//Задаем запуск 3-х задач
        for (int i = 0; i < 3; i++) {
            CallableThread callableThread = new CallableThread();

			//submit - получаем подписку на поток и можем обмениваться информацией
            Future<Long> submit = executorService.submit(callableThread);
			tasks.add(submit);
		}

		for (Future<Long> f: tasks){
			f.get();
		}

		//Обязательно закрытие потоков
        executorService.shutdown();
        logger.info("---------------Стоп -----------------");

		logger.info("По другому запускаем.........................................");
		//Кол-во потоков задаем
		ExecutorService executorService2 = Executors.newFixedThreadPool(10);

		//Для получения информации из CallableClass
		List<CallableThread> tasks2 = new ArrayList<>();

		//Видео по задаче на YouTube
		logger.info("URL::https://www.youtube.com/watch?v=GtHe_wzJsWo");

		logger.info("---------------Старт-----------------");

		//Задаем запуск 3-х задач
		for (int i = 0; i < 3; i++) {
			CallableThread callableThread = new CallableThread();
			tasks2.add(callableThread);
		}

		//Так ждем все ответы
		List<Future<Long>> futures = executorService2.invokeAll(tasks2);

		//Вот так ждем только один любой поток
		Long futureAny = executorService2.invokeAny(tasks2);

		//Дожидаемся всех ответов
		for (Future<Long> future: futures){
			logger.info("future.get()={}", future.get());
		}

		//Обязательно закрытие потоков
		executorService.shutdown();
		logger.info("---------------Стоп -----------------");
*/

	}
}
