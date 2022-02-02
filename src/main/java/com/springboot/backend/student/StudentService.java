package com.springboot.backend.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email taken.");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentId){
        boolean existsById = studentRepository.existsById(studentId);

        if(!existsById){
            throw new IllegalStateException("Student with id No. " + studentId + " does not exist.");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email){

       Student student = studentRepository.findById(studentId)
               .orElseThrow(()->new IllegalStateException("Student with id No. " + studentId + " does not exist."));

        if(name != null &&
                name.length() >0 &&
                !student.getName().equals(name)){
            student.setName(name);
        }

        if(email != null &&
                name.length() >0 &&
                !student.getEmail().equals(email)){
            Optional studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email taken.");
            }
            student.setEmail(email);
        }




    }
}
