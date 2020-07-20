package com.culinary.recipes.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@Data
public class Note extends BaseDomain {

    @Lob
    private String description;
}
