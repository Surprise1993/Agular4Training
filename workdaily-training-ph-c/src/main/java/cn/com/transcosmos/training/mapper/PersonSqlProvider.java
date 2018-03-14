package cn.com.transcosmos.training.mapper;

import cn.com.transcosmos.training.domain.Condition;
import cn.com.transcosmos.training.domain.Person;
import org.apache.ibatis.jdbc.SQL;

public class PersonSqlProvider {

	/**
	 * 查
	 */
	public String select(Condition condition) {
		String sql;
		sql = "SELECT tbl_plan1.person_id,\r\n" + 
				"       tbl_person.person_name,\r\n" + 
				"       tbl_person.job,\r\n" + 
				"       tbl_plan1.plan_date,\r\n" + 
				"       tbl_project.pro_name\r\n" + 
				"FROM tbl_plan1\r\n" + 
				"  INNER JOIN tbl_project ON tbl_plan1.pro_id = tbl_project.pro_id\r\n" + 
				"  INNER JOIN tbl_person ON tbl_plan1.person_id = tbl_person.person_id\r\n" + 
				"WHERE tbl_plan1.del_flag = '0'\r\n" +
				"and tbl_plan1.plan_date between '%1$s' and '%2$s'\r\n";
		if (condition.getDeptId()!=null) {
			sql = sql + "and tbl_person.dept_id = '%3$d'\r\n";
		}
		if (condition.getProId()!=null) {
			sql = sql + "and tbl_plan1.pro_id = '%4$s'\r\n";
		}
		if (condition.getPersonName()!=null && condition.getPersonName()!="") {
			sql = sql + "and tbl_person.person_name like '%5$s'";
		}
		sql = String.format(sql, condition.getStartDate(), condition.getEndDate(), condition.getDeptId(),
				condition.getProId(), condition.getPersonName());
		System.out.print(sql);
		return sql;
	}

	/**
	 * 改
	 */
	public String update(Person person) {
		SQL sql = new SQL();

		return sql.toString();
	}

	/**
	 * 增
	 */
	public String insert(Person person) {
		SQL sql = new SQL();

		return sql.toString();
	}

}