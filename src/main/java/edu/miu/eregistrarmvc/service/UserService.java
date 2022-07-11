package edu.miu.eregistrarmvc.service;

import edu.miu.eregistrarmvc.model.User;

import java.util.List;

/**
 * @author bijayshrestha on 7/7/22
 * @project eRegistrar-mvc
 */
public interface UserService {

    User addNewStudent(User user);

    List<User> addNewStudents(List<User> users);

    List<User> getAllStudents();

    User getStudentById(Long studentId) throws IllegalArgumentException;

    List<User> searchStudent(String firstName) throws IllegalArgumentException;

    User updateStudent(User updatedUser);

    void deleteStudentById(Long studentId);

}
