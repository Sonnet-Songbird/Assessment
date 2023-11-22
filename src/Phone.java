import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
    private String name, tel;

    public Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public static Phone addPhone() {
        Scanner sc = new Scanner(System.in);
        String name, tel;
        boolean isValidTel;

        while (true) {
//             과제 6번의 경우
            System.out.print("이름과 전화번호 입력 >> ");
//             과제 7번의 경우
//            System.out.print("이름과 전화번호(번호는 연속적으로 입력) >> ");
            String input = sc.nextLine();
            String[] parts = input.split(" ");

            if (parts.length != 2) {
                System.out.println("입력 형식이 올바르지 않습니다. 다시 입력해주세요.");
            } else {
                name = parts[0];
                tel = parts[1];
                isValidTel = valiNum(tel);
                if (name.trim().isEmpty()) System.out.println("이름은 공백일 수 없습니다. 다시 입력해주세요.");
                else {
                    if (!isValidTel) {
                        System.out.println("전화번호 형식이 올바르지 않습니다. 다시 입력해주세요.");
                    } else {
                        break;
                    }
                }
            }
        }
        return new Phone(name, tel);
    }

    public void getPhone() {
        System.out.println(this.getName() + "의 번호 " + this.getTel());
    }

    private static boolean valiNum(String tel) {
        String pattern = "\\d{3}-\\d{4}";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(tel);

        return matcher.matches();
    }

    public static void main(String[] args) {
        Phone phone1 = addPhone();
        Phone phone2 = addPhone();

        phone1.getPhone();
        phone2.getPhone();
    }
}
