package edu.miu.eregistrarmvc.service.impl;

import edu.miu.eregistrarmvc.model.Role;
import edu.miu.eregistrarmvc.repository.UserRoleRepository;
import edu.miu.eregistrarmvc.service.UserRoleService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author bijayshrestha on 7/10/22
 * @project eRegistrar-mvc
 */
@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService{

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public Collection<Role> saveAllUserRoles(Collection<Role> roles){
        return userRoleRepository.saveAll(roles);
    }

    @Override
    public Role saveUserRole(Role role) {
        return userRoleRepository.save(role);
    }



}
