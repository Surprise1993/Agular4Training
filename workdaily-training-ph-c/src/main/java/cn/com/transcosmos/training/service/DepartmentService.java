package cn.com.transcosmos.training.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.transcosmos.training.domain.Department;
import cn.com.transcosmos.training.mapper.DepartmentMapper;

/**
 * @author NRI
 */
@Service
@Transactional
public class DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	public List<Department> selectAllDepartments() {
		return departmentMapper.selectByExample();
	}

	public Department selectDepartmentById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertDepartment(Department department) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteDepartmentById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}





}
