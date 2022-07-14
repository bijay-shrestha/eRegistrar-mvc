package edu.miu.eregistrarmvc.service;

import edu.miu.eregistrarmvc.model.Role;

import java.util.Collection;

/**
 * @author bijayshrestha on 7/10/22
 * @project eRegistrar-mvc
 */
public interface UserRoleService {
    Collection<Role> saveAllUserRoles(Collection<Role> roles);

    Role saveUserRole(Role role);
}
