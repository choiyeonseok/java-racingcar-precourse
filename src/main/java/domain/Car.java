package domain;

public class Car {
	
	/* 0���� 9���� ���� ������ ����� ���� ��� */
	private final static int RANGE = 10;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	/*
	 * �ڵ����� ���� ���θ� �����ϴ� �޼���
	 * ������ ������ 4�̻��̸� position�� 1 ������Ŵ
	 */
	public void goForwardOrNot() {
		if ((int) (Math.random() * RANGE) >= 4) {
			position++;
		}
	}

	/*
	 * �ڵ����� ���� �������� ������ִ� �޼���
	 */
	public void showPosition() {
		System.out.print(name + " : ");
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
	
}
