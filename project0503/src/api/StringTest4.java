package api;
public class StringTest4{
	public static void main(String[] args) {
		/*
		String Ŭ������ ������ immutable(�Һ�)�� �Ӽ��� �ִٰ� �Ѵ�
		*/
		String s1 = "korea";
		s1=s1+" vs usa"; 
		System.out.println(s1);

		//������ �ڵ� 
		//�Ʒ��� �ڵ�� result �� ����Ǵ� ���� �ƴ϶�, result�� ���� ���� ��� ���ο� ���ڿ���
		//�����Ǵ� ���̴�..���� �� 100���̻��� ���ڿ� ����� �޸𸮿� �ö�´�!!
		String result="";
		for(int i=0;i<100;i++){
			result+="apple "+i;
		}
		//�� ������ �ذ��Ϸ���, ���� ������ ���ڿ� ó�� ���� api�� ���������� �ȴ�..
		//StringBuffer, StringBuilder ��ü�� �̿��ϸ� �ȴ�!!!
		StringBuffer sb = new StringBuffer(); //String Ŭ���� X
		sb.append("��ȣ");
		sb.append(" ����");
		sb.append(" �ڹٰ�");
		sb.append(" ����");
		System.out.println(sb.toString());

	}
}
