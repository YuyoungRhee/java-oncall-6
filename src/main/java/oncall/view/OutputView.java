package oncall.view;

import java.util.List;
import oncall.dto.DateInformDto;

public class OutputView {

    public void displayResult(List<DateInformDto> dateInforms, List<String> workSchedules) {
        if (dateInforms.size() != workSchedules.size()) {
            throw new IllegalArgumentException("DateInformDto 리스트와 workSchedules 리스트의 크기가 다릅니다.");
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < dateInforms.size(); i++) {
            DateInformDto dateInform = dateInforms.get(i);
            String worker = workSchedules.get(i);

            result.append(String.format("%d월 %d일 %s",
                    dateInform.getMonth(),
                    dateInform.getDate(),
                    dateInform.getDayOfWeek()));
            if (dateInform.isHoliday()) {
                result.append("(휴일)");
            }
            result.append(" ")
                    .append(worker)
                    .append("\n");
        }

        System.out.println(result);
    }
}
