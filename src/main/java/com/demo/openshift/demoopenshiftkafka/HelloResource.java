package com.demo.openshift.demoopenshiftkafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Optional.ofNullable;

@RestController
@Slf4j
public class HelloResource {

    @Autowired
    private GreetingsStreams greetingsStreams;

    @GetMapping("/greeting")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.info("Sending greetings {}", name);

        Greetings greetings = Greetings.builder()
                .message(name)
                .timestamp(System.currentTimeMillis())
                .build();

        MessageChannel messageChannel = greetingsStreams.outboundGreetings();
        messageChannel.send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());

        return "hello " + ofNullable(name).orElse("world");
    }
}
