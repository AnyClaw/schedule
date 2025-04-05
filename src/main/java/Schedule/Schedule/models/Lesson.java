package Schedule.Schedule.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    private long id;

    private int lessonNumber;
    private String lessonName;
    private String teacherName;
    private String lessonType;
    private String homework;
    private int weekNumber;
    private String dayOfTheWeek;
}
