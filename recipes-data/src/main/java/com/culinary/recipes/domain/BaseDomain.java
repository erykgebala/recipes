package com.culinary.recipes.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
