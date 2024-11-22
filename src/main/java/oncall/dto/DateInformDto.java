package oncall.dto;

public class DateInformDto {
    private final int month;
    private final int date;
    private final String dayOfWeek;
    private final boolean isHoliday;

    public DateInformDto(int month, int date, String dayOfWeek, boolean isHoliday) {
        this.month = month;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.isHoliday = isHoliday;
    }

    public static DateInformDto of(int month, int date, String dayOfWeek, boolean isHoliday) {
        return new DateInformDto(month, date, dayOfWeek, isHoliday);
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isHoliday() {
        return isHoliday;
    }
}
