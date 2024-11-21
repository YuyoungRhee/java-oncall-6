package oncall.domain;

public enum Month {
    January(1, 31),
    February(2, 28),
    March(3, 31),
    April(4, 30),
    May(5, 31),
    June(6, 30),
    July(7, 31),
    August(8, 31),
    September(9, 30),
    October(10, 31),
    November(11, 30),
    December(12, 31);

    private final int monthNum;
    private final int endDate;

    Month(int monthNum, int endDate) {
        this.monthNum = monthNum;
        this.endDate = endDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public int getMonthNum() {
        return monthNum;
    }

    public static Month from(int input) {
        for (Month month: Month.values()) {
            if (month.getMonthNum() == input) {
                return month;
            }
        }
        throw new IllegalArgumentException("[ERROR] 월은 1월부터 12 사이의 숫자여야합니다.");
    }

}
