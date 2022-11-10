package com.exza.fusionScoring.listener;

import com.exza.fusionScoring.model.KafkaProducerRequest;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@EnableKafka
@Component
public class ExzaFusionListener {
    @KafkaListener(topics = "ExzafusionRequestt", groupId = "group_id" ,containerFactory = "concurrentKafkaListenerContainerFactory")
    public void  consume(@Payload KafkaProducerRequest kafkaProducerRequest, @Headers MessageHeaders headers) throws Exception {
 this.test(kafkaProducerRequest);


        System.out.println(kafkaProducerRequest.toString());
    }



   void  test(KafkaProducerRequest kafkaProducerRequest)
    {
        try (BufferedInputStream   in = new BufferedInputStream(new URL(kafkaProducerRequest.getFrontUrl()).openStream());

        FileOutputStream fileOutputStream = new FileOutputStream("FILE_NAME1.png")) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
