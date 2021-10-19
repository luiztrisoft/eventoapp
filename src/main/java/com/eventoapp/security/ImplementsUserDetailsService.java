package com.eventoapp.security;

import com.eventoapp.repository.UsuarioRepository;
import javax.transaction.Transactional;

import com.eventoapp.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(login);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuário não encontrado nesta aplicação!");
        }
        return new User(usuario.getUsername(), usuario.getPassword(),true, true, true, true, usuario.getAuthorities());
    }

}
