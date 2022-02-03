package com.springboot.backend.student;

//import com.sun.tools.javac.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {

            List<Student> studentList = new ArrayList<>();

          Student jackson = new Student(
                    "Jackon",
                    "jackson@dog.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student mariana = new Student(
                    "Mariana",
                    "mari@flores.com",
                    LocalDate.of(2006, Month.JANUARY, 5)
            );

            studentList.add(jackson);
            studentList.add(mariana);

            repository.saveAll(
                    studentList
            );
        };
    }
}
