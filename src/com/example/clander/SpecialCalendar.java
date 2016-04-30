package com.example.clander;

import java.util.Calendar;

public class SpecialCalendar {

	private int daysOfMonth = 0;      //某月的天数
	private int dayOfWeek = 0;        //具体某一天是星期几

	
	
	
	// 判断是否为闰年
	public boolean isLeapYear(int year) {
		if (year % 100 == 0 && year % 400 == 0) {
			return true;
		} else if (year % 100 != 0 && year % 4 == 0) {
			return true;
		}
		return false;
	}

	//得到某月有多少天数
	public int getDaysOfMonth(boolean isLeapyear, int month) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			daysOfMonth = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			daysOfMonth = 30;
			break;
		case 2:
			if (isLeapyear) {
				daysOfMonth = 29;
			} else {
				daysOfMonth = 28;
			}

		}
		return daysOfMonth;
	}
	
	//指定某年中的某月的第一天是星期几
	public int getWeekdayOfMonth(int year, int month){
		Calendar cal = Calendar.getInstance();//时间实例
		cal.set(year, month-1, 1);//因为Calendar 的 month 从 0 开始，也就是全年 12 个月由 0 ~ 11 进行表示，所以要将传进来的数减1
		dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)-2;//用cal直接获取到星期，为什么要减1呢
		//获取你设置的myCal那年那月那日是星期几，必须要减一，因为数组下标从0开始，而她返回的是数组的内容，
		//是数组{1,2,3,4,5,6,7}中用1~7来表示：星期天，星期一，星期二，星期三，星期四，星期五，星期六 。
		//如果当天是星期一她会返回2，所以减一，才等于1，才是你想要的，如果是星期天就返回1-1=0咯,我这里是星期一作为数组的下标0，所以要减2！
		return dayOfWeek;
	}
	
	
}
