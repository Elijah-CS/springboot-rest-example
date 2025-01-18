package com.example.objects;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.base.objects.AuditModel;
import com.example.objects.inheritance.Parent;
import com.example.serialization.ParentConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "examples")
public class Example extends AuditModel {

    private String example;

    @Convert(converter = ParentConverter.class)
    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Parent parent;

    @Override
    public boolean validate() {
        return parent.validate();
    }
}
