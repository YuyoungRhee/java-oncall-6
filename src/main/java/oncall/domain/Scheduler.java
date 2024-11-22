package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private final Month month;
    private final Calender calender;
    private final WorkdayAllocator allocator;

    public Scheduler(Month month, Calender calender, WorkdayAllocator allocator) {
        this.month = month;
        this.calender = calender;
        this.allocator = allocator;
    }

    public List<String> makeSchedule() {
        List<String > workSchedules = new ArrayList<>();
        String beforeWorker = "";

        for (int date = 1; date<month.getEndDate()+1; date++) {
            boolean isHoliday = calender.isHoliday(month.getMonthNum(), date);
            String worker = singleSchedule(isHoliday, beforeWorker);
            workSchedules.add(worker);
            beforeWorker = worker;
        }
        return workSchedules;
    }

    private String singleSchedule(boolean isHoliday, String beforeWorker) {
        return allocator.allocate(isHoliday, beforeWorker);
    }

}
