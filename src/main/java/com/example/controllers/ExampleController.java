package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.controllers.BaseController;
import com.base.controllers.BaseService;
import com.example.objects.Example;

import org.springframework.stereotype.Component;

@Component
public class ExampleController {


    @Service
    public class MyService extends BaseService<Example> {
        
        @Autowired
        public MyService(ExampleRepository exampleRepository) {
            super(exampleRepository);
        }
    }

    @RequestMapping("/api/v1/example")
    @RestController
    public class MyController extends BaseController<Example> {

        @Autowired
        public MyController(MyService myService) {
            super(myService);
        }

    }
}