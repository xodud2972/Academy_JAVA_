package app0602.cal.basic;

import java.util.Calendar;

/*
 * js에서는 날짜를 처리하는 객체가 Date이지만, 자바에서는 Calendar 클래스가 담당한다!
 * 참고) System 클래스에는 currentTimeMillls() 메서드가 지원되기는 하나, Calendar 처럼 다양한 날짜를 처리하는 객체는 아니다!!
 * */
public class CalendarTest {
	public static void main(String[] args) {
		//추상클래스이기 때문에 static 클래스메서드로 인스턴스 얻었음
		Calendar cal=Calendar.getInstance();
		/*
		System.out.println(cal.get(Calendar.YEAR));//연도출력	
		System.out.println(cal.get(Calendar.MONTH)+1);//월출력	(0부터 시작할때는 디자인 즉 출력시엔 1더해서 출력)
		System.out.println(cal.get(Calendar.DATE)); //일
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); //요일 1부터 시작함
		*/
		
		//조작 
		//오늘 만난 커플의 100일 뒤 기념일은 ?
		/*
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.DATE, cal.get(Calendar.DATE)+100); // 오늘 날짜에 100을 더한 날로 조작
		int mm=cal2.get(Calendar.MONTH); //미래의 조작된 월 
		int dd=cal2.get(Calendar.DATE);
		System.out.println((mm+1)+"월 , "+dd+"일");
		*/
		
		//8.15일 광복의 날로 시간을 과거로 세팅하여, 무슨 요일인지 출력!!
		Calendar cal3=Calendar.getInstance();
		cal3.set(1945, 8-1, 15); //과거 시간으로 켈린더 객체를 조작!!!
		int yy=cal3.get(Calendar.YEAR);
		int mm=cal3.get(Calendar.MONTH); //0부터 시작
		int dd=cal3.get(Calendar.DATE);
		int day=cal3.get(Calendar.DAY_OF_WEEK); //1부터 시작함
		String[] title= {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
		
		System.out.println(yy+"년, "+(mm+1)+"월, "+dd+"일, "+title[day-1]+" 요일");
	}

}







