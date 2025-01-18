package com.example.objects.inheritance;

import com.example.serialization.ParentDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(using = ParentDeserializer.class)
public abstract class Parent {
    private String family;

    @JsonIgnore
    public final boolean validate() {
        if (family == null) {
            return false;
        }

        if (!customValidation()) {
            return false;
        }

        return true;
    }

    @JsonIgnore
    public abstract boolean customValidation();
}
