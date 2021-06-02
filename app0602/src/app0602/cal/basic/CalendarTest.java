package app0602.cal.basic;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		//추상클래스이기 때문에 static 클래스메서드로 인스턴스 얻었음
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR)); // 연도 출력
		System.out.println(cal.get(Calendar.MONTH)+1); // 월 출력 (0부터 시작할 때는 디자인 즉 출려시엔 1 더해서 출력)
		System.out.println(cal.get(Calendar.DATE)); // 일 출력
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 요일 출력 1부터 시작함 (수여일이면 4가 나엄, ㅇ일 월 화 수)
		
		
		//조작
		//오늘 만난 커플의 100일 뒤 는?
		//Calendar cal2 = Calendar.getInstance();
		//cal2.set(Calendar.DATE,cal.get(Calendar.DATE)+100); // 오늘 날짜에 100을 더한 날
		//int mm = cal2.get(Calendar.MONTH); // 미래의 조작된
		//int dd = cal2.get(Calendar.DATE);
		//System.out.println((mm+1)+"월 "+dd+"일");
		
		
		//8.15일 광복의 날로 시간을 과거로 세팅하여, 무슨 요일인지 출력
		Calendar cal3= Calendar.getInstance();
		cal3.set(1945, 8-1,15); // 과거시간으로 캘린더 객체를 조작
		int yy = cal3.get(Calendar.YEAR);
		int mm = cal3.get(Calendar.MONTH); // 0부터 시작
		int dd = cal3.get(Calendar.DATE);
		int day = cal3.get(Calendar.DAY_OF_WEEK); // 1부터 시작함
		
		System.out.println(yy+"년, "+(mm+1)+"월, "+dd+"일, "+day+" 요일");
	}

}
