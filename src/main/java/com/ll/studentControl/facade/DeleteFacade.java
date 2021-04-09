package com.ll.studentControl.facade;

import com.ll.studentControl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteFacade {

    @Autowired
    private StudentService studentService;

    public void deleteStudent(Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
