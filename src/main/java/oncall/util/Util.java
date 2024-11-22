package oncall.util;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<String> parseInput(String input) {
        validateNullOrBlank(input);
        return Arrays.asList(input.split(","));
    }

    public static Integer convertToInteger(String number) {
        validateNumeric(number);
        return Integer.parseInt(number.trim());
    }

    public static List<String> convertToList(String input) {
        validateNullOrBlank(input);
        return Arrays.asList(input.split(","));
    }
    private static void validateNullOrBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값은 비어있거나 공백일 수 없습니다.");
        }
    }

    private static void validateNumeric(String input) {
        try {
            Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 요일은 숫자여야합니다.");
        }
    }

}
