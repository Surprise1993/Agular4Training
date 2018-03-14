package cn.com.transcosmos.training.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.map.LinkedMap;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.transcosmos.training.domain.Condition;
import cn.com.transcosmos.training.domain.Person;
import cn.com.transcosmos.training.domain.PersonFor366;
import cn.com.transcosmos.training.mapper.PersonFor366Mapper;

@Service
@Transactional
public class PersonFor366Service {
	@Autowired
	private PersonFor366Mapper personFor366Mapper;

	public List<Map<String, String>> selectAllPersons(Condition condition) {
		Condition newCondition = addDate(condition);
		List<String> dateList = getDateStrList(newCondition);
		List<Map<String, String>> returnList = new ArrayList<Map<String, String>>();
		List<PersonFor366> personFor366sList = personFor366Mapper.select(newCondition, dateList);
		for (PersonFor366 personFor366 : personFor366sList) {
			returnList.add(getMap(dateList, personFor366));
		}
		return returnList;
	}

	public int insertPerson(PersonFor366 personFor366) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updatePerson(PersonFor366 personFor366) {
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
			condition.setStartDate(getDateStr(today, 14));
		} else if (condition.getPeriod().equals("2")) {
			condition.setEndDate(today);
			condition.setStartDate(getDateStr(today, 29));
		} else if (condition.getPeriod().equals("3")) {
			condition.setEndDate(today);
			condition.setStartDate(getDateStr(today, 59));
		} else if (condition.getPeriod().equals("4")) {
			condition.setEndDate(today);
			condition.setStartDate(getDateStr(today, 89));
		} else if (condition.getPeriod().equals("5")) {
			if (condition.getStartDate() == null || condition.getEndDate() == null) {
				condition.setPeriod("1");
				condition.setEndDate(today);
				condition.setStartDate(getDateStr(today, 14));
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
		Date newDate2 = new Date((nowDate.getTime() / 1000 - dayAddNum * 24 * 60 * 60) * 1000);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateOk = simpleDateFormat.format(newDate2);
		return dateOk;
	}

	public static List<String> getDateStrList(Condition condition) {
		String startDateForYear = condition.getStartDate().substring(0, 4);
		String startDateForMonth = condition.getStartDate().substring(5, 7);
		String startDateForDay = condition.getStartDate().substring(8, 10);

		String endDateForYear = condition.getEndDate().substring(0, 4);
		String endDateForMonth = condition.getEndDate().substring(5, 7);
		String endDateForDay = condition.getEndDate().substring(8, 10);

		String nowDateForYear = endDateForYear;
		String nowDateForMonth = endDateForMonth;
		String nowDateForDay = endDateForDay;

		List<String> returnList = new ArrayList<String>();

		String nowDate = condition.getEndDate();

		while ((!nowDateForMonth.equals(startDateForMonth)) || (!nowDateForDay.equals(startDateForDay))) {
			nowDateForYear = nowDate.substring(0, 4);
			nowDateForMonth = nowDate.substring(5, 7);
			nowDateForDay = nowDate.substring(8, 10);
			returnList.add(nowDateForYear + nowDateForMonth + nowDateForDay);
			nowDate = getDateStr(nowDate, 1);
		}

		if (returnList.size() == 0) {
			nowDateForMonth = nowDate.substring(5, 7);
			nowDateForDay = nowDate.substring(8, 10);
			returnList.add(nowDateForYear + nowDateForMonth + nowDateForDay);
		}

		return returnList;
	}

	/**
	 * 得到显示的每一行的MAP
	 */
	public static Map<String, String> getMap(List<String> dateList, PersonFor366 personFor366) {
		Map<String, String> returnMap = new LinkedHashMap<String,String>();
		returnMap.put("姓名", personFor366.getPERSONNAME());
		returnMap.put("职位", personFor366.getJOB());
		for(int i = dateList.size()-1; 0 <= i; i --) {
			String date = dateList.get(i);
			String nowYear = date.substring(0,4);
			String nowMonth = date.substring(4,6);
			String nowDay = date.substring(6,8);
			returnMap.put(nowYear + "/" + nowMonth + "/" + nowDay, getProjectName(date, personFor366));
		}
		return returnMap;
	}

	/**
	 * 得到显示的每一行显示的每一列的值
	 */
	public static String getProjectName(String columName, PersonFor366 personFor366) {
		String nowMonth = columName.substring(4, 6);
		String nowDay = columName.substring(6, 8);
		String projectName = "";
		switch (nowMonth) {
		case "01":
			switch (nowDay) {
			case "01":
				projectName = personFor366.getPRO0101();
				break;
			case "02":
				projectName = personFor366.getPRO0102();
				break;
			case "03":
				projectName = personFor366.getPRO0103();
				break;
			case "04":
				projectName = personFor366.getPRO0104();
				break;
			case "05":
				projectName = personFor366.getPRO0105();
				break;
			case "06":
				projectName = personFor366.getPRO0106();
				break;
			case "07":
				projectName = personFor366.getPRO0107();
				break;
			case "08":
				projectName = personFor366.getPRO0108();
				break;
			case "09":
				projectName = personFor366.getPRO0109();
				break;
			case "10":
				projectName = personFor366.getPRO0110();
				break;
			case "11":
				projectName = personFor366.getPRO0111();
				break;
			case "12":
				projectName = personFor366.getPRO0112();
				break;
			case "13":
				projectName = personFor366.getPRO0113();
				break;
			case "14":
				projectName = personFor366.getPRO0114();
				break;
			case "15":
				projectName = personFor366.getPRO0115();
				break;
			case "16":
				projectName = personFor366.getPRO0116();
				break;
			case "17":
				projectName = personFor366.getPRO0117();
				break;
			case "18":
				projectName = personFor366.getPRO0118();
				break;
			case "19":
				projectName = personFor366.getPRO0119();
				break;
			case "20":
				projectName = personFor366.getPRO0120();
				break;
			case "21":
				projectName = personFor366.getPRO0121();
				break;
			case "22":
				projectName = personFor366.getPRO0122();
				break;
			case "23":
				projectName = personFor366.getPRO0123();
				break;
			case "24":
				projectName = personFor366.getPRO0124();
				break;
			case "25":
				projectName = personFor366.getPRO0125();
				break;
			case "26":
				projectName = personFor366.getPRO0126();
				break;
			case "27":
				projectName = personFor366.getPRO0127();
				break;
			case "28":
				projectName = personFor366.getPRO0128();
				break;
			case "29":
				projectName = personFor366.getPRO0129();
				break;
			case "30":
				projectName = personFor366.getPRO0130();
				break;
			case "31":
				projectName = personFor366.getPRO0131();
				break;
			}
			break;
		case "02":
			switch (nowDay) {
			case "01":
				projectName = personFor366.getPRO0201();
				break;
			case "02":
				projectName = personFor366.getPRO0202();
				break;
			case "03":
				projectName = personFor366.getPRO0203();
				break;
			case "04":
				projectName = personFor366.getPRO0204();
				break;
			case "05":
				projectName = personFor366.getPRO0205();
				break;
			case "06":
				projectName = personFor366.getPRO0206();
				break;
			case "07":
				projectName = personFor366.getPRO0207();
				break;
			case "08":
				projectName = personFor366.getPRO0208();
				break;
			case "09":
				projectName = personFor366.getPRO0209();
				break;
			case "10":
				projectName = personFor366.getPRO0210();
				break;
			case "11":
				projectName = personFor366.getPRO0211();
				break;
			case "12":
				projectName = personFor366.getPRO0212();
				break;
			case "13":
				projectName = personFor366.getPRO0213();
				break;
			case "14":
				projectName = personFor366.getPRO0214();
				break;
			case "15":
				projectName = personFor366.getPRO0215();
				break;
			case "16":
				projectName = personFor366.getPRO0216();
				break;
			case "17":
				projectName = personFor366.getPRO0217();
				break;
			case "18":
				projectName = personFor366.getPRO0218();
				break;
			case "19":
				projectName = personFor366.getPRO0219();
				break;
			case "20":
				projectName = personFor366.getPRO0220();
				break;
			case "21":
				projectName = personFor366.getPRO0221();
				break;
			case "22":
				projectName = personFor366.getPRO0222();
				break;
			case "23":
				projectName = personFor366.getPRO0223();
				break;
			case "24":
				projectName = personFor366.getPRO0224();
				break;
			case "25":
				projectName = personFor366.getPRO0225();
				break;
			case "26":
				projectName = personFor366.getPRO0226();
				break;
			case "27":
				projectName = personFor366.getPRO0227();
				break;
			case "28":
				projectName = personFor366.getPRO0228();
				break;
			case "29":
				projectName = personFor366.getPRO0229();
				break;
			}
			break;
		case "03":
			switch (nowDay) {
			case "01":
				projectName = personFor366.getPRO0301();
				break;
			case "02":
				projectName = personFor366.getPRO0302();
				break;
			case "03":
				projectName = personFor366.getPRO0303();
				break;
			case "04":
				projectName = personFor366.getPRO0304();
				break;
			case "05":
				projectName = personFor366.getPRO0305();
				break;
			case "06":
				projectName = personFor366.getPRO0306();
				break;
			case "07":
				projectName = personFor366.getPRO0307();
				break;
			case "08":
				projectName = personFor366.getPRO0308();
				break;
			case "09":
				projectName = personFor366.getPRO0309();
				break;
			case "10":
				projectName = personFor366.getPRO0310();
				break;
			case "11":
				projectName = personFor366.getPRO0311();
				break;
			case "12":
				projectName = personFor366.getPRO0312();
				break;
			case "13":
				projectName = personFor366.getPRO0313();
				break;
			case "14":
				projectName = personFor366.getPRO0314();
				break;
			case "15":
				projectName = personFor366.getPRO0315();
				break;
			case "16":
				projectName = personFor366.getPRO0316();
				break;
			case "17":
				projectName = personFor366.getPRO0317();
				break;
			case "18":
				projectName = personFor366.getPRO0318();
				break;
			case "19":
				projectName = personFor366.getPRO0319();
				break;
			case "20":
				projectName = personFor366.getPRO0320();
				break;
			case "21":
				projectName = personFor366.getPRO0321();
				break;
			case "22":
				projectName = personFor366.getPRO0322();
				break;
			case "23":
				projectName = personFor366.getPRO0323();
				break;
			case "24":
				projectName = personFor366.getPRO0324();
				break;
			case "25":
				projectName = personFor366.getPRO0325();
				break;
			case "26":
				projectName = personFor366.getPRO0326();
				break;
			case "27":
				projectName = personFor366.getPRO0327();
				break;
			case "28":
				projectName = personFor366.getPRO0328();
				break;
			case "29":
				projectName = personFor366.getPRO0329();
				break;
			case "30":
				projectName = personFor366.getPRO0330();
				break;
			case "31":
				projectName = personFor366.getPRO0331();
				break;
			}
			break;
		case "04":
			switch (nowDay) {
			case "01":
				projectName = personFor366.getPRO0401();
				break;
			case "02":
				projectName = personFor366.getPRO0402();
				break;
			case "03":
				projectName = personFor366.getPRO0403();
				break;
			case "04":
				projectName = personFor366.getPRO0404();
				break;
			case "05":
				projectName = personFor366.getPRO0405();
				break;
			case "06":
				projectName = personFor366.getPRO0406();
				break;
			case "07":
				projectName = personFor366.getPRO0407();
				break;
			case "08":
				projectName = personFor366.getPRO0408();
				break;
			case "09":
				projectName = personFor366.getPRO0409();
				break;
			case "10":
				projectName = personFor366.getPRO0410();
				break;
			case "11":
				projectName = personFor366.getPRO0411();
				break;
			case "12":
				projectName = personFor366.getPRO0412();
				break;
			case "13":
				projectName = personFor366.getPRO0413();
				break;
			case "14":
				projectName = personFor366.getPRO0414();
				break;
			case "15":
				projectName = personFor366.getPRO0415();
				break;
			case "16":
				projectName = personFor366.getPRO0416();
				break;
			case "17":
				projectName = personFor366.getPRO0417();
				break;
			case "18":
				projectName = personFor366.getPRO0418();
				break;
			case "19":
				projectName = personFor366.getPRO0419();
				break;
			case "20":
				projectName = personFor366.getPRO0420();
				break;
			case "21":
				projectName = personFor366.getPRO0421();
				break;
			case "22":
				projectName = personFor366.getPRO0422();
				break;
			case "23":
				projectName = personFor366.getPRO0423();
				break;
			case "24":
				projectName = personFor366.getPRO0424();
				break;
			case "25":
				projectName = personFor366.getPRO0425();
				break;
			case "26":
				projectName = personFor366.getPRO0426();
				break;
			case "27":
				projectName = personFor366.getPRO0427();
				break;
			case "28":
				projectName = personFor366.getPRO0428();
				break;
			case "29":
				projectName = personFor366.getPRO0429();
				break;
			case "30":
				projectName = personFor366.getPRO0430();
				break;
			}
			break;
		case "05":
			switch (nowDay) {
			case "01":
				projectName = personFor366.getPRO0501();
				break;
			case "02":
				projectName = personFor366.getPRO0502();
				break;
			case "03":
				projectName = personFor366.getPRO0503();
				break;
			case "04":
				projectName = personFor366.getPRO0504();
				break;
			case "05":
				projectName = personFor366.getPRO0505();
				break;
			case "06":
				projectName = personFor366.getPRO0506();
				break;
			case "07":
				projectName = personFor366.getPRO0507();
				break;
			case "08":
				projectName = personFor366.getPRO0508();
				break;
			case "09":
				projectName = personFor366.getPRO0509();
				break;
			case "10":
				projectName = personFor366.getPRO0510();
				break;
			case "11":
				projectName = personFor366.getPRO0511();
				break;
			case "12":
				projectName = personFor366.getPRO0512();
				break;
			case "13":
				projectName = personFor366.getPRO0513();
				break;
			case "14":
				projectName = personFor366.getPRO0514();
				break;
			case "15":
				projectName = personFor366.getPRO0515();
				break;
			case "16":
				projectName = personFor366.getPRO0516();
				break;
			case "17":
				projectName = personFor366.getPRO0517();
				break;
			case "18":
				projectName = personFor366.getPRO0518();
				break;
			case "19":
				projectName = personFor366.getPRO0519();
				break;
			case "20":
				projectName = personFor366.getPRO0520();
				break;
			case "21":
				projectName = personFor366.getPRO0521();
				break;
			case "22":
				projectName = personFor366.getPRO0522();
				break;
			case "23":
				projectName = personFor366.getPRO0523();
				break;
			case "24":
				projectName = personFor366.getPRO0524();
				break;
			case "25":
				projectName = personFor366.getPRO0525();
				break;
			case "26":
				projectName = personFor366.getPRO0526();
				break;
			case "27":
				projectName = personFor366.getPRO0527();
				break;
			case "28":
				projectName = personFor366.getPRO0528();
				break;
			case "29":
				projectName = personFor366.getPRO0529();
				break;
			case "30":
				projectName = personFor366.getPRO0530();
				break;
			case "31":
				projectName = personFor366.getPRO0531();
				break;
			}
			break;
		case "06":
			switch (nowDay) {
			case "01":
				projectName = personFor366.getPRO0601();
				break;
			case "02":
				projectName = personFor366.getPRO0602();
				break;
			case "03":
				projectName = personFor366.getPRO0603();
				break;
			case "04":
				projectName = personFor366.getPRO0604();
				break;
			case "05":
				projectName = personFor366.getPRO0605();
				break;
			case "06":
				projectName = personFor366.getPRO0606();
				break;
			case "07":
				projectName = personFor366.getPRO0607();
				break;
			case "08":
				projectName = personFor366.getPRO0608();
				break;
			case "09":
				projectName = personFor366.getPRO0609();
				break;
			case "10":
				projectName = personFor366.getPRO0610();
				break;
			case "11":
				projectName = personFor366.getPRO0611();
				break;
			case "12":
				projectName = personFor366.getPRO0612();
				break;
			case "13":
				projectName = personFor366.getPRO0613();
				break;
			case "14":
				projectName = personFor366.getPRO0614();
				break;
			case "15":
				projectName = personFor366.getPRO0615();
				break;
			case "16":
				projectName = personFor366.getPRO0616();
				break;
			case "17":
				projectName = personFor366.getPRO0617();
				break;
			case "18":
				projectName = personFor366.getPRO0618();
				break;
			case "19":
				projectName = personFor366.getPRO0619();
				break;
			case "20":
				projectName = personFor366.getPRO0620();
				break;
			case "21":
				projectName = personFor366.getPRO0621();
				break;
			case "22":
				projectName = personFor366.getPRO0622();
				break;
			case "23":
				projectName = personFor366.getPRO0623();
				break;
			case "24":
				projectName = personFor366.getPRO0624();
				break;
			case "25":
				projectName = personFor366.getPRO0625();
				break;
			case "26":
				projectName = personFor366.getPRO0626();
				break;
			case "27":
				projectName = personFor366.getPRO0627();
				break;
			case "28":
				projectName = personFor366.getPRO0628();
				break;
			case "29":
				projectName = personFor366.getPRO0629();
				break;
			case "30":
				projectName = personFor366.getPRO0630();
				break;
			}
			break;
		case "07":
			switch (nowDay) {
			case "01":
				projectName = personFor366.getPRO0701();
				break;
			case "02":
				projectName = personFor366.getPRO0702();
				break;
			case "03":
				projectName = personFor366.getPRO0703();
				break;
			case "04":
				projectName = personFor366.getPRO0704();
				break;
			case "05":
				projectName = personFor366.getPRO0705();
				break;
			case "06":
				projectName = personFor366.getPRO0706();
				break;
			case "07":
				projectName = personFor366.getPRO0707();
				break;
			case "08":
				projectName = personFor366.getPRO0708();
				break;
			case "09":
				projectName = personFor366.getPRO0709();
				break;
			case "10":
				projectName = personFor366.getPRO0710();
				break;
			case "11":
				projectName = personFor366.getPRO0711();
				break;
			case "12":
				projectName = personFor366.getPRO0712();
				break;
			case "13":
				projectName = personFor366.getPRO0713();
				break;
			case "14":
				projectName = personFor366.getPRO0714();
				break;
			case "15":
				projectName = personFor366.getPRO0715();
				break;
			case "16":
				projectName = personFor366.getPRO0716();
				break;
			case "17":
				projectName = personFor366.getPRO0717();
				break;
			case "18":
				projectName = personFor366.getPRO0718();
				break;
			case "19":
				projectName = personFor366.getPRO0719();
				break;
			case "20":
				projectName = personFor366.getPRO0720();
				break;
			case "21":
				projectName = personFor366.getPRO0721();
				break;
			case "22":
				projectName = personFor366.getPRO0722();
				break;
			case "23":
				projectName = personFor366.getPRO0723();
				break;
			case "24":
				projectName = personFor366.getPRO0724();
				break;
			case "25":
				projectName = personFor366.getPRO0725();
				break;
			case "26":
				projectName = personFor366.getPRO0726();
				break;
			case "27":
				projectName = personFor366.getPRO0727();
				break;
			case "28":
				projectName = personFor366.getPRO0728();
				break;
			case "29":
				projectName = personFor366.getPRO0729();
				break;
			case "30":
				projectName = personFor366.getPRO0730();
				break;
			case "31":
				projectName = personFor366.getPRO0731();
				break;
			}
			break;
		case "08":
			switch (nowDay) {
			case "01":
				projectName = personFor366.getPRO0801();
				break;
			case "02":
				projectName = personFor366.getPRO0802();
				break;
			case "03":
				projectName = personFor366.getPRO0803();
				break;
			case "04":
				projectName = personFor366.getPRO0804();
				break;
			case "05":
				projectName = personFor366.getPRO0805();
				break;
			case "06":
				projectName = personFor366.getPRO0806();
				break;
			case "07":
				projectName = personFor366.getPRO0807();
				break;
			case "08":
				projectName = personFor366.getPRO0808();
				break;
			case "09":
				projectName = personFor366.getPRO0809();
				break;
			case "10":
				projectName = personFor366.getPRO0810();
				break;
			case "11":
				projectName = personFor366.getPRO0811();
				break;
			case "12":
				projectName = personFor366.getPRO0812();
				break;
			case "13":
				projectName = personFor366.getPRO0813();
				break;
			case "14":
				projectName = personFor366.getPRO0814();
				break;
			case "15":
				projectName = personFor366.getPRO0815();
				break;
			case "16":
				projectName = personFor366.getPRO0816();
				break;
			case "17":
				projectName = personFor366.getPRO0817();
				break;
			case "18":
				projectName = personFor366.getPRO0818();
				break;
			case "19":
				projectName = personFor366.getPRO0819();
				break;
			case "20":
				projectName = personFor366.getPRO0820();
				break;
			case "21":
				projectName = personFor366.getPRO0821();
				break;
			case "22":
				projectName = personFor366.getPRO0822();
				break;
			case "23":
				projectName = personFor366.getPRO0823();
				break;
			case "24":
				projectName = personFor366.getPRO0824();
				break;
			case "25":
				projectName = personFor366.getPRO0825();
				break;
			case "26":
				projectName = personFor366.getPRO0826();
				break;
			case "27":
				projectName = personFor366.getPRO0827();
				break;
			case "28":
				projectName = personFor366.getPRO0828();
				break;
			case "29":
				projectName = personFor366.getPRO0829();
				break;
			case "30":
				projectName = personFor366.getPRO0830();
				break;
			case "31":
				projectName = personFor366.getPRO0831();
				break;
			}
			break;
		case "09":
			switch (nowDay) {
			case "01":
				projectName = personFor366.getPRO0901();
				break;
			case "02":
				projectName = personFor366.getPRO0902();
				break;
			case "03":
				projectName = personFor366.getPRO0903();
				break;
			case "04":
				projectName = personFor366.getPRO0904();
				break;
			case "05":
				projectName = personFor366.getPRO0905();
				break;
			case "06":
				projectName = personFor366.getPRO0906();
				break;
			case "07":
				projectName = personFor366.getPRO0907();
				break;
			case "08":
				projectName = personFor366.getPRO0908();
				break;
			case "09":
				projectName = personFor366.getPRO0909();
				break;
			case "10":
				projectName = personFor366.getPRO0910();
				break;
			case "11":
				projectName = personFor366.getPRO0911();
				break;
			case "12":
				projectName = personFor366.getPRO0912();
				break;
			case "13":
				projectName = personFor366.getPRO0913();
				break;
			case "14":
				projectName = personFor366.getPRO0914();
				break;
			case "15":
				projectName = personFor366.getPRO0915();
				break;
			case "16":
				projectName = personFor366.getPRO0916();
				break;
			case "17":
				projectName = personFor366.getPRO0917();
				break;
			case "18":
				projectName = personFor366.getPRO0918();
				break;
			case "19":
				projectName = personFor366.getPRO0919();
				break;
			case "20":
				projectName = personFor366.getPRO0920();
				break;
			case "21":
				projectName = personFor366.getPRO0921();
				break;
			case "22":
				projectName = personFor366.getPRO0922();
				break;
			case "23":
				projectName = personFor366.getPRO0923();
				break;
			case "24":
				projectName = personFor366.getPRO0924();
				break;
			case "25":
				projectName = personFor366.getPRO0925();
				break;
			case "26":
				projectName = personFor366.getPRO0926();
				break;
			case "27":
				projectName = personFor366.getPRO0927();
				break;
			case "28":
				projectName = personFor366.getPRO0928();
				break;
			case "29":
				projectName = personFor366.getPRO0929();
				break;
			case "30":
				projectName = personFor366.getPRO0930();
				break;
			}
			break;
		case "10":
			switch (nowDay) {
			case "01":
				projectName = personFor366.getPRO1001();
				break;
			case "02":
				projectName = personFor366.getPRO1002();
				break;
			case "03":
				projectName = personFor366.getPRO1003();
				break;
			case "04":
				projectName = personFor366.getPRO1004();
				break;
			case "05":
				projectName = personFor366.getPRO1005();
				break;
			case "06":
				projectName = personFor366.getPRO1006();
				break;
			case "07":
				projectName = personFor366.getPRO1007();
				break;
			case "08":
				projectName = personFor366.getPRO1008();
				break;
			case "09":
				projectName = personFor366.getPRO1009();
				break;
			case "10":
				projectName = personFor366.getPRO1010();
				break;
			case "11":
				projectName = personFor366.getPRO1011();
				break;
			case "12":
				projectName = personFor366.getPRO1012();
				break;
			case "13":
				projectName = personFor366.getPRO1013();
				break;
			case "14":
				projectName = personFor366.getPRO1014();
				break;
			case "15":
				projectName = personFor366.getPRO1015();
				break;
			case "16":
				projectName = personFor366.getPRO1016();
				break;
			case "17":
				projectName = personFor366.getPRO1017();
				break;
			case "18":
				projectName = personFor366.getPRO1018();
				break;
			case "19":
				projectName = personFor366.getPRO1019();
				break;
			case "20":
				projectName = personFor366.getPRO1020();
				break;
			case "21":
				projectName = personFor366.getPRO1021();
				break;
			case "22":
				projectName = personFor366.getPRO1022();
				break;
			case "23":
				projectName = personFor366.getPRO1023();
				break;
			case "24":
				projectName = personFor366.getPRO1024();
				break;
			case "25":
				projectName = personFor366.getPRO1025();
				break;
			case "26":
				projectName = personFor366.getPRO1026();
				break;
			case "27":
				projectName = personFor366.getPRO1027();
				break;
			case "28":
				projectName = personFor366.getPRO1028();
				break;
			case "29":
				projectName = personFor366.getPRO1029();
				break;
			case "30":
				projectName = personFor366.getPRO1030();
				break;
			case "31":
				projectName = personFor366.getPRO1031();
				break;
			}
			break;
		case "11":
			switch (nowDay) {
			case "01":
				projectName = personFor366.getPRO1101();
				break;
			case "02":
				projectName = personFor366.getPRO1102();
				break;
			case "03":
				projectName = personFor366.getPRO1103();
				break;
			case "04":
				projectName = personFor366.getPRO1104();
				break;
			case "05":
				projectName = personFor366.getPRO1105();
				break;
			case "06":
				projectName = personFor366.getPRO1106();
				break;
			case "07":
				projectName = personFor366.getPRO1107();
				break;
			case "08":
				projectName = personFor366.getPRO1108();
				break;
			case "09":
				projectName = personFor366.getPRO1109();
				break;
			case "10":
				projectName = personFor366.getPRO1110();
				break;
			case "11":
				projectName = personFor366.getPRO1111();
				break;
			case "12":
				projectName = personFor366.getPRO1112();
				break;
			case "13":
				projectName = personFor366.getPRO1113();
				break;
			case "14":
				projectName = personFor366.getPRO1114();
				break;
			case "15":
				projectName = personFor366.getPRO1115();
				break;
			case "16":
				projectName = personFor366.getPRO1116();
				break;
			case "17":
				projectName = personFor366.getPRO1117();
				break;
			case "18":
				projectName = personFor366.getPRO1118();
				break;
			case "19":
				projectName = personFor366.getPRO1119();
				break;
			case "20":
				projectName = personFor366.getPRO1120();
				break;
			case "21":
				projectName = personFor366.getPRO1121();
				break;
			case "22":
				projectName = personFor366.getPRO1122();
				break;
			case "23":
				projectName = personFor366.getPRO1123();
				break;
			case "24":
				projectName = personFor366.getPRO1124();
				break;
			case "25":
				projectName = personFor366.getPRO1125();
				break;
			case "26":
				projectName = personFor366.getPRO1126();
				break;
			case "27":
				projectName = personFor366.getPRO1127();
				break;
			case "28":
				projectName = personFor366.getPRO1128();
				break;
			case "29":
				projectName = personFor366.getPRO1129();
				break;
			case "30":
				projectName = personFor366.getPRO1130();
				break;
			}
			break;
		case "12":
			switch (nowDay) {
			case "01":
				projectName = personFor366.getPRO1201();
				break;
			case "02":
				projectName = personFor366.getPRO1202();
				break;
			case "03":
				projectName = personFor366.getPRO1203();
				break;
			case "04":
				projectName = personFor366.getPRO1204();
				break;
			case "05":
				projectName = personFor366.getPRO1205();
				break;
			case "06":
				projectName = personFor366.getPRO1206();
				break;
			case "07":
				projectName = personFor366.getPRO1207();
				break;
			case "08":
				projectName = personFor366.getPRO1208();
				break;
			case "09":
				projectName = personFor366.getPRO1209();
				break;
			case "10":
				projectName = personFor366.getPRO1210();
				break;
			case "11":
				projectName = personFor366.getPRO1211();
				break;
			case "12":
				projectName = personFor366.getPRO1212();
				break;
			case "13":
				projectName = personFor366.getPRO1213();
				break;
			case "14":
				projectName = personFor366.getPRO1214();
				break;
			case "15":
				projectName = personFor366.getPRO1215();
				break;
			case "16":
				projectName = personFor366.getPRO1216();
				break;
			case "17":
				projectName = personFor366.getPRO1217();
				break;
			case "18":
				projectName = personFor366.getPRO1218();
				break;
			case "19":
				projectName = personFor366.getPRO1219();
				break;
			case "20":
				projectName = personFor366.getPRO1220();
				break;
			case "21":
				projectName = personFor366.getPRO1221();
				break;
			case "22":
				projectName = personFor366.getPRO1222();
				break;
			case "23":
				projectName = personFor366.getPRO1223();
				break;
			case "24":
				projectName = personFor366.getPRO1224();
				break;
			case "25":
				projectName = personFor366.getPRO1225();
				break;
			case "26":
				projectName = personFor366.getPRO1226();
				break;
			case "27":
				projectName = personFor366.getPRO1227();
				break;
			case "28":
				projectName = personFor366.getPRO1228();
				break;
			case "29":
				projectName = personFor366.getPRO1229();
				break;
			case "30":
				projectName = personFor366.getPRO1230();
				break;
			case "31":
				projectName = personFor366.getPRO1231();
				break;
			}
			break;
		}

		return projectName;
	}
}
