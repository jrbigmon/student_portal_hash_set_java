package models.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.entities.Classroom;
import models.entities.Student;
import models.entities.Teacher;

public class PortalReadCsvs implements IPortalReadCsvs {
  public List<Student> readFileStudents(String path) {
    List<Student> students = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line = br.readLine();

      int count = 0;
      while (line != null) {
        if (count != 0) {
          String[] fields = line.split(",");

          if (fields.length == 2) {
            String id = fields[0].trim();
            String name = fields[1].trim();

            students.add(new Student(id, name));
          }
        }

        line = br.readLine();

        count++;
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    return students;
  }

  public List<Teacher> readFileTeachers(String path) {
    List<Teacher> teachers = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line = br.readLine();

      int count = 0;
      while (line != null) {
        if (count != 0) {
          String[] fields = line.split(",");

          if (fields.length == 2) {
            String id = fields[0].trim();
            String name = fields[1].trim();

            teachers.add(new Teacher(id, name));
          }
        }

        line = br.readLine();

        count++;
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    return teachers;
  }

  public List<Classroom> readFileClassrooms(String path) {
    List<Classroom> classrooms = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line = br.readLine();

      int count = 0;
      while (line != null) {
        if (count != 0) {
          String[] fields = line.split(",");

          if (fields.length == 2) {
            String id = fields[0].trim();
            String name = fields[1].trim();

            classrooms.add(new Classroom(id, name));
          }
        }

        line = br.readLine();

        count++;
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    return classrooms;
  }

  public List<String[]> readFileTeachersToClassrooms(String path) {
    List<String[]> teachersToClassRooms = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line = br.readLine();

      int count = 0;
      while (line != null) {
        if (count != 0) {
          String[] fields = line.split(",");

          if (fields.length == 2) {
            String teacherId = fields[0].trim();
            String classroomId = fields[1].trim();

            teachersToClassRooms.add(new String[] { teacherId, classroomId });
          }
        }

        line = br.readLine();

        count++;
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    return teachersToClassRooms;
  }

  public List<String[]> readFileClassroomsToStudents(String path) {
    List<String[]> classroomToStudents = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line = br.readLine();

      int count = 0;
      while (line != null) {
        if (count != 0) {
          String[] fields = line.split(",");

          if (fields.length == 2) {
            String classroomId = fields[0].trim();
            String studentId = fields[1].trim();

            classroomToStudents.add(new String[] { classroomId, studentId });
          }
        }

        line = br.readLine();

        count++;
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    return classroomToStudents;
  }

}
