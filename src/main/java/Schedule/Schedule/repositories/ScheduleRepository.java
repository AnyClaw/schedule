package Schedule.Schedule.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import Schedule.Schedule.models.Lessons;

public interface ScheduleRepository extends CrudRepository<Lessons, Integer> {
    @Query("SELECT COUNT(*) FROM schedule.lessons;")
    int getLessonsCount();

    @Modifying
    @Query("DELETE FROM schedule.lessons")
    void delete();
}
