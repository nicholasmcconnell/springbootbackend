package com.springboot.backend.student;

import com.sun.tools.javac.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @GetMapping
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Jackson",
                        "jackson@dog.com",
                        45,
                        LocalDate.of(2000, Month.JANUARY, 5)

                )
        );
    }
}
