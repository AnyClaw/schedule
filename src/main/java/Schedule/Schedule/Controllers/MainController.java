package Schedule.Schedule.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Schedule.Schedule.ScheduleException;
import Schedule.Schedule.models.Lessons;
import Schedule.Schedule.repositories.ScheduleRepository;

@Controller
public class MainController {
    private final ScheduleRepository scheduleRepository;

    private final List<String> times;

    public MainController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
        times = Arrays.asList("08:30 - 09:50", "10:05 - 11:25", "11:40 - 13:00", "13:45 - 15:05");
    }

    @GetMapping("/")
    public String load(Model model) {
        Lessons[] datas = Lessons.initTestDatas();

        List<String> subjects = new ArrayList<>();
        List<String> teachers = new ArrayList<>();
        List<String> lessonsTypes = new ArrayList<>();
        List<String> homeworks = new ArrayList<>();

        for (int i = 0; i < datas.length; i++) {
            subjects.add(datas[i].lessonName);
            teachers.add(datas[i].teacherName);
            lessonsTypes.add(datas[i].lessonType);
            homeworks.add(datas[i].homework);
        }

        model.addAttribute("subjects", subjects);
        model.addAttribute("teachers", teachers);
        model.addAttribute("lessonsTypes", lessonsTypes);
        model.addAttribute("homeworks", homeworks);
        model.addAttribute("times", times);

        return "index";
    }

    @PostMapping("/")
    public String newPage() {
        return "index";
    }

    @GetMapping("/db")
    public String getDataFromDb(Model model) throws ScheduleException {
        int lessonCount = scheduleRepository.getLessonsCount() + 6;
        System.out.println(lessonCount);

        List<String> lessonsName = new ArrayList<>();
        List<String> teachers = new ArrayList<>();
        List<String> lessonsTypes = new ArrayList<>();
        List<String> homeworks = new ArrayList<>();

        for (int i = 6; i < lessonCount; i++) {
            Lessons lesson = scheduleRepository.findById(i).orElse(null);   

            lessonsName.add(lesson.lessonName);
            teachers.add(lesson.teacherName);
            lessonsTypes.add(lesson.lessonType);
            homeworks.add(lesson.homework);
        }

        model.addAttribute("subjects", lessonsName);
        model.addAttribute("teachers", teachers);
        model.addAttribute("lessonsTypes", lessonsTypes);
        model.addAttribute("homeworks", homeworks);
        model.addAttribute("times", times);

        return "index";
    }

    @GetMapping("clear")
    public String clear() {
        scheduleRepository.delete();
        return "index";
    }
}
