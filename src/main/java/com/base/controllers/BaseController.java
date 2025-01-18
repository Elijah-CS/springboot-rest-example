package com.base.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.base.objects.AuditModel;

public class BaseController<T extends AuditModel> {

    /**
     * The POST API
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public T postHandler(@RequestBody T postBody) {

        return null;
    }

    /**
     * The GET API
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public T getHandler(@PathVariable String id) {
        return null;
    }

    /**
     * The GET all API
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<T> getAllHandler() {
        return new ArrayList<T>();
    }

    /**
     * The PATCH API
     */
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public T patchHandler(@PathVariable String id) {
        return null;
    }

    /**
     * The DELETE API
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHandler(@PathVariable String id) {
    }

}
