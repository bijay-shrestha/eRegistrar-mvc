package edu.miu.eregistrarmvc.service.impl;

import edu.miu.eregistrarmvc.model.User;
import edu.miu.eregistrarmvc.repository.UserRepository;
import edu.miu.eregistrarmvc.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author bijayshrestha on 7/7/22
 * @project eRegistrar-mvc
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User addNewStudent(User user) {
        var newStudent = userRepository.save(user);
        return newStudent;
    }

    @Override
    public List<User> addNewStudents(List<User> users) {
        users.forEach(user -> user.setPassword(passwordEncoder.encode(user.getPassword())));
        var newStudents = userRepository.saveAll(users);
        return newStudents;
    }

    @Override
    public List<User> getAllStudents() {
        var students = userRepository.findAll(Sort.by("firstName"));
        return students;
    }

    @Override
    public User getStudentById(Long studentId){
        return userRepository.findById(studentId)
                .orElseThrow(()-> new IllegalArgumentException("User with ID " + studentId +  " Not Found"));
    }

    @Override
    public List<User> searchStudent(String searchParam){
        return userRepository.findBySearchParam(searchParam)
                .orElseThrow(()-> new IllegalArgumentException("User with Firstname " + searchParam +  " Not Found"));
    }

    @Override
    public User updateStudent(User updatedUser) {
        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        userRepository.deleteById(studentId);
    }
}
