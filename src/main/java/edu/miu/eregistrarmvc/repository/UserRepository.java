package edu.miu.eregistrarmvc.repository;

import edu.miu.eregistrarmvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author bijayshrestha on 7/7/22
 * @project eRegistrar-mvc
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select s from User s where s.firstName like %:searchParam% or " +
            "s.lastName like %:searchParam% or " +
            "s.middleName like %:searchParam% or " +
            "s.userUniqueID like %:searchParam% or " +
            "s.isInternational like %:searchParam% ")
    Optional<List<User>> findBySearchParam(String searchParam);

    @Query(value = "select u from User u where u.username=:username or u.email=:username")
    Optional<User> findByUsername(String username);
}
