package oncall.controller;

import java.util.List;
import oncall.domain.Calender;
import oncall.domain.Month;
import oncall.domain.Scheduler;
import oncall.domain.Week;
import oncall.domain.WorkdayAllocator;
import oncall.domain.Workers;
import oncall.dto.DateInformDto;
import oncall.dto.MonthAndStartdayDto;
import oncall.view.OutputView;

public class WorkController {
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public WorkController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void run() {
        MonthAndStartdayDto monthAndStartday = inputHandler.getMonthAndStartday();
        Month month = monthAndStartday.getMonth();
        Week startday = monthAndStartday.getStartday();

        Workers weekdayOrer = inputHandler.getWeekdayOrer();
        Workers weekendOrer = inputHandler.getWeekendOrer();

        Calender calender = new Calender(month, startday);
        WorkdayAllocator allocator = new WorkdayAllocator(weekdayOrer, weekendOrer);
        Scheduler scheduler = new Scheduler(month, calender, allocator);

        List<DateInformDto> dateInformDtos = calender.makeDateInformDto();
        List<String> workSchedule = scheduler.makeSchedule();

        outputView.displayResult(dateInformDtos, workSchedule);
    }


}
