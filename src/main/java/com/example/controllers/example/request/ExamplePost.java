package com.example.controllers.example.request;

import com.example.objects.inheritance.ObjectType;
// import com.example.objects.inheritance.Parent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamplePost {
    
    private ObjectType type;

    // private Parent content;
}
