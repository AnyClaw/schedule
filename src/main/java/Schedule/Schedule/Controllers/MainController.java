package Schedule.Schedule.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Schedule.Schedule.models.Lessons;
import Schedule.Schedule.repositories.ScheduleRepository;

@Controller
public class MainController {
    private final ScheduleRepository scheduleRepository;

    private final List<String> times;
    private String currentDayOfTheWeek;
    private int currentWeekNumber;

    public MainController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;

        times = Arrays.asList("08:30 - 09:50", "10:05 - 11:25", "11:40 - 13:00", "13:45 - 15:05");
        currentDayOfTheWeek = "вторник";
        currentWeekNumber = 1;
    }

    @PostMapping("/")
    public String newPage(@RequestParam(name = "value") String value) {
        if (value.equals("+")) {
            if (currentWeekNumber == 1) currentWeekNumber++;
            else currentWeekNumber--;
        }
        else {
            if (currentWeekNumber == 2) currentWeekNumber--;
            else currentWeekNumber++;
        }

        return "redirect:/db";
    }

    @GetMapping("/db")
    public String getDataFromDb(Model model) {
        List<Integer> lessonsNumber = new ArrayList<>();
        List<String> lessonsName = new ArrayList<>();
        List<String> teachers = new ArrayList<>();
        List<String> lessonsTypes = new ArrayList<>();
        List<String> homeworks = new ArrayList<>();

        List<Lessons> todayLessons = scheduleRepository.getTodayLessons(currentWeekNumber, currentDayOfTheWeek);

        for (Lessons lesson : todayLessons) {
            lessonsNumber.add(lesson.lessonNumber);
            lessonsName.add(lesson.lessonName);
            teachers.add(lesson.teacherName);
            lessonsTypes.add(lesson.lessonType);
            homeworks.add(lesson.homework);
        }
        
        model.addAttribute("number", lessonsNumber);
        model.addAttribute("subjects", lessonsName);
        model.addAttribute("teachers", teachers);
        model.addAttribute("lessonsTypes", lessonsTypes);
        model.addAttribute("homeworks", homeworks);
        model.addAttribute("times", times);
        model.addAttribute("dayOfTheWeek", currentDayOfTheWeek);
        model.addAttribute("weekNumber", currentWeekNumber);

        return "index";
    }

    @GetMapping("/clear")
    public String clear() {
        scheduleRepository.delete();
        return "index";
    }
}
