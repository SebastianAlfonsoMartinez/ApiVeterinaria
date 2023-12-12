package com.veterinaria.apiveterinaria.domain.entityDto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DoctorDto(
        Integer id,
        String name,
        String numberLicence,
        String email,
        String numberPhone
) {
}
