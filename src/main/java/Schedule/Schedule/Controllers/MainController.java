package Schedule.Schedule.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Schedule.Schedule.models.CardData;

@Controller
public class MainController {
    @GetMapping("/")
    public String load(Model model) {
        CardData[] datas = CardData.initTestDatas();

        List<String> subjects = new ArrayList<>();
        List<String> teachers = new ArrayList<>();
        List<String> lessonsTypes = new ArrayList<>();
        List<String> homeworks = new ArrayList<>();
        List<String> times = new ArrayList<>();

        for (int i = 0; i < datas.length; i++) {
            subjects.add(datas[i].subjectName);
            teachers.add(datas[i].teacherName);
            lessonsTypes.add(datas[i].lessonType);
            homeworks.add(datas[i].homework);
            times.add(datas[i].time);
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
}
