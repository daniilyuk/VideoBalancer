package ru.video.traffic.balancer.videoservice.service;

import ru.video.traffic.balancer.videoservice.dto.VideoRequest;

public interface VideoService {
    String balanceTraffic(VideoRequest request);
}
