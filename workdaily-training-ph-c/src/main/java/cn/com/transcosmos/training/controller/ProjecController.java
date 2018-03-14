package cn.com.transcosmos.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.transcosmos.training.domain.Project;
import cn.com.transcosmos.training.service.ProjectService;


/**
 * @author NRI
 */
@RestController
public class ProjecController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(method = RequestMethod.GET, value = "/projects")
	public List<Project> selectAllProjects() {
		return projectService.selectAllProjects();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/project/{id}")
	public Project selectProjectByRcd(@PathVariable("id") String id) {
		return projectService.selectProjectById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/insertProject")
	public int insertProject(@Valid @RequestBody Project project) {
		return projectService.insertProject(project);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateProject")
	public int updateProject(@Valid @RequestBody Project project) {
		return projectService.updateProject(project);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteProject/{id}")
	public int deleteProjectById(@PathVariable("id") String id) {
		return projectService.deleteProjectById(id);
	}

}
