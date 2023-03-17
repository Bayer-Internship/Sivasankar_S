package com.example.shankz.students;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.shankz.respository.StudentRespository;

@Configuration
public class StudentsConfig {
	@Bean
	CommandLineRunner commandlinerunner(StudentRespository studentrepo) {
		return args -> {
			Students siva = new Students("siva", "siva@gmail.com", LocalDate.of(2000, Month.MAY, 9));
			Students shankz = new Students("shankz", "shan@gmail.com", LocalDate.of(2000, Month.JUNE, 6));
			studentrepo.saveAll(List.of(siva, shankz));

		};
	}
}
