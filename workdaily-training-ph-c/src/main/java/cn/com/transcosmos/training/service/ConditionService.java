package cn.com.transcosmos.training.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.transcosmos.training.domain.Condition;
import cn.com.transcosmos.training.mapper.ConditionMapper;

/**
 * @author NRI
 */
@Service
@Transactional
public class ConditionService {

	@Autowired
	private ConditionMapper conditionMapper;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	//查
	public List<Condition> selectAllConditions() {
		return conditionMapper.select();
	}
	//增
	public int insertCondition(Condition condition) {
		condition = addDate(condition);
		return conditionMapper.insert(condition);
	}
	//改
	public int updateCondition(Condition condition) {
		condition = addDate(condition);
		return conditionMapper.updateByExample(condition);
	}
	//删
	public int deleteConditionById(String id) {
		return conditionMapper.delete(id);
	}
	//添加起止日期
	public Condition addDate(Condition condition) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(d);
		if (condition.getPeriod().equals("1")) {
			condition.setStartDate(today);
			condition.setEndDate(getDateStr(today,15));
		}else if  (condition.getPeriod().equals("2")) {
			condition.setStartDate(today);
			condition.setEndDate(getDateStr(today,30));
		}else if  (condition.getPeriod().equals("3")) {
			condition.setStartDate(today);
			condition.setEndDate(getDateStr(today,60));
		}else if  (condition.getPeriod().equals("4")) {
			condition.setStartDate(today);
			condition.setEndDate(getDateStr(today,90));
		}else if  (condition.getPeriod().equals("5")) {
			if(condition.getStartDate()==null||condition.getEndDate()==null) {
				condition.setPeriod("1");
				condition.setStartDate(today);
				condition.setEndDate(getDateStr(today,15));
				return condition;
			}
		}
			return condition;
	}

	/**
	 * 获取指定日后 后 dayAddNum 天的 日期
	 * 
	 * @param day
	 *            日期，格式为String："2013-9-3";
	 * @param dayAddNum
	 *            增加天数 格式为int;
	 * @return
	 */
	public static String getDateStr(String day, int dayAddNum) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = null;
		try {
			nowDate = df.parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date newDate2 = new Date(nowDate.getTime() + dayAddNum * 24 * 60 * 60 * 1000);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateOk = simpleDateFormat.format(newDate2);
		return dateOk;
	}

}
