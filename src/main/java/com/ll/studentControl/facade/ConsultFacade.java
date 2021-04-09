package com.ll.studentControl.facade;

import com.ll.studentControl.model.Student;
import com.ll.studentControl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultFacade {

    @Autowired
    private StudentService studentService;

    public Student getStudent(Long studentId) {
        return studentService.getStudent(studentId);
    }

    public List<Student> getStudentAll() {
        return studentService.getStudentAll();
    }
}
