package com.springboot.kafka.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author prabhakar, @Date 12-08-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class My_topicEvent {

    private String topic_id;
    private LocalDateTime dateTime;
}
