package database;

import entity.Account;
import entity.Discipline;
import entity.Semestr;
import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    public static List<Discipline> getAllActiveDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from discipline where status = 1");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public static Discipline getDisciplinesbyid(String id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from discipline where status = 1 and id = " + id);
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                return discipline;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void createDisciplines(String newDisc) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students_1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `discipline` (`discipline`)  VALUES ('" + newDisc + "')\n;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createStudents(String newSurname, String newName, String newGroup, String newDate) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `student` (`surname`, `name`, `group`, `date`) VALUES ('" + newSurname + "', '" + newName + "', '" + newGroup + "', '" + newDate + "')\n;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Semestr> getAllActiveSemestrs() {
        ArrayList<Semestr> semestrs = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from semestr where status = 1");
            while (rs.next()) {
                Semestr semestr = new Semestr();
                semestr.setId(rs.getInt("id"));
                semestr.setSemestr(rs.getString("semestr"));
                semestr.setDuration(rs.getString("duration"));

                semestrs.add(semestr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return semestrs;
    }

    public static List<Student> getAllActiveStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student where status = 1");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSurname(rs.getString("surname"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getString("date"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void modifyDisciplines(String idDisc, String newName) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `discipline` SET `discipline` = '" + newName + "' WHERE (`id` = '" + idDisc + "');\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void deleteDiscipline(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` = '" + id + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Account getAccount(String login, String password, String role) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM account where login = '" + login + "' and password = '" + password + "' and role = '" + role + "';");
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setLogin(rs.getString("login"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getString("role"));
                return account;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void modifyStudent(String newId, String newSurname, String newName, String newGroup, String newDate) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `student` SET `surname` = '" + newSurname + "', `name` = '" + newName + "', `group` = '" + newGroup + "', `date` = '" + newDate + "' WHERE (`id` = '" + newId + "');\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Student getStudentbyid(String idStud) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student where status = 1 and id = " + idStud);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSurname(rs.getString("surname"));
                student.setName(rs.getString("name"));
                student.setDate(rs.getString("date"));
                student.setGroup(rs.getString("group"));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteStudents(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `student` SET `status` = '0' WHERE (`id` = '" + id + "');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void createSemestr(String newSemestr, String newDuration) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `semestr` (`semestr`, `duration`) VALUES ('" + newSemestr + "', '" + newDuration + "');\n;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void postSelectDiscipline(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();

            ResultSet idLastSem = stmt.executeQuery("SELECT MAX(`id`) FROM `semestr`");

            int idSem = idLastSem.getInt("id");

            stmt.execute("INSERT INTO `semestr_discipline` (`id_ semestr`, `id_disciplines`) VALUES ('" + idSem + "', '" + id + "');\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Semestr getSemestrbyid(String idSem) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from semestr where status = 1 and id = " + idSem);
            while (rs.next()) {
                Semestr semestr = new Semestr();
                semestr.setId(rs.getInt("id"));
                semestr.setDuration(rs.getString("duration"));

                return semestr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void modifySemestr(String newId, String newDuration) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `semestr` SET `duration` = '" + newDuration + "' WHERE (`id` = '" + newId + "');\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void modifySelectDiscipline(String newId, String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();

            stmt.execute("INSERT INTO `semestr_discipline` (`id_ semestr`, `id_disciplines`) VALUES ('" + newId + "', '" + id + "');\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Discipline> getDisciplinesInSemestr(String idSem) {
        ArrayList<Discipline> disciplinesInSemestr = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM semestr_discipline as sd\n" +
                    "left join discipline as d on sd.id_disciplines = d.id\n" +
                    "where sd.id_semestr = "+idSem+" and d.status = 1");

            while (rs.next()) {
                Discipline discipline = new Discipline();
                int idDisc = rs.getInt("id_disciplines");
                discipline.setId(idDisc);
                discipline.setDiscipline(rs.getString("discipline"));
                disciplinesInSemestr.add(discipline);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplinesInSemestr;
    }
}
