package com.eventoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EventoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventoappApplication.class, args);
		System.out.println("Evento App Iniciado!");
		System.out.println(new StringBuilder("insert into usuario (login, nome_completo, senha) ")
						.append("values ('luiz', 'Luiz Alberto', '")
						.append(new BCryptPasswordEncoder().encode("admin"))
						.append("');"));
		System.out.println("insert into role (nome_role) values ('ROLE_ADMIN'), ('ROLE_USER');");
		System.out.println("insert into usuarios_roles (usuario_id, role_id) values ('luiz', 'ROLE_ADMIN');");
	}
}
