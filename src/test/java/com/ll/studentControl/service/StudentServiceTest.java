package com.ll.studentControl.service;

import com.ll.studentControl.model.Student;
import com.ll.studentControl.repository.StudentRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    @Spy
    private StudentService studentService;

    @Test
    void saveStudent_Test() {
        Student student = new Student();
        student.setId(1L);
        student.setName("Lucas");
        student.setAge(24);

        doReturn(student).when(studentRepository).save(any(Student.class));

        Student studentResult = studentService.saveStudent(student);

        Assert.assertNotNull(studentResult);
        Assert.assertEquals("Lucas", studentResult.getName());
        verify(studentRepository).save(any(Student.class));
    }

    @Test
    void getStudent_Test() {
        Student student = new Student();
        student.setId(1L);
        student.setName("Lucas");
        student.setAge(24);

        Optional<Student> optionalStudent = Optional.of(student);

        doReturn(optionalStudent).when(studentRepository).findById(anyLong());

        Student studentResult = studentService.getStudent(student.getId());

        Assert.assertNotNull(studentResult);
        Assert.assertEquals(1L, studentResult.getId().longValue());
        verify(studentRepository).findById(anyLong());
    }

    @Test
    void getStudentAll_Test() {
        List studentList = new ArrayList();
        Student studentOld = new Student();
        studentOld.setId(1L);
        studentOld.setName("Lucas");
        studentOld.setAge(24);
        studentList.add(studentOld);

        Student studentNew = new Student();
        studentNew.setId(2L);
        studentNew.setName("Pedro");
        studentNew.setAge(18);
        studentList.add(studentNew);

        doReturn(studentList).when(studentRepository).findAll();

        List<Student> studentListResult = studentService.getStudentAll();

        Assert.assertNotNull(studentListResult);
        Assert.assertEquals(2, studentListResult.size());
        verify(studentRepository).findAll();
    }
}