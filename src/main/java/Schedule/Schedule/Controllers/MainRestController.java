package Schedule.Schedule.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Schedule.Schedule.models.Lessons;
import Schedule.Schedule.repositories.ScheduleRepository;

@RestController
public class MainRestController {
    private final ScheduleRepository scheduleRepository;

    private String currentDayOfTheWeek;

    public MainRestController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;

        currentDayOfTheWeek = "вторник";
    }

    @GetMapping("/rest")
    public List<Lessons> getLessons() {
        List<Lessons> lessons = scheduleRepository.getTodayLessons(MainController.currentWeekNumber, currentDayOfTheWeek);
        return lessons;
    }
}