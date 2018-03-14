package cn.com.transcosmos.training.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.transcosmos.training.domain.Condition;
import cn.com.transcosmos.training.domain.Person;
import cn.com.transcosmos.training.mapper.PersonMapper;

/**
 * @author NRI
 */
@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonMapper personMapper;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	public List<Map<String, String>> selectAllPersons(Condition condition) {
		condition = addDate(condition);
		List<Person> personList = personMapper.select(condition);
		List<Map<String, String>> resultList01 = new ArrayList<Map<String, String>>();
		Person person = new Person();
		person.setPersonId("0");
		Map<String, String> addMap = new LinkedHashMap<String,String>();
		for(int i=0;i<personList.size();i++) {
			if(!person.getPersonId().equals(personList.get(i).getPersonId())) {
				person = personList.get(i);
				addMap = new LinkedHashMap<String,String>();
				String personId = person.getPersonId();
				addMap.put("ID", personId);
				String personName = person.getPersonName();
				addMap.put("Name", personName);
				String personJob = person.getJob();
				addMap.put("Job", personJob);
				String personPlanDate = person.getPlanDate();
				String personProId = person.getProName();
				addMap.put(personPlanDate, personProId);
			}
			if(person.getPersonId().equals(personList.get(i).getPersonId())) {
				person = personList.get(i);
				String personPlanDate = person.getPlanDate();
				String personProId = person.getProName();
				addMap.put(personPlanDate, personProId);
			}
			if(i==(personList.size()-1) || !person.getPersonId().equals(personList.get(i+1).getPersonId())) {
				resultList01.add(addMap);
			}
		}
		return resultList01;
	}

	public int insertPerson(Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updatePerson(Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deletePersonById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 添加起止日期
	public Condition addDate(Condition condition) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(d);
		if (condition.getPeriod().equals("1")) {
			condition.setEndDate(today);
			condition.setStartDate(getDateStr(today, 15));
		} else if (condition.getPeriod().equals("2")) {
			condition.setEndDate(today);
			condition.setStartDate(getDateStr(today, 30));
		} else if (condition.getPeriod().equals("3")) {
			condition.setEndDate(today);
			condition.setStartDate(getDateStr(today, 60));
		} else if (condition.getPeriod().equals("4")) {
			condition.setEndDate(today);
			condition.setStartDate(getDateStr(today, 90));
		} else if (condition.getPeriod().equals("5")) {
			if (condition.getStartDate() == null || condition.getEndDate() == null) {
				condition.setPeriod("1");
				condition.setEndDate(today);
				condition.setStartDate(getDateStr(today, 15));
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
		Date newDate2 = new Date((nowDate.getTime()/1000 - dayAddNum * 24 * 60 * 60)*1000);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateOk = simpleDateFormat.format(newDate2);
		return dateOk;
	}

}
