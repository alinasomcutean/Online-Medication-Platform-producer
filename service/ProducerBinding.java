package com.example.Producer.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProducerBinding {

    @Output("sendingChannel")
    MessageChannel sending();
}
