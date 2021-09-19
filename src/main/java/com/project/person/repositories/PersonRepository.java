package com.project.person.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.person.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
