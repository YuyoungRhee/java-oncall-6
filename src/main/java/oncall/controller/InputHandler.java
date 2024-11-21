package oncall.controller;

import java.util.List;
import oncall.domain.Month;
import oncall.domain.Week;
import oncall.domain.Workers;
import oncall.dto.MonthAndStartdayDto;
import oncall.util.Util;
import oncall.view.InputView;

public class InputHandler {
    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public MonthAndStartdayDto getMonthAndStartday() {
        while (true) {
            try {
                String input = inputView.readMonthAndStartday();
                List<String> inputs = Util.parseInput(input);
                InputValidator.validateMonthAndStartday(inputs);

                String monthInput = inputs.get(0);
                Month month = Month.from(Util.convertToInteger(monthInput));

                String startdayInput = inputs.get(1);
                Week startDay = Week.from(startdayInput);

                return new MonthAndStartdayDto(month, startDay);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Workers getWeekdayOrer() {
        while (true) {
            try {
                String input = inputView.readWeekdayOrder();
                List<String> inputStrings = Util.convertToList(input);
                return new Workers(inputStrings);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public Workers getWeekendOrer() {
        while (true) {
            try {
                String input = inputView.readWeekendOrder();
                List<String> inputStrings = Util.convertToList(input);
                return new Workers(inputStrings);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
