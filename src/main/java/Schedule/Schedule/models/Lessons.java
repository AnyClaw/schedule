package Schedule.Schedule.models;

import org.springframework.data.annotation.Id;

public class Lessons {
    @Id
    public int lessonNumber;

    public String lessonName;
    public String teacherName;
    public String lessonType;
    public String homework;

    public Lessons(String lessonName, String teacherName, String lessonType, String homework) {
        this.lessonName = lessonName;
        this.teacherName = teacherName;
        this.lessonType = lessonType;
        this.homework = homework;
    }

    public static Lessons[] initTestDatas() {
        Lessons[] datas = new Lessons[4];

        var subjects = new String[] {
            "Математика", 
            "Математика", 
            "Физика",
            "Основы Российской государственности"
        };
        var teachers = new String[] {
            "Антонова Е.В.",
            "Антонова Е.В.",
            "Касименко Л.М.",
            "Рудыка Н.А."
        };
        var lessonsTypes = new String[] {
            "Практическое занятие",
            "Практическое занятие",
            "Лекция",
            "Лекция"
        };
        var homeworks = new String[] {
            "Дописать лекцию",
            "Дописать лекцию",
            "",
            "Презентация \"Моя самоидентификация\""
        };

        for (int i = 0; i < datas.length; i++) {
            datas[i] = new Lessons(subjects[i], teachers[i], lessonsTypes[i], homeworks[i]);
        }

        return datas;
    }
}
