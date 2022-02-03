package com.dh.BibliotecaDeFilmes.service;

import com.dh.BibliotecaDeFilmes.model.Usuario;
import com.dh.BibliotecaDeFilmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByUserName(username);
        Set<GrantedAuthority> listRoles = new HashSet<GrantedAuthority>();

        listRoles.add(new SimpleGrantedAuthority("USER"));

        UserDetails user = new User(usuario.getUserName(), ("{noop}" + usuario.getPassword()), listRoles);

        return user;
    }
}
