package domain;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputManager {

	private int trialTime;
	private String[] carNames;

	public void initialize() {
		inputCarNames();
		inputTrialTime();
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
	
	private void inputTrialTime() {
		Scanner input = new Scanner(System.in);
		System.out.println("�õ��� ȸ���� ��ȸ�ΰ���?");
		while (true) {
			try {
				trialTime = input.nextInt();
				createException(trialTime);
				break;
			} catch (InputMismatchException e) {
				System.out.println("���ڸ� �Է����ּ���.");
			} catch (Exception e) {
				System.out.println("���� ������ �Է����ּ���.");
			} finally {
				System.out.println("�õ��� ȸ���� ��ȸ�ΰ���?");
				input = new Scanner(System.in);
			}
		}
	}
	
	private void createException(int trialTime) throws Exception {
		if (trialTime <= 0) {
			throw new Exception();
		}
	}
	
}
