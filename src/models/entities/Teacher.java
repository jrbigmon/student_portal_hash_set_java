package models.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Teacher implements Comparable<Teacher> {
  private String id;
  private String name;
  private Set<Classroom> classrooms = new HashSet<>();

  public Teacher(String id, String name, List<Classroom> classrooms) {
    this.id = id;
    this.name = name;
    this.classrooms.addAll(classrooms);
  }

  public Teacher(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Classroom> getClassrooms() {
    return classrooms;
  }

  public void setClassrooms(Set<Classroom> classrooms) {
    this.classrooms = classrooms;
  }

  public Set<Student> getAllStudents() {
    Set<Student> students = new TreeSet<>();

    for (Classroom classroom : getClassrooms()) {
      students.addAll(classroom.getStudents());
    }

    return students;
  }

  public void addClassroom(Classroom classroom) {
    this.classrooms.add(classroom);
  }

  public void addClassrooms(List<Classroom> classrooms) {
    this.classrooms.addAll(classrooms);
  }

  public void removeClassroom(Classroom classroom) {
    this.classrooms.removeIf(c -> c.equals(classroom));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Teacher other = (Teacher) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public int compareTo(Teacher o) {
    return getName().compareTo(o.getName());
  }
}
