package ru.video.traffic.balancer.videoservice.exception;

public class InvalidLinkException extends RuntimeException{
    public InvalidLinkException(String message) {
        super(message);
    }
}
