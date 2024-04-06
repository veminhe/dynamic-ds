package com.hmblogs.backend.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 *
 * @description:  kafka 消费者
 * @copyright: @Copyright (c) 2022
 * @company: hmblogs
 * @author: heming
 * @version: 1.0.0
 * @createTime: 2024-01-18 8:31
 */
@Component
@Slf4j
public class kafkaConsumerListenerExample {

    //@KafkaListener(topics = "test", groupId = "0")
    public void consume(ConsumerRecord<?, ?> record) {
        Optional<?> value = Optional.ofNullable(record.value());
        // 进行消息处理逻辑
        log.info("print message: " + value);
    }
}


