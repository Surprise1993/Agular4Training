package cn.com.transcosmos.training.mapper;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import cn.com.transcosmos.training.domain.Condition;
import cn.com.transcosmos.training.domain.Person;

public class PersonFor366SqlProvider {
	/**
	 * 查
	 */
	public String select(Condition condition, List<String> dateList) {
		String sql;
		sql = "SELECT tbl_person.person_name as personname,tbl_person.job,tbl_plan2." 
		+ dateList.get(dateList.size()-1).replace(dateList.get(dateList.size()-1).substring(0, 4), "PRO_") 
		+ " as " + dateList.get(dateList.size()-1).replace(dateList.get(dateList.size()-1).substring(0, 4), "PRO_").replaceAll("_", "") ;
		for (int i = dateList.size() -2; i >= 0; i--) {
			String nowDay = dateList.get(i).substring(0, 4);
			sql = sql + ", tbl_plan2." + dateList.get(i).replace(nowDay, "PRO_");
		} 
		if (condition.getDeptId() != null && condition.getDeptId().toString() != "") {
			sql = sql
					+ " from tbl_plan2 , tbl_person where tbl_person.person_id = tbl_plan2.person_id and tbl_person.dept_id ="
					+"'" + condition.getDeptId() + "'";
		} else {
			sql = sql + " from tbl_plan2 , tbl_person where tbl_person.person_id = tbl_plan2.person_id";
		}

		if (condition.getPersonName() != null && condition.getPersonName() != "") {
			sql = sql + " and tbl_person.person_name like " + "'" + condition.getPersonName() + "'";
		}

		if (condition.getProId() != null && condition.getProId() != "") {
			String baseSql = sql;
			String nowBaseDay = dateList.get(dateList.size()-1).substring(0, 4);
			sql = sql + " and tbl_plan2." + dateList.get(dateList.size()-1).replace(nowBaseDay, "PRO_") + " = " + "'" + condition.getProId() + "'";
			for (int i = dateList.size() - 2; i >= 0; i--) {
				String nowDay = dateList.get(i).substring(0, 4);
				sql =sql + " union " + baseSql + " and tbl_plan2." + dateList.get(i).replace(nowDay, "PRO_") + " = " + "'" + condition.getProId()+ "'";
			}

		}
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