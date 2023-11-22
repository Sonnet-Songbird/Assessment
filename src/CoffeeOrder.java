import java.util.InputMismatchException;
import java.util.Scanner;

class MenuList {
    private static final Object[][] menuList = {
            {"에스프레소", 2000},
            {"아메리카노", 2500},
            {"카푸치노", 3000},
            {"카페라떼", 3500}
    };

    public Object[] findMenu(String name) {
        for (Object[] menuInfo : menuList) {
            if (menuInfo[0].equals(name)) {
                return menuInfo;
            }
        }
        return null;
    }
}

class Order {
    private final String name;
    private final int price;
    private final int quantity;

    public Order(String name, int quantity) throws Exception {
        if (quantity < 0) {
            throw new Exception("수량은 음수일 수 없습니다.");
        }
        MenuList menuList = new MenuList();
        Object[] menuInfo = menuList.findMenu(name);

        if (menuInfo != null) {
            this.name = (String) menuInfo[0];
            this.price = (int) menuInfo[1];
            this.quantity = quantity;
        } else {
            throw new Exception("메뉴를 찾을 수 없거나 가격이 올바르지 않습니다.");
        }
    }

    public void displayPrice() {
        System.out.println(price * quantity + "원입니다.");
    }
}

public class CoffeeOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.print("커피 주문하세요 >> ");
                String inputMenuName = sc.next();
                if (!sc.hasNextInt()) {
                    throw new InputMismatchException("수량은 정수로 입력해야 합니다.");
                }
                int inputQuantity = sc.nextInt();
                Order order = new Order(inputMenuName, inputQuantity);
                inputValid = true;
                order.displayPrice();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }
}
