package models.services;

import java.util.Set;

import models.entities.Student;

public interface IPortalService {
  void associateClassroomToStudent(String classroomId, String studentId);

  void associateTeacherToClassroom(String teacherId, String classroomId);

  Set<Student> getAllStudentsByTeacherId(String teacherId);
}
