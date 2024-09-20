package com.example.controllers;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/example")
public class ExampleController {

  /**
   * Example GET API
   */
  @GetMapping("/")
  public String getExample() {

    return "Hello world";
  }

  @GetMapping(path = "/stream-flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<String> streamFlux() {
    return Flux.interval(Duration.ofSeconds(1))
        .map(sequence -> "Flux - " + LocalTime.now().toString());
  }

}