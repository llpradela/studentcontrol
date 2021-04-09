package com.ll.studentControl.service;

import com.ll.studentControl.handler.CustomGenericException;
import com.ll.studentControl.model.Student;
import com.ll.studentControl.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        try {
            return studentRepository.save(student);
        } catch (Exception exception) {
            throw new CustomGenericException("ERRO_AO_INSERIR_ALUNO_NA_BASE", exception);
        }
    }

    public void deleteStudent(Long studentId) {
        try {
            studentRepository.deleteById(studentId);
        } catch (Exception exception) {
            throw new CustomGenericException("ERRO_AO_DELETAR_ALUNO_NA_BASE", exception);
        }
    }

    public Student getStudent(Long studentId) {
        try {
            return studentRepository.findById(studentId)
                    .orElseThrow(() -> new IllegalArgumentException("NAO_FOI_ENCONTRADO_DADOS_CADASTRADADOS_COM_AS_INFORMACAES_FORNECIDAS"));
        } catch (Exception exception) {
            throw new CustomGenericException("ERRO_AO_BUSCAR_ALUNO_NA_BASE", exception);
        }
    }

    public List<Student> getStudentAll() {
        try {
            return studentRepository.findAll();
        } catch (Exception exception) {
            throw new CustomGenericException("ERRO_AO_BUSCAR_LISTA_DE_ALUNOS_NA_BASE", exception);
        }
    }

    public Student updateStudent(Student student) {
        Student studentFound = studentRepository.findById(student.getId())
                .orElseThrow(() -> new IllegalArgumentException("NAO_FOI_ENCONTRADO_DADOS_CADASTRADADOS_COM_AS_INFORMACAES_FORNECIDAS"));

        studentFound.setAge(student.getAge());
        studentFound.setName(student.getName());
        return studentRepository.saveAndFlush(studentFound);
    }
}
