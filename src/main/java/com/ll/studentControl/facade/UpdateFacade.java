package com.ll.studentControl.facade;

import com.ll.studentControl.model.Student;
import com.ll.studentControl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateFacade {

    @Autowired
    private StudentService studentService;

    public Student updateStudent(Student student) {
        return studentService.updateStudent(student);
    }
}
