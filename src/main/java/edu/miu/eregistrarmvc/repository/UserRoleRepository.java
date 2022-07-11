package edu.miu.eregistrarmvc.repository;

import edu.miu.eregistrarmvc.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bijayshrestha on 7/10/22
 * @project eRegistrar-mvc
 */
@Repository
public interface UserRoleRepository extends JpaRepository<Role, Integer> {
}
