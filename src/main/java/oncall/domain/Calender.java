package oncall.domain;

import java.util.ArrayList;
import java.util.List;
import oncall.dto.DateInformDto;

public class Calender {
    private final Month month;
    private final Week startDay;

    public Calender(Month month, Week startDay) {
        this.month = month;
        this.startDay = startDay;
    }

    public List<DateInformDto> makeDateInformDto() {
        List<DateInformDto> dateInforms = new ArrayList<>();
        for (int date = 1; date< month.getEndDate()+1; date++){
            dateInforms.add(DateInformDto.of(month.getMonthNum(),
                    date,
                    getDayOfWeek(date),
                    isLegalHoliday(month.getMonthNum(), date)));
        }
        return dateInforms;
    }

    public String getDayOfWeek(int date) {
        if ((date + startDay.getWeekNUmber()) % 7 == 1) {
            return "월";
        }
        if ((date + startDay.getWeekNUmber()) % 7 == 2) {
            return "화";
        }
        if ((date + startDay.getWeekNUmber()) % 7 == 3) {
            return "수";
        }
        if ((date + startDay.getWeekNUmber()) % 7 == 4) {
            return "목";
        }
        if ((date + startDay.getWeekNUmber()) % 7 == 5) {
            return "금";
        }
        if ((date + startDay.getWeekNUmber()) % 7 == 6) {
            return "토";
        }
        if ((date + startDay.getWeekNUmber()) % 7 == 0 ) {
            return "일";
        }
        throw new IllegalArgumentException("[ERROR] 오류가 발생했습니다.");
    }

    public boolean isHoliday(int Month, int date) {
        return isWeekend(date) || isLegalHoliday(Month, date);
    }

    private boolean isWeekend(int date) {
        return (date + startDay.getWeekNUmber()) % 7 == 0 || (date + startDay.getWeekNUmber()) % 7 == 6;
    }

    private boolean isLegalHoliday(int month, int date) {
        if (month == 1 && date == 1) {
            return true;
        }
        if (month == 3 && date == 5) {
            return true;
        }
        if (month == 5 && date == 5) {
            return true;
        }
        if (month == 6 && date == 6) {
            return true;
        }
        if (month == 8 && date == 15) {
            return true;
        }
        if (month == 10 && date == 3) {
            return true;
        }
        if (month == 10 && date == 9) {
            return true;
        }
        if (month == 12 && date == 25) {
            return true;
        }
        return false;
    }






}
