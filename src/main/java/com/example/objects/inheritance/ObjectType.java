package com.example.objects.inheritance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

// @JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ObjectType {
    TYPE1("type1", Type1.class),
    TYPE2("type2", Type2.class),
    TYPE3("type3", Type3.class);

    private final String name;
    private final Class<? extends Parent> clazz;

    
    private ObjectType(String name, Class<? extends Parent> clazz) {  
        this.name = name;
        this.clazz = clazz;
    }

    public static ObjectType fromValue(String value) {
        System.out.println("HELLOOOOOOOOOOOOOO");

        for (ObjectType type: ObjectType.values()) {
            if (type.getName().equals(value)) {
                return type;
            }
        }
        return null;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public Class<? extends Parent> getClazz() {
        return clazz;
    }

    @Override
    public String toString() {
        return name;
    }
}
