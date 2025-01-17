package com.example.controllers.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.controllers.example.request.ExamplePost;
import com.example.objects.Example;
import com.example.objects.inheritance.ObjectType;


@RestController
@RequestMapping("/api/v1/example")
public class ExampleController {

  private static Logger logger = LoggerFactory.getLogger(ExampleController.class);

  /**
   * Example GET API
   */
  @RequestMapping(method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public Example getExample() {

    Example example = new Example();
    example.setName("Example name");
    example.setAge(18);

    return example;
  }

  /**
   * Example GET API
   */
  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.OK)
  public String postExample(@RequestBody ExamplePost ExamplePost) {

    logger.info(ExamplePost.getType().getName());
    // logger.info(ExamplePost.getContent().toString());

    return "test";
  }

}
