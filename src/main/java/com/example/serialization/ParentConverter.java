package com.example.serialization;

import com.example.objects.inheritance.Parent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ParentConverter implements AttributeConverter<Parent, String> {

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Parent parent) {
        if (parent == null) {
            return null;
        }

        try {
            return mapper.writeValueAsString(parent);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public Parent convertToEntityAttribute(String dbParent) {
        return mapper.convertValue(dbParent, Parent.class);
    }
}