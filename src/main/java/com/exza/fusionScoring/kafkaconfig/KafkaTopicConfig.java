package com.exza.fusionScoring.kafkaconfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    NewTopic exzafusion() {
        return TopicBuilder.name("ExzafusionRequestt").build();
    }

    @Bean
    NewTopic hawkai() {
        return TopicBuilder.name("ExzafusionResponse").build();
    }

}
