/*�ڵ����� �����غ���*/
class Car{
	String name="����";
	int price=9000; 
	String color="silver";

	public void setPrice(int price){
		this.price=price;
	}

	public static void main(String[] args){
		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = c2; 

		c1.setPrice(8000); //ù��° �ڵ����� ������ 8õ���� ���� 
		System.out.println(c2.price); //�ι�° �ڵ����� ������ �޾Ҵ��� ���θ� üũ 
		//���: �޸𸮿� �ö� �ν��Ͻ����� ���� �ٸ� ������ ��ü���̴�..

		c3.setPrice(7000);//c2�� ����Ű�� �־��� �ڵ����� ������ ��ġ�� ���� ����Ű�Ƿ�
		//�� �ι�° �ڵ����� ������ 7000���� �����ϰ� �� 
		System.out.println(c2.price);
	}
}
