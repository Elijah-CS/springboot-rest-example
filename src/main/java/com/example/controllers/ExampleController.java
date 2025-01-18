package com.example.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.controllers.BaseController;
import com.example.objects.inheritance.Parent;


@RequestMapping("/api/v1/example")
@RestController
public class ExampleController extends BaseController<Parent> {

}
