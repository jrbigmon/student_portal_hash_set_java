package models.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.entities.Classroom;
import models.entities.Student;
import models.entities.Teacher;

public class PortalReadCsvs implements IPortalReadCsvs {

  public List<Student> readFileStudents(String fileName) {
    return readFile(fileName, Student.class);
  }

  public List<Teacher> readFileTeachers(String fileName) {
    return readFile(fileName, Teacher.class);
  }

  public List<Classroom> readFileClassrooms(String fileName) {
    return readFile(fileName, Classroom.class);
  }

  public List<String[]> readFileTeachersToClassrooms(String fileName) {
    return readFile(fileName, String[].class);
  }

  public List<String[]> readFileClassroomsToStudents(String fileName) {
    return readFile(fileName, String[].class);
  }

  private <T> List<T> readFile(String fileName, Class<T> clazz) {
    List<T> entities = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(
        new FileReader(getResourceAsStream(fileName)))) {
      String line = br.readLine();

      int count = 0;
      while (line != null) {
        if (count != 0) {
          String[] fields = line.split(",");

          if (fields.length == 2) {
            String id = fields[0].trim();
            String name = fields[1].trim();

            if (clazz == Student.class) {
              entities.add(clazz.cast(new Student(id, name)));
            } else if (clazz == Teacher.class) {
              entities.add(clazz.cast(new Teacher(id, name)));
            } else if (clazz == Classroom.class) {
              entities.add(clazz.cast(new Classroom(id, name)));
            } else if (clazz == String[].class) {
              entities.add(clazz.cast(new String[] { id, name }));
            }
          }
        }

        line = br.readLine();

        count++;
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    return entities;
  }

  private String getResourceAsStream(String fileName) {
    return new File(fileName).getAbsolutePath();
  }

}
