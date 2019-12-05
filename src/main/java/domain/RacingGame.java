package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

	/* ���̽� �õ� Ƚ�� */
	private int trialTime = 0;
	
	/* ���ֿ� �����ϴ� �ڵ��� �ν��Ͻ��� �����ϴ� ����Ʈ */
	private List<Car> carList;
	
	/* ����� �̸��� ���� */
	private String winner = "";
	
	/* ������ ���� �Է��� �ޱ����� InputManager �ν��Ͻ� */
	private InputManager inputManager;

	public RacingGame() {
		carList = new ArrayList<>();
		inputManager = new InputManager();
	}

	/*
	 * game ��ü ������ ���������� �����ϴ� �޼���
	 * �����͸� �Է¹ް�, ���ָ� �����ϰ�, ����ڸ� �����Ѵ�.
	 */
	public void play() {
		prepareRacing();
		raceCars();
		showWinner();
	}

	/*
	 * �����͸� �Է¹ް�, ���ָ� ���� �ڵ��� �ν��Ͻ��� �����ϴ� �޼���
	 */
	private void prepareRacing() {
		inputManager.initialize();
		trialTime = inputManager.getTrialTime();
		for (String name : inputManager.getCarNames()) {
			carList.add(new Car(name));
		}
	}

	/*
	 * �� �õ� ����, Car��ü�� �޽��� �����ϴ� �޼���
	 */
	private void raceCars() {
		System.out.println("���� ���");
		for (int i = 0; i < trialTime; i++) {
			for (Car car : carList) {
				car.goForwardOrNot();
				car.showPosition();
			}
			System.out.println();
		}
	}
	
	/*
	 * ����ڸ� ����ؼ� ����ϴ� �޼���
	 * ���� ���� position�� �ش��ϴ� carName�� ����Ѵ�.
	 */
	private void showWinner() {
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
