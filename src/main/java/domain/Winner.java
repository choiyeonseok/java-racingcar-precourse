package domain;

import java.util.List;

public class Winner {

	/* ����� �̸��� ���� */
	private String winner = "";

	/*
	 * ����ڸ� ����ؼ� ����ϴ� �޼��� ���� ���� position�� �ش��ϴ� carName�� ����Ѵ�.
	 */
	public void showWinner(List<Car> carList) {
		int MAX = 0;
		for (Car car : carList) {
			MAX = updateMAX(MAX, car);
			if (MAX == car.getPosition() && winner != car.getName()) {
				winner += ", " + car.getName();
			}
		}
		System.out.println(winner + "�� ���� ����߽��ϴ�.");

	}

	/*
	 * MAX���� ������Ʈ �Ǹ� winner������ ���� ������Ʈ��Ű�� �޼���
	 */
	private int updateMAX(int MAX, Car car) {
		if (MAX < car.getPosition()) {
			winner = car.getName();
			return car.getPosition();
		}
		return MAX;
	}

}
