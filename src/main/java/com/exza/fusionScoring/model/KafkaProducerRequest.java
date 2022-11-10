package com.exza.fusionScoring.model;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KafkaProducerRequest {

    private  String processInstanceBusinessKey;
    private String frontUrl;
    private String rearUrl;
    private String step;
}
