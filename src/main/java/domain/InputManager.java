package domain;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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

		while (isDuplicated(carNames) | isOverLength(carNames)) {
			System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸�����ǥ(,)�������α���)");
			carNames = input.next().split(",");
		}
	}

	private boolean isDuplicated(String[] carNames) {
		Set<String> set = Arrays.stream(carNames).collect(Collectors.toSet());
		return set.size() < carNames.length;
	}

	private boolean isOverLength(String[] carNames) {
		for (String name : carNames) {
			if (name.length() > 5) {
				return true;
			}
		}
		return false;
	}
}
