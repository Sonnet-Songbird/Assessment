import java.util.Random;

public class Equals {
    public static void main(String[] args) {
        Random random = new Random();
        int num1, num2, num3;
        boolean hit = false;
        while (!hit) {
            num1 = random.nextInt(3) + 1;
            num2 = random.nextInt(3) + 1;
            num3 = random.nextInt(3) + 1;
            System.out.println(num1 + "   " + num2 + "   " + num3);
            if ((num1 == num2 && num2 == num3)) {
                hit = true;
            }
        }
        System.out.println("성공");
    }
}
