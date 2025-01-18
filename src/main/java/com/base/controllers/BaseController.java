package com.base.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.base.objects.AuditModel;

public class BaseController<T extends AuditModel> {

    private BaseService<T> baseService;

    @Autowired
    public BaseController(BaseService<T> baseService) {
        this.baseService = baseService;
    }

    /**
     * The POST API
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public T postHandler(@RequestBody T postBody) {
        return baseService.create(postBody);
    }

    /**
     * The GET API
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public T getHandler(@PathVariable String id) {
        return baseService.find(id);
    }

    /**
     * The GET all API
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<T> getAllHandler() {
        return baseService.findAll();
    }

    /**
     * The PATCH API
     */
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public T patchHandler(@PathVariable String id, @RequestBody T patchBody) {

        T oldObj = baseService.find(id);

        if (oldObj == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Failed to find object with id '" + id + "'");
        }

        patchBody.setId(oldObj.getId());
        patchBody.setCreatedAt(oldObj.getCreatedAt());

        return baseService.create(patchBody);
    }

    /**
     * The DELETE API
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHandler(@PathVariable String id) {
        baseService.delete(id);
    }

}
