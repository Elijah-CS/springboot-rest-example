package com.ev.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/example")
public class ChargingSessionsController {

  /**
   * Example GET API
   */
  @GetMapping("/")
  public String getExample() {

    return "Hello world";
  }

}