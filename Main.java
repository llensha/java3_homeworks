package Lesson_2.Homework_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) {

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            createTable("students",
                    " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT, " +
                    " score INTEGER ");

            insertStudents("Pit", 55);
            insertStudents("Mel", 20);
            insertStudents("Steve", 55);
            insertStudents("Bob", 30);

            insertStudentsFromFile("test.txt");

            selectStudentsByScore(55);

            deleteStudentsByName("Bob");

            dropTable("students");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();

    }



    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(String table, String columns) throws SQLException {
        stmt.executeUpdate(String.format("CREATE TABLE IF NOT EXISTS %s (%s);", table, columns));
    }

    private static void insertStudents(String name, int score) throws SQLException {
        pstmt = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?,?);");
        pstmt.setString(1, name);
        pstmt.setInt(2, score);
        pstmt.executeUpdate();
    }

    private static void insertStudentsFromFile(String fileName) throws SQLException {
        Scanner scanner = null;
        try {
            File file = new File(fileName);
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine().trim();
                String[] tokens = data.split(" ");
                String name = tokens[1];
                int score = Integer.parseInt(tokens[2]);
                insertStudents(name, score);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void selectStudentsByScore(int score) throws SQLException {
        pstmt = connection.prepareStatement("SELECT name FROM students WHERE score = ?;");
        pstmt.setInt(1, score);
        ResultSet rs = pstmt.executeQuery();
        System.out.printf("Имена студентов, с количеством баллов = %s:\n", score);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

    private static void deleteStudentsByName(String name) throws SQLException {
        pstmt = connection.prepareStatement("DELETE FROM students where name = ?;");
        pstmt.setString(1, name);
        pstmt.executeUpdate();
    }

    private static void dropTable(String table) throws SQLException {
        stmt.executeUpdate(String.format("DROP TABLE IF EXISTS %s;", table));
    }



}
