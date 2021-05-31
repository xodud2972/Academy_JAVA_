package app0531;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

// notice 게시판 전용 TableModel
public class NoticeModel extends AbstractTableModel{
	Vector data; //기존의 데이터를 처리했던 이차원 배열을 대신한 컬레션 객체
	Vector column; // 기존의 컬럼명을 처리했던 일차원배열을 대신할 컬렉션 객체
	
	
	public int getRowCount() {
		return 3;
	}

	public int getColumnCount() {
		return 6;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}
	
}
