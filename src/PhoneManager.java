import java.util.ArrayList;
import java.util.Scanner;


public class PhoneManager {
    private static PhoneManager instance;
    private final ArrayList<Phone> phoneList;

    public PhoneManager() {
        this.phoneList = new ArrayList<>();
    }

    public static PhoneManager getInstance() {
        if (instance == null) {
            instance = new PhoneManager();
        }
        return instance;
    }

    public void addPhone() {
        phoneList.add(Phone.addPhone());
    }

    public Phone searchPhone(String name) {
        for (Phone phone : phoneList) {
            if (phone.getName().equals(name)) {
                return phone;
            }
        }
        return null;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.print("인원수 >> ");
        int people = sc.nextInt();

        for (int i = 0; i < people; i++) {
            addPhone();
            // Phone 클래스를 공유하기 위해 콘솔 출력 메세지가 이 부분만 다름. Phone.java:29참조
        }
        System.out.println("저장되었습니다...");
        sc.nextLine();
        while (true) {
            System.out.print("검색할 이름 >> ");
            String searchName = sc.nextLine().trim();

            if (searchName.equals("exit")) {
                System.out.println("프로그램을 종료합니다...");
                break;
            }
            Phone result = searchPhone(searchName);
            if (result != null) {
                System.out.println(searchName + "의 번호는 " + result.getTel() + " 입니다.");
            } else {
                System.out.println(searchName + "은(는) 없습니다.");
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        PhoneManager phoneManager = PhoneManager.getInstance();
        phoneManager.run();
    }
}
