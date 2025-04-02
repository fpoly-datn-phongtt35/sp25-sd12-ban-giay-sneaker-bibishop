package com.poly.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.PreUpdate;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SuperDTO {
    private Integer id;
    private LocalDate createDate;
    private LocalDate modifyDate;

    @PreUpdate
    protected void onUpdate() {
        this.modifyDate = LocalDate.now();
    }
    @PreUpdate
    protected void CreateUpdate() {
        this.createDate = LocalDate.now();
    }

}
