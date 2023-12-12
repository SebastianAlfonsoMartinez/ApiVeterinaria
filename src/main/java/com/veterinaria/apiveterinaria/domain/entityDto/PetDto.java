package com.veterinaria.apiveterinaria.domain.entityDto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PetDto(

        Integer id,
        String name,
        String type,
        int age

) {


}
