package domain;

import java.util.Scanner;

public class InputManager {

	private int trialTime;
	private String[] carNames;

	public void initialize() {
		inputCarNames();
	}
	
	private void inputCarNames() {
		Scanner input = new Scanner(System.in);
		System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸�����ǥ(,)�������α���)");
		carNames = input.next().split(",");
	}
	
}
