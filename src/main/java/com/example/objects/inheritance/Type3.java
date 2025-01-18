package com.example.objects.inheritance;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Type3 extends Parent {
    private Date date;

    @Override
    public boolean customValidation() {
        if (date == null) {
            return false;
        }

        return true;
    }
}
