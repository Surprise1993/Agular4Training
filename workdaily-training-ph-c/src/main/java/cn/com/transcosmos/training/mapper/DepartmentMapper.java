package cn.com.transcosmos.training.mapper;

import cn.com.transcosmos.training.domain.Department;
import cn.com.transcosmos.training.domain.DepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DepartmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dep
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    @SelectProvider(type=DepartmentSqlProvider.class, method="countByExample")
    long countByExample(DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dep
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    @DeleteProvider(type=DepartmentSqlProvider.class, method="deleteByExample")
    int deleteByExample(DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dep
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    @Delete({
        "delete from tbl_dep",
        "where dept_id = #{deptId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dep
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    @Insert({
        "insert into tbl_dep (dept_id, dept_name, ",
        "del_flag)",
        "values (#{deptId,jdbcType=INTEGER}, #{deptName,jdbcType=VARCHAR}, ",
        "#{delFlag,jdbcType=CHAR})"
    })
    int insert(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dep
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    @InsertProvider(type=DepartmentSqlProvider.class, method="insertSelective")
    int insertSelective(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dep
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    @SelectProvider(type=DepartmentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dept_name", property="deptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.CHAR)
    })
    List<Department> selectByExample();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dep
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    @Select({
        "select",
        "dept_id, dept_name, del_flag",
        "from tbl_dep",
        "where dept_id = #{deptId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dept_name", property="deptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.CHAR)
    })
    Department selectByPrimaryKey(Integer deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dep
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    @UpdateProvider(type=DepartmentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dep
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    @UpdateProvider(type=DepartmentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dep
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    @UpdateProvider(type=DepartmentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dep
     *
     * @mbg.generated Mon Feb 26 11:42:18 CST 2018
     */
    @Update({
        "update tbl_dep",
        "set dept_name = #{deptName,jdbcType=VARCHAR},",
          "del_flag = #{delFlag,jdbcType=CHAR}",
        "where dept_id = #{deptId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Department record);
}