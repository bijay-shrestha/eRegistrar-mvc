package edu.miu.eregistrarmvc.service;

import edu.miu.eregistrarmvc.model.Student;

import java.util.List;

/**
 * @author bijayshrestha on 7/7/22
 * @project eRegistrar-mvc
 */
public interface StudentService {

    Student addNewStudent(Student student);

    List<Student> addNewStudents(List<Student> students);

    List<Student> getAllStudents();

    Student getStudentById(Long studentId) throws IllegalArgumentException;

    Student updateStudent(Student updatedStudent);

    void deleteStudentById(Long studentId);

}
