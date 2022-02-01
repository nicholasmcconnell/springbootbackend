package com.springboot.backend.student;

import com.sun.tools.javac.util.List;

import java.time.LocalDate;
import java.time.Month;

public class StudentService {

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
