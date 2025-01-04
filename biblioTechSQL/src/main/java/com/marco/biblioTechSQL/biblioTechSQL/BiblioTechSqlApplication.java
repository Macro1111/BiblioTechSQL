package com.marco.biblioTechSQL.biblioTechSQL;

import com.marco.biblioTechSQL.biblioTechSQL.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class BiblioTechSqlApplication implements CommandLineRunner {

	@Autowired
	private Principal principal;

	public static void main(String[] args) {
		SpringApplication.run(BiblioTechSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal.menu();
	}
}
