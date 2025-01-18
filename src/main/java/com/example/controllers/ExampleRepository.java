package com.example.controllers;

import com.base.db.BaseRepository;
import com.example.objects.Example;

import org.springframework.stereotype.Repository;


@Repository
public interface ExampleRepository extends BaseRepository<Example> {}