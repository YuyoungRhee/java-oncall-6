package oncall.domain;

public enum Week {
    MONDAY("월", 0),
    TUESDAY("화", 1),
    WEDNESDAY("수", 2),
    THURSDAY("목", 3),
    FRIDAY("금", 4),
    SATURDAY("토", 5),
    SUNDAY("일", 6);

    private final int weekNUmber;
    private final String dayName;

    Week(String dayName, int weekNUmber) {
        this.dayName = dayName;
        this.weekNUmber = weekNUmber;
    }

    public static Week from(String input) {
        for (Week week : Week.values()) {
            if (week.getDayName().equals(input)) {
                return week;
            }
        }
        throw new IllegalArgumentException("[ERROR] 요일을 정확히 입력해주세요.");
    }

    public int getWeekNUmber() {
        return weekNUmber;
    }

    public String getDayName() {
        return dayName;
    }
}
