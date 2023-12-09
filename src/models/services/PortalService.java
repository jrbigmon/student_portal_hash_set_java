package models.services;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import models.entities.Classroom;
import models.entities.Student;
import models.entities.Teacher;

public class PortalService implements IPortalService {
  private Set<Classroom> classrooms = new TreeSet<>();
  private Set<Student> students = new TreeSet<>();
  private Set<Teacher> teachers = new TreeSet<>();

  public PortalService() {
  }

  public PortalService(List<Classroom> classrooms, List<Student> students, List<Teacher> teachers) {
    this.classrooms.addAll(classrooms);
    this.students.addAll(students);
    this.teachers.addAll(teachers);
  }

  public void setClassrooms(List<Classroom> classrooms) {
    this.classrooms.addAll(classrooms);
  }

  public void setStudents(List<Student> students) {
    this.students.addAll(students);
  }

  public void setTeachers(List<Teacher> teachers) {
    this.teachers.addAll(teachers);
  }

  @Override
  public void associateClassroomToStudent(String classroomId, String studentId) {
    Classroom classroom = this.classrooms.stream().filter(c -> c.getId().equals(classroomId)).findAny().orElse(null);
    Student student = this.students.stream().filter(s -> s.getId().equals(studentId)).findAny().orElse(null);

    if (classroom == null) {
      throw new IllegalArgumentException("Classroom: " + classroomId + " not found");
    }

    if (student == null) {
      throw new IllegalArgumentException("Student: " + studentId + " not found");
    }

    classroom.addStudent(student);
  }

  @Override
  public void associateTeacherToClassroom(String teacherId, String classroomId) {
    Teacher teacher = this.teachers.stream().filter(s -> s.getId().equals(teacherId)).findAny().orElse(null);
    Classroom classroom = this.classrooms.stream().filter(c -> c.getId().equals(classroomId)).findAny().orElse(null);

    if (classroom == null) {
      throw new IllegalArgumentException("Classroom: " + classroomId + " not found");
    }

    if (teacher == null) {
      throw new IllegalArgumentException("Teacher: " + teacherId + " not found");
    }

    teacher.addClassroom(classroom);
  }

  @Override
  public Set<Student> getAllStudentsByTeacherId(String teacherId) {
    if (teacherId == null) {
      throw new IllegalArgumentException("Teacher id is required");
    }

    Teacher teacher = this.teachers.stream().filter(t -> t.getId().equals(teacherId)).findAny().orElse(null);

    if (teacher == null) {
      throw new IllegalArgumentException("Teacher not found");
    }

    return teacher.getAllStudents();
  }
}
