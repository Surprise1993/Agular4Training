package cn.com.transcosmos.training.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.transcosmos.training.domain.Condition;
import cn.com.transcosmos.training.domain.Person;
import cn.com.transcosmos.training.domain.PersonFor366;
import cn.com.transcosmos.training.service.PersonFor366Service;

@RestController
public class PersonFor366Controller {

	@Autowired
	private PersonFor366Service personFor366Service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/personsFor366")
	public List<Map<String, String>> selectAllPersons(@Valid @RequestBody Condition condition) {
		return personFor366Service.selectAllPersons(condition);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/insertPersonFor366")
	public int insertPersonn(@Valid @RequestBody PersonFor366 personFor366) {
		return personFor366Service.insertPerson(personFor366);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updatePersonFor366")
	public int updatePerson(@Valid @RequestBody PersonFor366 personFor366) {
		return personFor366Service.updatePerson(personFor366);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deletePersonFor366/{id}")
	public int deletePersonByRcd(@PathVariable("id") String id) {
		return personFor366Service.deletePersonById(id);
	}
	
}
