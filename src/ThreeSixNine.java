import java.util.Scanner;

class Translator {
    String eng[] = {"student", "love", "java", "happy", "future"};
    String kor[] = {"학생", "사랑", "자바", "행복한", "미래"};

    public String translate(String input) {
        for (int i = 0; i < eng.length; i++) {
            if (eng[i].equalsIgnoreCase(input)) {
                return kor[i];
            }
        }
        return "그런 영어 단어가 없습니다.";
    }
}

public class ThreeSixNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Translator translator = new Translator();

        while (true) {
            System.out.print("영어 단어를 입력하세요 >> ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다.");
                break;
            }
            System.out.println(translator.translate(input));
        }

        sc.close();
    }
}

