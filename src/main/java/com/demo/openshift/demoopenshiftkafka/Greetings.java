package com.demo.openshift.demoopenshiftkafka;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Greetings {

    private long timestamp;
    private String message;

}
