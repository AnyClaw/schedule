package Schedule.Schedule.models;

import org.springframework.data.annotation.Id;

public class Lessons {
    @Id
    public long id;

    public int lessonNumber;
    public String lessonName;
    public String teacherName;
    public String lessonType;
    public String homework;
    public int weekNumber;
    public String dayOfTheWeek;

    public Lessons(int lessonNumber, String lessonName, String teacherName, String lessonType, String homework, int weekNumber, String dayOfTheWeek) {
        this.lessonNumber = lessonNumber;
        this.lessonName = lessonName;
        this.teacherName = teacherName;
        this.lessonType = lessonType;
        this.homework = homework;
        this.weekNumber = weekNumber;
        this.dayOfTheWeek = dayOfTheWeek;
    }
}
