package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

	/* ���̽� �õ� Ƚ�� */
	private int trialTime = 0;
	
	/* ���ֿ� �����ϴ� �ڵ��� �ν��Ͻ��� �����ϴ� ����Ʈ */
	private List<Car> carList;
	
	/* ����� �̸��� ���� */
	private Winner winner;
	
	/* ������ ���� �Է��� �ޱ����� InputManager �ν��Ͻ� */
	private InputManager inputManager;

	public RacingGame() {
		carList = new ArrayList<>();
		inputManager = new InputManager();
		winner = new Winner();
	}

	/*
	 * game ��ü ������ ���������� �����ϴ� �޼���
	 * �����͸� �Է¹ް�, ���ָ� �����ϰ�, ����ڸ� �����Ѵ�.
	 */
	public void play() {
		prepareRacing();
		raceCars();
		winner.showWinner(carList);
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
	
}
