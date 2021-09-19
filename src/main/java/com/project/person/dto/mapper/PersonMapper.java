package com.project.person.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.project.person.dto.request.PersonDTO;
import com.project.person.entities.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}
