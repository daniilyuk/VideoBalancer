package ru.video.traffic.balancer.videoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.video.traffic.balancer.videoservice.config.VideoWebClient;

import java.util.stream.Stream;

@SpringBootApplication
public class VideoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoServiceApplication.class, args);

//		VideoWebClient webClient = new VideoWebClient();
//		for (int i = 0; i < 10; i++) {
//			Thread thread = new Thread(() -> {
//				// Отправляем 100 запросов в каждом потоке
//				for (int j = 0; j < 10; j++) {
//					String data = webClient.balanceTraffic("http://s1.origin-cluster/video/1488/xcg2djHckad.m3u8");
//					System.out.println(data);
//				}
//			});
//			thread.start();
//		}
	}
}
