import java.util.HashMap;
import java.util.Scanner;

public class CoffeeHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> Menu = new HashMap<>();
        Menu.put("에스프레소", 2000);
        Menu.put("아메리카노", 2500);
        Menu.put("카푸치노", 3000);
        Menu.put("카페라떼", 3500);

        Scanner sc = new Scanner(System.in);
        System.out.println("에스프레소, 아메리카노, 카푸치노, 카페라떼 있습니다.");

        while (true) {
            System.out.print("주문 >> ");
            String order = sc.nextLine();
            if (Menu.containsKey(order)) {
                int price = Menu.get(order);
                System.out.println(order + "는 " + price + "원 입니다.");
            } else if (order.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("해당하는 커피가 없습니다. ");
            }

        }
        sc.close();
    }
}

