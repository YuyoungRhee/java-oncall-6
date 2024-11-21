package oncall.domain;

import java.util.List;

public class WorkdayAllocator {
    private final List<String> weekdayPersons;
    private final List<String> weekendPersons;

    public WorkdayAllocator(Workers weekdayOrder, Workers weekendOrder) {
        this.weekdayPersons = weekdayOrder.getPersons();
        this.weekendPersons = weekendOrder.getPersons();
    }

    public String allocate(boolean isHoliday, String beforeWorker) {
        if (isHoliday) {
            int index = 0;
            while (weekendPersons.get(index).equals(beforeWorker)) {
                index++;
            }
            String nextWorker = weekendPersons.remove(index);
            weekendPersons.add(nextWorker);
            return nextWorker;
        }
        int index = 0;
        while (weekdayPersons.get(index).equals(beforeWorker)) {
            index++;
        }
        String nextWorker = weekdayPersons.remove(index);
        weekdayPersons.add(nextWorker);
        return nextWorker;
    }

}
