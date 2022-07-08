package edu.miu.eregistrarmvc.repository;

import edu.miu.eregistrarmvc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bijayshrestha on 7/7/22
 * @project eRegistrar-mvc
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAll();


}
