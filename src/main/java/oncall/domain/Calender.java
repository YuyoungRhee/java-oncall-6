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
