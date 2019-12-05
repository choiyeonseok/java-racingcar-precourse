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
}
