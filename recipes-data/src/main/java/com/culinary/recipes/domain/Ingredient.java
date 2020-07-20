package com.culinary.recipes.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ingredient extends BaseDomain {

    @Column(nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private IngredientType type;

    @ManyToOne
    private Recipe recipe;
}
