package cn.com.transcosmos.training.mapper;

import cn.com.transcosmos.training.domain.Condition;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface ConditionMapper {

    /**
     * 检索条件删除
     */
	@UpdateProvider(type=ConditionSqlProvider.class, method="delete")
    int delete(String selectId);

    /**
     * 检索条件插入
     */
    @InsertProvider(type=ConditionSqlProvider.class, method="insert")
    int insert(Condition condition);


    /**
     * 检索条件查询
     */
    @SelectProvider(type=ConditionSqlProvider.class, method="select")
    List<Condition> select();

    /**
     * 检索条件更新
     */
    @UpdateProvider(type=ConditionSqlProvider.class, method="update")
    int updateByExample(Condition condition);

}