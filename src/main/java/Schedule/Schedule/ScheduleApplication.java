 package Schedule.Schedule;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import Schedule.Schedule.models.Lesson;
import Schedule.Schedule.repositories.ScheduleRepository;

@SpringBootApplication
public class ScheduleApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
		viewControllerRegistry.addViewController("/").setViewName("index.html");
	}

	@Bean
	CommandLineRunner dataLoader(ScheduleRepository repository) {
		return new CommandLineRunner() {
			@Override
			public void run(String ... args) {
				repository.save(new Lesson(
					0, 1, "Математика", "Антонова Е.В.", "Практика", "Дописать лекцию", 2, "вторник")
				);

				repository.save(new Lesson(
					1, 2, "Математика", "Антонова Е.В.", "Практика", "Дописать лекцию", 0, "вторник")
				);

				repository.save(new Lesson(
					2, 3, "Физика", "Касименко Л.М.", "Лекция", "", 0, "вторник")
				);

				repository.save(new Lesson(
					3, 4, "Физика", "Фамилия И.О.", "Лабораторная работа", "ЛР №1", 1, "вторник")
				);

				repository.save(new Lesson(
					4, 4, "ОРГ", "Рудыка Х.З.", "Лекция", "Презентация", 2, "вторник")
				);
			}
		};
	}

}
