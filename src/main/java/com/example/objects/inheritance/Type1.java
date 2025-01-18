package com.example.objects.inheritance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Type1 extends Parent {
 
    private String name;

    @Override
    public boolean customValidation() {
        if (name == null) {
            return false;
        }

        return true;
    }

    
}
