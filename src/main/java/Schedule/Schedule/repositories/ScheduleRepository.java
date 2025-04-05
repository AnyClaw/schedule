package Schedule.Schedule.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import Schedule.Schedule.models.Lesson;
import jakarta.transaction.Transactional;

public interface ScheduleRepository extends CrudRepository<Lesson, Long> {

    @Query("SELECT COUNT(l) FROM Lesson l")
    int getLessonsCount();

    @Modifying
    @Transactional
    @Query("DELETE FROM Lesson l")
    void deleteAllLessons();

    @Query("SELECT l FROM Lesson l WHERE l.dayOfTheWeek = :dayOfTheWeek AND (l.weekNumber = :weekNumber OR l.weekNumber = 0)")
    List<Lesson> getTodayLessons(int weekNumber, String dayOfTheWeek);
}
