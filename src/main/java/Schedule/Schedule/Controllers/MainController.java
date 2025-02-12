package Schedule.Schedule.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String load() {
        return "index";
    }

    @PostMapping("/")
    public String newPage(Model model) {
        return "index";
    }
}
