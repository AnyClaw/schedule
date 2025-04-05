package Schedule.Schedule.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Schedule.Schedule.models.Lesson;
import Schedule.Schedule.repositories.ScheduleRepository;

@Controller
public class MainController {
    private final ScheduleRepository scheduleRepository;

    private String currentDayOfTheWeek;
    public static int currentWeekNumber;

    public MainController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;

        currentDayOfTheWeek = "вторник";
        currentWeekNumber = 1;
    }

    @GetMapping("/rest")
    @ResponseBody
    public List<Lesson> getLessons() {
        List<Lesson> lessons = scheduleRepository.getTodayLessons(MainController.currentWeekNumber, currentDayOfTheWeek);
        return lessons;
    }

    @PostMapping("/r")
    public String newPage(@RequestParam String value) {
        if (value.equals("+")) {
            if (currentWeekNumber == 1) currentWeekNumber++;
            else currentWeekNumber--;
        }
        else {
            if (currentWeekNumber == 2) currentWeekNumber--;
            else currentWeekNumber++;
        }

        return "redirect:/";
    }
}