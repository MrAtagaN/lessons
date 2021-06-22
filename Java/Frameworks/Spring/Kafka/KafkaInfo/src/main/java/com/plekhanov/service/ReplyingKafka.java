package com.plekhanov.service;

import org.springframework.kafka.requestreply.AggregatingReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;

/**
 * Классы для отправки сообщений и получения ответа по заголовкам сообщений
 */
public class ReplyingKafka {

    public void send(String message) {
        ReplyingKafkaTemplate replyingKafkaTemplate;
        AggregatingReplyingKafkaTemplate aggregatingReplyingKafkaTemplate;
    }
}
