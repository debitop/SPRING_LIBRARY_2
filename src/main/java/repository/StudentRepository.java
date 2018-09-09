package repository;

import model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getStudents();

    void addStudent(Student student);

    void delStudent(int studId);

    void editStudent(Student student);

    Student getStudentById(int id);

}
