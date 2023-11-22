import java.util.InputMismatchException;
import java.util.Scanner;

class Game {
    public static String play(int number) {
        String strNumber = String.valueOf(number);
        int hitCount = 0;

        for (int i = 0; i < strNumber.length(); i++) {
            char digit = strNumber.charAt(i);
            if (digit == '3' || digit == '6' || digit == '9') {
                hitCount++;
            }
        }

        if (hitCount == 1) {
            return "박수짝";
        } else if (hitCount == 2) {
            return "박수짝짝";
        } else {
            return "박수없음";
        }
    }
}

public class Game369 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("1 ~ 99 사이의 정수를 입력하세요 >> ");
                int number = sc.nextInt();
                if (number < 0 || number > 99) {
                    throw new IllegalArgumentException("");
                }
                if (number == 0) {
                    System.out.println("종료합니다.");
                    break;
                }
                System.out.println(Game.play(number));
            } catch (InputMismatchException e) {
                System.out.println("입력값은 정수여야 합니다.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("입력값은 0부터 99까지의 범위 내에 있어야 합니다.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}