import java.util.InputMismatchException;
import java.util.Scanner;

class Building {
    int heightPerFloor = 5;
    int floor;

    public Building(int floor) {
        this.floor = floor;
    }
// 필요시 heightPerFloor를 매개변수로 받는 생성자 추가

    public int height() {
        return heightPerFloor * floor;
    }
}

public class BuildingHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.print("몇 층인지 입력하세요 >> ");
                int floorInput = sc.nextInt();
                if (floorInput < 0) {
                    System.out.println("층 수는 음수가 될 수 없습니다. 다시 시도하세요.");
                } else {
                    Building building = new Building(floorInput);
                    inputValid = true;
                    System.out.println(building.height() + "m입니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("정수 값을 입력하세요. 다시 시도하세요.");
            } finally {
                sc.nextLine();
            }
        }
        sc.close();
    }
}

