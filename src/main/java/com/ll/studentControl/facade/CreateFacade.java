package com.ll.studentControl.facade;

import com.ll.studentControl.model.Student;
import com.ll.studentControl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateFacade {

    @Autowired
    private StudentService studentService;

    public Student saveStudent(Student student) {
        return studentService.saveStudent(student);
    }
}
