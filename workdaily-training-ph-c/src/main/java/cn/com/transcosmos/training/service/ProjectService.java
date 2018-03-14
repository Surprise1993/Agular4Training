package cn.com.transcosmos.training.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.transcosmos.training.domain.Project;
import cn.com.transcosmos.training.mapper.ProjectMapper;

/**
 * @author NRI
 */
@Service
@Transactional
public class ProjectService {

	@Autowired
	private ProjectMapper projectMapper;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	public List<Project> selectAllProjects() {
		// TODO Auto-generated method stub
		return projectMapper.selectByExample();
	}

	public Project selectProjectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertProject(Project project) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateProject(Project project) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteProjectById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}





}
