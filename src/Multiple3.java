import java.util.InputMismatchException;
import java.util.Scanner;

class Numbers {
    private static final int SIZE = 10;
    private static final int MULTIPLE = 3;
    private final int[] NUMBERS = new int[SIZE];

    public void inputNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 " + SIZE + "개 입력 >> ");
        for (int i = 0; i < NUMBERS.length; i++) {
            try {
                int value = sc.nextInt();
                NUMBERS[i] = value;
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력 해 주세요.");
                sc.nextLine();
                i--;
            }
        }
    }

    public void multiple() {
        boolean found = false;
        System.out.print(MULTIPLE + "의 배수 >> ");
        for (int number : NUMBERS) {
            if (number % MULTIPLE == 0) {
                System.out.print(number + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("없음");
        }
    }
}

public class Multiple3 {
    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        numbers.inputNumbers();
        numbers.multiple();
    }
}
