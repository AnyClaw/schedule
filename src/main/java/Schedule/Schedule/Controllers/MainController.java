package Schedule.Schedule.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Schedule.Schedule.repositories.ScheduleRepository;

@Controller
public class MainController {
    public static int currentWeekNumber;

    public MainController(ScheduleRepository scheduleRepository) {
        currentWeekNumber = 1;
    }

    @PostMapping("/r")
    public String newPage(@RequestParam(name = "value") String value) {
        if (value.equals("+")) {
            if (currentWeekNumber == 1) currentWeekNumber++;
            else currentWeekNumber--;
        }
        else {
            if (currentWeekNumber == 2) currentWeekNumber--;
            else currentWeekNumber++;
        }

        return "index";
    }

    @GetMapping("/r")
    public String getIndex() {
        return "index";
    }
}
