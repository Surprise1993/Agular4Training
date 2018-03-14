package cn.com.transcosmos.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.transcosmos.training.domain.Condition;
import cn.com.transcosmos.training.service.ConditionService;

/**
 * @author NRI
 */
@RestController
public class ConditionController {

	@Autowired
	private ConditionService conditionService;

	@RequestMapping(method = RequestMethod.GET, value = "/conditions")
	public List<Condition> selectAllConditions() {
		return conditionService.selectAllConditions();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/insertCondition")
	public int insertCondition(@Valid @RequestBody Condition condition) {
		return conditionService.insertCondition(condition);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateCondition")
	public int updateCondition(@Valid @RequestBody Condition condition) {
		return conditionService.updateCondition(condition);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteCondition/{id}")
	public int deleteConditionByRcd(@PathVariable("id") String id) {
		return conditionService.deleteConditionById(id);
	}

}
