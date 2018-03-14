package cn.com.transcosmos.training.mapper;

import cn.com.transcosmos.training.domain.Condition;

public class ConditionSqlProvider {

	/**
	 * 检索条件更新
	 */
	public String delete(String id) {
		String sql = "Update tbl_select set del_flag = '0' "
				+ "where select_id = %1$s";
		sql = String.format(sql, id);
		return sql;
	}

	/**
	 * 检索条件插入
	 */
	public String insert(Condition condition) {
		String sql;
		sql = "insert into tbl_select (select_name, " + "user_id, " + "period, " + "start_date, " + "end_date, "
				+ "dept_id, " + "pro_id, " + "person_name," + " use_date, " + "del_flag)" + "values ('%1$s',"
				+ "'%2$s'," + "'%3$s'," + "to_date('%4$s','yyyy-MM-dd')," + "to_date('%5$s','yyyy-MM-dd')," + "%6$d,"
				+ "'%7$s'," + "'%8$s'," + "to_timestamp('%9$s','yyyy-MM-dd hh24:mi:ss')," + "'%10$s')";
		sql = String.format(sql, condition.getSelectName(), condition.getUserId(), condition.getPeriod(),
				condition.getStartDate(), condition.getEndDate(), condition.getDeptId(), condition.getProId(),
				condition.getPersonName(), condition.getUseDate(), condition.getDelFlag());
		return sql;
	} 

	/**
	 * 检索条件查询
	 */
	public String select() {
		String sql = "select " + "select_id," + "select_name," + "user_id," + "period," + "start_date," + "end_date,"
				+ "dept_id," + "pro_id," + "person_name," + "use_date," + "del_flag" + " from tbl_select "+ "where del_flag='1' "+ "order by use_date DESC";
		return sql.toString();
	}

	/**
	 * 检索条件更新
	 */
	public String update(Condition condition) {
		System.out.print(condition);
		String sql = "Update tbl_select set " + "select_name = '%2$s'," + "user_id = '%3$s'," + "period = '%4$s',"
				+ "start_date = to_date('%5$s','yyyy-MM-dd')," + "end_date = to_date('%6$s','yyyy-MM-dd'),"
				+ "dept_id = %7$d," + "pro_id = '%8$s'," + "person_name = '%9$s',"
				+ "use_date = to_timestamp('%10$s','yyyy-MM-dd hh24:mi:ss')," + "del_flag = '%11$s'"
				+ "where select_id = %1$d";
		sql = String.format(sql, condition.getSelectId(), condition.getSelectName(), condition.getUserId(),
				condition.getPeriod(), condition.getStartDate(), condition.getEndDate(), condition.getDeptId(),
				condition.getProId(), condition.getPersonName(), condition.getUseDate(), condition.getDelFlag());

		return sql;
	}

}