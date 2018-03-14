package cn.com.transcosmos.training.mapper;

import cn.com.transcosmos.training.domain.Condition;
import cn.com.transcosmos.training.domain.Person;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface PersonMapper {

	/**
	 * 增
	 */
	@InsertProvider(type = PersonSqlProvider.class, method = "insert")
	int insert(Person person);

	/**
	 * 删
	 */
	@Delete({ "delete from tbl_person", "where person_id = #{personId,jdbcType=VARCHAR}" })
	int delete(String personId);

	/**
	 * 改
	 */
	@UpdateProvider(type = PersonSqlProvider.class, method = "update")
	int update(Person person);

	/**
	 * 查
	 */
	@SelectProvider(type = PersonSqlProvider.class, method = "select")
	List<Person> select(Condition condition);
}