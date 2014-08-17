/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donquijote.userdetails;

import com.donquijote.dao.EmpleadoImplDAO;
import com.donquijote.persistence.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author José Luis
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    private EmpleadoImplDAO empleadoDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user;
        try {
            user = empleadoDAO.getUsuarioByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("user name not found");
            }

        } catch (Exception e) {
            throw new UsernameNotFoundException("database error ");
        }
        return buildUserFromUserEntity(user);
    }

    private User buildUserFromUserEntity(Usuario userEntity) {
        // convert model user to spring security user
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority("ROLE_VENDEDOR");
        SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");

        if (userEntity.getRol().getNombrerol().equals("administrador")) {
            authorities.add(userAuthority);
            authorities.add(adminAuthority);
        } else if (userEntity.getRol().getNombrerol().equals("vendedor")) {
            authorities.add(userAuthority);
        }
        
        User springUser = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

        return springUser;
    }

    public EmpleadoImplDAO getEmpleadoDAO() {
        return empleadoDAO;
    }

    public void setEmpleadoDAO(EmpleadoImplDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

}
