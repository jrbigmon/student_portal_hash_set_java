package models.services;

import java.util.List;

import models.entities.Classroom;
import models.entities.Student;
import models.entities.Teacher;

public interface IPortalReadCsvs {
  List<Student> readFileStudents(String path);

  List<Teacher> readFileTeachers(String path);

  List<Classroom> readFileClassrooms(String path);

  List<String[]> readFileTeachersToClassrooms(String path);

  List<String[]> readFileClassroomsToStudents(String path);
}
