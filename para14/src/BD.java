import java.sql.*;

public class BD {
    public static String url = "jdbc:mysql://localhost/onlinecourses";
    public static String user = "root";
    public static String password = "";

    // открыть соединение
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    //закрыть соединение
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public int findIntByName(String idColumn,String tableName,String nameColumn,String name){
        //idColumn - название столбца с айди; tableName - название таблицы;
        // nameColumn - название столбца со значением для поиска; name - значение для поиска
        int id=-1;
        Connection connection=null;
        try {
            connection=openConnection();
            String query=String.format("SELECT %s FROM %s WHERE %s=?", idColumn,tableName,nameColumn);
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,name);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()){id=resultSet.getInt(idColumn);}
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("id не получен из "+tableName);
        } finally {
            closeConnection(connection);
        }
        return id;
    }
    public void addCertificate(String certificate_name,int teacher_id){
        Connection connection=null;
        try{
            connection=openConnection();
            String query="INSERT INTO `certificats` (`certificat_name`,`teacher_id`) VALUES (?,?)";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,certificate_name);
            statement.setInt(2,teacher_id);
            int count=statement.executeUpdate();
            if(count>0){
                System.out.println("Сертификат добавлен");
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Сертификат не добавлен");
        } finally {
            closeConnection(connection);
        }
    }
    public void addCourse(String course_name,int course_hours,int teacher_id){
        Connection connection=null;
        try{
            connection=openConnection();
            String query="INSERT INTO `courses` (`course_name`,`course_hours`,`teacher_id`) VALUES (?,?,?)";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,course_name);
            statement.setInt(2,course_hours);
            statement.setInt(3,teacher_id);
            int count=statement.executeUpdate();
            if(count>0){
                System.out.println("Курс добавлен");
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Курс не добавлен");
        } finally {
            closeConnection(connection);
        }
    }
    public void addLesson(String lesson_theme,int course_id){
        Connection connection=null;
        try{
            connection=openConnection();
            String query="INSERT INTO `lessons` (`lesson_theme`,`course_id`) VALUES (?,?)";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,lesson_theme);
            statement.setInt(2,course_id);
            int count=statement.executeUpdate();
            if(count>0){
                System.out.println("Урок добавлен");
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Урок не добавлен");
        } finally {
            closeConnection(connection);
        }
    }
    public void addRecords(String student_surname,int course_id){
        Connection connection=null;
        try{
            connection=openConnection();
            String query="INSERT INTO `records` (`student_surname`,`course_id`) VALUES (?,?)";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,student_surname);
            statement.setInt(2,course_id);
            int count=statement.executeUpdate();
            if(count>0){
                System.out.println("Запись добавлена");
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Запись не добавлена");
        } finally {
            closeConnection(connection);
        }
    }
    public void addTeacher(String teacher_surname,String teacher_name,String teacher_lastname){
        Connection connection=null;
        try{
            connection=openConnection();
            String query="INSERT INTO `teachers` (`teacher_surname`,`teacher_name`,`teacher_lastname`) VALUES (?,?,?)";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,teacher_surname);
            statement.setString(2,teacher_name);
            statement.setString(3,teacher_lastname);
            int count=statement.executeUpdate();
            if(count>0){
                System.out.println("Преподаватель добавлен");
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Преподаватель не добавлен");
        } finally {
            closeConnection(connection);
        }
    }
}
