package reservation;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import main.AppMain;
import main.Page;

public class ReservationMain extends Page{
	// ����
	JPanel p_west;
	JButton bt_regist;
	JTextField t_title;
	JTextField t_price;
	JTextArea t_detail;
	JScrollPane scroll;
	JButton bt_web;
	JButton bt_file;
	Canvas can;
	JButton bt_edit;
	JButton bt_del;

	// ����
	JPanel p_center;
	JPanel p_search; // �˻� ������Ʈ �÷��δ� �г�
	Choice ch_category; // �˻� ī�װ�
	JTextField t_keyword; // �˻����Է�
	JButton bt_search;

	JTable table;
	JScrollPane scroll_table;
	// ĵ������ ����
	Toolkit kit= Toolkit.getDefaultToolkit();
	Image image;
	JFileChooser chooser;
	String filename; // ������ ���翡 ���� ������ ���ϸ�
	// ���̺�
	String[] columns= {"book_date", "memo ", "pk_booking ", "pk_company", "pk_mybike","pk_user", "pk_wanted","price", "regdate"}; // �÷��迭
	String[][] records= {};// ���ڵ� �迭
	private Connection con;

	ArrayList<ChCategory> OneList=new ArrayList<ChCategory>();

	public ReservationMain(AppMain appMain) {
		super(appMain);
		// -----------------------------------------------[����]
		// ���� ����
		p_west= new JPanel();
		bt_regist= new JButton("��ǰ ����");
		t_title= new JTextField();
		t_price= new JTextField();
		t_detail= new JTextArea();
		scroll= new  JScrollPane(t_detail);
		bt_web= new JButton("������ ���� ã��");
		bt_file= new JButton("�� ��ǻ�Ϳ��� ���� ã��");

		// �����͸� Ŭ������ �ܺ�Ŭ������ �������, �޼ҵ带 ���ٰ���.
		can= new Canvas() { // {}������ extendsȿ��
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, 180, 180, can);
			}
		};
		bt_edit= new JButton("����");
		bt_del= new JButton("����");


		// ����
		p_center= new JPanel();
		p_search= new JPanel();

		ch_category= new Choice();
		// �˻� ī�װ� ���
		ch_category.add("����");
		ch_category.add("�ۼ���");
		ch_category.add("����");

		t_keyword= new JTextField();
		bt_search= new JButton("�˻�");

		table= new JTable(new AbstractTableModel() {
			public int getRowCount() {
				return records.length;
			}
			public int getColumnCount() {
				return columns.length;
			}
			// �÷� ����
			public String getColumnName(int col) {
				return columns[col];
			}
			// �� ���� �� �����͸� ������ �迭�κ��� ����
			public Object getValueAt(int row, int col) {
				return records[row][col];
			}
			// JTable�� �� ���� ���� ����. ���� ������ �� ����ġ�� ���� �Ʒ��� �޼ҵ� ȣ��
			public void setValueAt(Object val, int row, int col) {
				records[row][col]=(String)val;
			}

			public boolean isCellEditable(int row, int col) {
				if(col==0) { // ù���� ���� product_id�� �б��������� ����
					return false;
				}else {
					return true;
				}
			}
		});

		scroll_table= new JScrollPane(table);
		// -----------------------------------------------[��Ÿ��, ���̾ƿ�]
		// ����ũ��
		Dimension d= new Dimension(180, 30);
		setLayout(new BorderLayout());

		// ����
		p_west.setPreferredSize(new Dimension(200, 700));
		scroll.setPreferredSize(new Dimension(180, 180));
		can.setPreferredSize(new Dimension(180, 180));
		can.setBackground(Color.PINK);

		t_title.setPreferredSize(d);
		t_price.setPreferredSize(d);
		t_detail.setPreferredSize(d);

		// ����
		p_center.setLayout(new BorderLayout());
		ch_category.setPreferredSize(d);
		t_keyword.setPreferredSize(new Dimension(450, 30));


		p_west.add(bt_regist);
		p_west.add(t_title);
		p_west.add(t_price);
		p_west.add(t_detail);
		p_west.add(scroll);
		p_west.add(bt_web);
		p_west.add(bt_file);
		p_west.add(can);
		p_west.add(bt_edit);
		p_west.add(bt_del);
		add(p_west, BorderLayout.WEST);


		p_search.add(ch_category);
		p_search.add(t_keyword);
		p_search.add(bt_search);
		p_center.add(p_search, BorderLayout.NORTH);
		p_center.add(scroll_table);
		add(p_center);



		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regist();
			}
		});

		bt_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		});

		bt_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});

		bt_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});

		bt_web.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				webfind();
			}
		});

		bt_file.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filefind();
			}
		});



	}

	public void regist() {
		System.out.println("��ǰ�� �����ϼ̽��ϴ�.");
	}

	public void delete() {
		System.out.println("��ǰ�� �����ϼ̽��ϴ�.");
	}

	public void edit() {
		System.out.println("��ǰ�� �����ϼ̽��ϴ�.");
	}
	public void search() {
		System.out.println("��ǰ�� �˻��ϼ̽��ϴ�.");
	}
	public void webfind() {
		System.out.println("������ �˻��ϴ� ���Դϴ�..");
	}
	public void filefind() {
		System.out.println("����ǻ�Ϳ��� �˻��ϴ� ���Դϴ�.");
	}





}