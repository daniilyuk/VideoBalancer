package ru.video.traffic.balancer.videoservice.service.impl;

import org.springframework.stereotype.Service;
import ru.video.traffic.balancer.videoservice.dto.VideoRequest;
import ru.video.traffic.balancer.videoservice.service.VideoService;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class VideoServiceImpl implements VideoService {
    private final Object lock = new Object();
    private final Map<VideoRequest, Integer> links = new HashMap<>();
    private final String CDN_HOST = "app.config.CDN_HOST";
    private static final Logger LOGGER = Logger.getLogger(VideoServiceImpl.class.getName());
    public String balanceTraffic(VideoRequest request){
        synchronized (lock) {
            LOGGER.info("Отправлен ответ");
            if (!links.containsKey(request)) {
                links.put(request, 1);
            } else {
                links.put(request, links.get(request) + 1);
            }
            if (links.get(request) % 10 == 0){
                return request.getUrl();
            }

            return "http://" + CDN_HOST + "/" + request.getUrl()
                    .substring(request.getUrl().indexOf("//")+2);
        }
    }
}
