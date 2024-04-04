package ru.video.traffic.balancer.videoservice.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.video.traffic.balancer.videoservice.service.impl.VideoServiceImpl;

import java.util.logging.Logger;

@RestController
@RequestMapping("/load")
public class LoadTestController {

    private static final Logger LOG = Logger.getLogger(LoadTestController.class.getName());

    @GetMapping
    public void doSomething() throws InterruptedException {
        LOG.info("hey, I'm doing something");
        Thread.sleep(1000);
    }
}