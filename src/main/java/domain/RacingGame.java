package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

	private int trialTime = 0;
	private List<Car> carList;
	private String winner = "";
	private InputManager inputManager;

	public RacingGame() {
		carList = new ArrayList<>();
		inputManager = new InputManager();
	}

	public void play() {
		prepareRacing();
		raceCars();
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
}
