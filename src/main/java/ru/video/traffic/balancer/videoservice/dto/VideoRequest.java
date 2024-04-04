package ru.video.traffic.balancer.videoservice.dto;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class VideoRequest {
    @URL(message = "Неправильная ссылка")
    String url;
}
