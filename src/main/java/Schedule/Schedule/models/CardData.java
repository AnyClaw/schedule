package Schedule.Schedule.models;

public class CardData {
    public String subjectName;
    public String teacherName;
    public String lessonType;
    public String homework;
    public String time;

    public CardData(String subjectName, String teacherName, String lessonType, String homework, String time) {
        this.subjectName = subjectName;
        this.teacherName = teacherName;
        this.lessonType = lessonType;
        this.homework = homework;
        this.time = time;
    }

    public static CardData[] initTestDatas() {
        CardData[] datas = new CardData[4];

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
            "Практическое&nbsp;занятие",
            "Практическое&nbsp;занятие",
            "Лекция",
            "Лекция"
        };
        var homeworks = new String[] {
            "Дописать лекцию",
            "Дописать лекцию",
            "",
            "Презентация \"Моя самоидентификация\""
        };
        var times = new String[] {"08:30 - 09:50", "10:05 - 11:25", "11:40 - 13:00", "13:45 - 15:05"};

        for (int i = 0; i < datas.length; i++) {
            datas[i] = new CardData(subjects[i], teachers[i], lessonsTypes[i], homeworks[i], times[i]);
        }

        return datas;
    }
}
