import java.io.StringReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean bool=true;
        while (bool){
            System.out.println();
            System.out.println("""
                Выберите что добавить
                1.Сертификат
                2.Курс
                3.Урок
                4.Записи
                5.Преподаватель
                6.Ничего не добавлять и завершить работу
                """);
            int swtch = scanner.nextInt();
            switch (swtch) {
                case 1: {
                    addCertificat();
                }
                break;
                case 2: {
                    addCourse();
                }
                break;
                case 3: {
                    addLesson();
                }
                break;
                case 4: {
                    addRecords();
                }
                break;
                case 5: {
                    addTeacher();
                }
                break;
                case 6:{bool=false;}break;
                default: {
                    System.out.println("Значение выходит за предусмотренные границы");
                }
                break;
            }
        }
    }
    public static void addCertificat() {
        BD bd = new BD();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название сертификата");
        String certificat_name=scanner.nextLine();
        System.out.println("Введите фамилию преподавателя");
        String teacher_name = scanner.next();
        int teacher_id = bd.findIntByName("id_teacher", "teachers", "teacher_surname", teacher_name);
        if (teacher_id != -1) {
            bd.addCertificate(certificat_name,teacher_id);
        } else {
            System.out.println("Преподаватель не найден");
        }
    }
    public static void addCourse() {
        BD bd = new BD();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название курса");
        String course_name=scanner.nextLine();
        System.out.println("Введите кол-во часов");
        int course_hours = scanner.nextInt();
        System.out.println("Введите фамилию преподавателя");
        String teacher_name = scanner.next();
        int teacher_id = bd.findIntByName("id_teacher", "teachers", "teacher_surname", teacher_name);
        if (teacher_id != -1) {
            bd.addCourse(course_name,course_hours,teacher_id);
        } else {
            System.out.println("Преподаватель не найден");
        }
    }
    public static void addLesson() {
        BD bd = new BD();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название курса");
        String course_name=scanner.nextLine();
        int course_id = bd.findIntByName("id_course", "courses", "course_name", course_name);
        System.out.println("Введите тему урока");
        String lesson_theme = scanner.nextLine();
        if (course_id != -1) {
            bd.addLesson(lesson_theme,course_id);
        } else {
            System.out.println("Курс не найден");
        }
    }
    public static void addRecords() {
        BD bd = new BD();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название курса");
        String course_name=scanner.nextLine();
        int course_id = bd.findIntByName("id_course", "courses", "course_name", course_name);
        System.out.println("Введите фамилию студента");
        String student_surname = scanner.next();
        if (course_id != -1) {
            bd.addRecords(student_surname,course_id);
        } else {
            System.out.println("Курс не найден");
        }
    }
    public static void addTeacher() {
        BD bd = new BD();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию преподавателя");
        String teacher_surname=scanner.next();
        System.out.println("Введите имя преподавателя");
        String teacher_name=scanner.next();
        System.out.println("Введите отчество преподавателя");
        String teacher_lastname=scanner.next();
        bd.addTeacher(teacher_surname,teacher_name,teacher_lastname);
    }
}