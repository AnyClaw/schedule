package Schedule.Schedule.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import Schedule.Schedule.models.Lessons;

public interface ScheduleRepository extends CrudRepository<Lessons, Long> {
    @Query("SELECT COUNT(*) FROM schedule.lessons;")
    int getLessonsCount();

    @Modifying
    @Query("DELETE FROM schedule.lessons")
    void delete();

    @Query("SELECT * FROM schedule.lessons WHERE day_of_the_week = :dayOfTheWeek AND (week_number = :weekNumber OR week_number = 0)")
    List<Lessons> getTodayLessons(int weekNumber, String dayOfTheWeek);

    @Query("SELECT * FROM schedule.lessons")
    List<Lessons> getAllLessons();
}
