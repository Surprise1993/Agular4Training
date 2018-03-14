package cn.com.transcosmos.training.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import cn.com.transcosmos.training.domain.Condition;
import cn.com.transcosmos.training.domain.Person;
import cn.com.transcosmos.training.domain.PersonFor366;

public interface PersonFor366Mapper {
	/**
	 * 增
	 */
	@InsertProvider(type = PersonFor366SqlProvider.class, method = "insert")
	int insert(PersonFor366 person);

	/**
	 * 删
	 */
	@Delete({ "delete from tbl_person", "where person_id = #{personId,jdbcType=VARCHAR}" })
	int delete(String personId);

	/**
	 * 改
	 */
	@UpdateProvider(type = PersonFor366SqlProvider.class, method = "update")
	int update(PersonFor366 person);

	/**
	 * 查
	 */
	@SelectProvider(type = PersonFor366SqlProvider.class, method = "select")
	List<PersonFor366> select(Condition condition,List<String>DateList);
}
