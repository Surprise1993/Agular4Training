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
import cn.com.transcosmos.training.service.PersonService;

/**
 * @author NRI
 */
@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(method = RequestMethod.POST, value = "/persons")
	public List<Map<String, String>> selectAllPersons(@Valid @RequestBody Condition condition) {
		return personService.selectAllPersons(condition);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/insertPerson")
	public int insertPersonn(@Valid @RequestBody Person person) {
		return personService.insertPerson(person);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updatePerson")
	public int updatePerson(@Valid @RequestBody Person person) {
		return personService.updatePerson(person);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deletePerson/{id}")
	public int deletePersonByRcd(@PathVariable("id") String id) {
		return personService.deletePersonById(id);
	}

}
