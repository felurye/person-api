package com.project.person.services;

import static com.project.person.utils.PersonUtils.createFakeDTO;
import static com.project.person.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.person.dto.mapper.PersonMapper;
import com.project.person.dto.request.PersonDTO;
import com.project.person.dto.response.MessageResponseDTO;
import com.project.person.entities.Person;
import com.project.person.repositories.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@Mock
	private PersonRepository personRepository;

	@Mock
	private PersonMapper personMapper;

	@InjectMocks
	private PersonService personService;

	@Test
	void testGivenPersonDTOThenReturnSuccessSavedMessage() {
		PersonDTO personDTO = createFakeDTO();
		Person expectedSavedPerson = createFakeEntity();

		when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
		when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

		MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
		MessageResponseDTO successMessage = personService.create(personDTO);

		assertEquals(expectedSuccessMessage, successMessage);
	}

	private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
		return MessageResponseDTO.builder().message("Person successfully created with ID " + savedPersonId).build();
	}

}
