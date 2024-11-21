package oncall.dto;

import oncall.domain.Month;
import oncall.domain.Week;

public class MonthAndStartdayDto {
    private final Month month;
    private final Week startDay;

    public MonthAndStartdayDto(Month month, Week startDay) {
        this.month = month;
        this.startDay = startDay;
    }

    public Month getMonth() {
        return month;
    }

    public Week getStartday() {
        return startDay;
    }
}
