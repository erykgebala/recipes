package com.culinary.recipes.converter;

import java.util.List;

public interface AbstractConverter<DOMAIN, DTO> {

    DTO toDto(DOMAIN domain);

    List<DTO> toDto(List<DOMAIN> domain);

    DOMAIN toDomain(DTO dto);

    List<DOMAIN> toDomain(List<DTO> dto);
}
