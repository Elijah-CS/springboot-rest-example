package com.base.objects;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AuditModel {
 
    @Schema(accessMode = AccessMode.READ_ONLY)
    private String id;

    @Schema(accessMode = AccessMode.READ_ONLY)
    private Date createdAt;

    public abstract boolean validate();
}
