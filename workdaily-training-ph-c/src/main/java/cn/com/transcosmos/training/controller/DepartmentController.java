package cn.com.transcosmos.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.transcosmos.training.domain.Department;
import cn.com.transcosmos.training.service.DepartmentService;

/**
 * @author NRI
 */
@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(method = RequestMethod.GET, value = "/departments")
	public List<Department> selectAllDepartments() {
		return departmentService.selectAllDepartments();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/department/{id}")
	public Department selectDepartmentByRcd(@PathVariable("id") String id) {
		return departmentService.selectDepartmentById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/insertDepartment")
	public int insertDepartment(@Valid @RequestBody Department department) {
		return departmentService.insertDepartment(department);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateDepartment")
	public int updateDepartment(@Valid @RequestBody Department department) {
		return departmentService.updateDepartment(department);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteDepartment/{id}")
	public int deleteDepartmentByRcd(@PathVariable("id") String id) {
		return departmentService.deleteDepartmentById(id);
	}

}
