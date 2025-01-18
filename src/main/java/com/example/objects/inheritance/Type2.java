package com.example.objects.inheritance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Type2 extends Parent {
    private Integer number;

    @Override
    public boolean validate() {
        if (number == null) {
            return false;
        }

        if (number < 0) {
            return false;
        }

        return true;
    }
}
