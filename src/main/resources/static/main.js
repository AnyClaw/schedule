async function fetchLessons() {
    try {
        const response = await fetch('/rest');
        if (!response.ok) {
            throw new Error('Сетевая ошибка');
        }
        const lessons = await response.json();
        displayLessons(lessons);
        displayWeekInfo(lessons);
    } catch (error) {
        console.error('Ошибка при получении данных:', error);
    }
}

function displayLessons(lessons) {
    var page = document.getElementById("lessons");
    var times = ["08:30 - 09:50", "10:05 - 11:25", "11:40 - 13:00", "13:45 - 15:05"];

    for (var i = 0; i < lessons.length; i++) {
        page.innerHTML += `
            <div class="parent">
            <div class="content">
                <ul class="day-info">
                    <li>
                        <div class="text">
                            <div class="subject">${lessons[i].lessonNumber}.</div>
                        </div>
                    </li>

                    <li>
                        <div class="text">
                            <div class="subject">${lessons[i].lessonName} <br> (${lessons[i].lessonType})</div>
                            <div class="additions">${lessons[i].teacherName}</div>
                            <div class="additions homework">${lessons[i].homework != "" ? "ДЗ: " + lessons[i].homework : ""}</div>
                        </div>
                    </li>
                    
                    <li>
                        <div class="text">
                            <div class="time">${times[lessons[i].lessonNumber - 1]}</div>
                        </div>
                    </li>
                </ul>   
            </div>
        </div>
        `
    }
}

function displayWeekInfo(lessons) {
    var weekNumber = 0;
    for (var i = 0; i < lessons.length; i++) {
        if (lessons[i].weekNumber != 0) {
            weekNumber = lessons[i].weekNumber;
            break;
        }
    }

    var weekPanel = document.getElementById("weekInfo").innerHTML += `10.02 - 16.02<br>${weekNumber} неделя`;
}

document.addEventListener('DOMContentLoaded', fetchLessons);