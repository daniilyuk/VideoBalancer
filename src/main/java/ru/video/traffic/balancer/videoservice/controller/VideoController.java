package ru.video.traffic.balancer.videoservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.video.traffic.balancer.videoservice.dto.VideoRequest;
import ru.video.traffic.balancer.videoservice.exception.InvalidLinkException;
import ru.video.traffic.balancer.videoservice.service.impl.VideoServiceImpl;

import java.util.Objects;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class VideoController {
    private final VideoServiceImpl videoServiceImpl;
    private static final Logger LOGGER = Logger.getLogger(VideoServiceImpl.class.getName());

    public VideoController(VideoServiceImpl videoServiceImpl) {
        this.videoServiceImpl = videoServiceImpl;
    }

    @PostMapping("/links")
    public ResponseEntity<String> balanceTraffic(@RequestBody @Valid VideoRequest request,
                                                 BindingResult result) {
        LOGGER.info("Получен запрос");
        if (result.hasErrors()) {
            throw new InvalidLinkException(Objects.requireNonNull(result.getFieldError()).
                    getDefaultMessage());
        }
        return ResponseEntity.ok(videoServiceImpl.balanceTraffic(request));
    }
}
