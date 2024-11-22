package oncall.controller;

import java.util.List;

public class InputValidator {

    public static void validateMonthAndStartday(List<String> input) {
        if (input.size() != 2) {
            throw new IllegalArgumentException("[ERROR] 월과 시작요일 2개만 입력해주세요.");
        }
    }

}
