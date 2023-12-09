package application;

import java.util.List;

import models.entities.Classroom;
import models.entities.Student;
import models.entities.Teacher;
import models.services.IPortalReadCsvs;
import models.services.IPortalService;
import models.services.PortalReadCsvs;
import models.services.PortalService;

public class Program {

    public static void main(String[] args) throws Exception {
        IPortalReadCsvs portalReadCsvs = new PortalReadCsvs();

        List<Student> students = portalReadCsvs.readFileStudents(
                "students.csv");

        List<Classroom> classrooms = portalReadCsvs.readFileClassrooms(
                "classrooms.csv");

        List<Teacher> teachers = portalReadCsvs.readFileTeachers(
                "teachers.csv");

        List<String[]> teachersToClassrooms = portalReadCsvs.readFileTeachersToClassrooms(
                "teachers-to-classrooms.csv");

        List<String[]> classroomsToStudents = portalReadCsvs.readFileClassroomsToStudents(
                "classrooms-to-students.csv");

        IPortalService portalService = new PortalService(classrooms, students,
                teachers);

        for (String[] classroomToStudent : classroomsToStudents) {
            portalService.associateClassroomToStudent(classroomToStudent[0],
                    classroomToStudent[1]);
        }

        for (String[] teacherToClassroom : teachersToClassrooms) {
            portalService.associateTeacherToClassroom(teacherToClassroom[0],
                    teacherToClassroom[1]);
        }

        System.out.println("Students quantity: " + portalService.getAllStudentsByTeacherId("1"));
        System.out.println("Students quantity: " + portalService.getAllStudentsByTeacherId("2"));
        System.out.println("Students quantity: " + portalService.getAllStudentsByTeacherId("3"));
    }
}
