import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapNation {
    private static final int COUNTRY_QUANTITY = 5;

    public static void main(String[] args) {
        Map<String, Integer> nations = new HashMap<>();
        for (int i = 0; i < COUNTRY_QUANTITY; i++) {
            System.out.print("나라 이름, 인구 >> ");
            addContry(nations);
        }
        Map.Entry<String, Integer> mostPop = mostPop(nations);
        System.out.println("제일 인구가 많은 나라는 (" + mostPop.getKey() + ", " + mostPop.getValue() + ")");
    }

    private static void addContry(Map<String, Integer> nations) {
        Scanner sc = new Scanner(System.in);

        try {
            String input = sc.nextLine().trim();
            String[] inputArray = input.split(" ");

            if (inputArray.length != 2) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            String country = inputArray[0];
            int population = Integer.parseInt(inputArray[1]);
            if (population <= 0) {
                throw new IllegalArgumentException("인구는 음수일 수 없습니다.");
            }

            nations.put(country, population);
        } catch (NumberFormatException e) {
            System.out.println("인구는 정수로 입력되어야 합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Map.Entry<String, Integer> mostPop(Map<String, Integer> nations) {
        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : nations.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }
}
