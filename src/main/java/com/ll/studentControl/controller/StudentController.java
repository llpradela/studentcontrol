package com.ll.studentControl.controller;

import com.ll.studentControl.facade.ConsultFacade;
import com.ll.studentControl.facade.CreateFacade;
import com.ll.studentControl.facade.DeleteFacade;
import com.ll.studentControl.facade.UpdateFacade;
import com.ll.studentControl.model.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@Api(value = "Aluno", tags = { "Alunos" })
public class StudentController {

    @Autowired
    private ConsultFacade consultFacade;

    @Autowired
    private CreateFacade createFacade;

    @Autowired
    private DeleteFacade deleteFacade;

    @Autowired
    private UpdateFacade updateFacade;

    @ApiOperation(value = "Endpoint responsavel por cadastrar um novo aluno")
    @PostMapping
    public @ResponseBody Student saveStudent(@RequestBody Student student){
        return createFacade.saveStudent(student);
    }

    @ApiOperation(value = "Endpoint responsavel por deletar aluno")
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        deleteFacade.deleteStudent(studentId);
    }

    @ApiOperation(value = "Endpoint responsavel por atualizar aluno")
    @PutMapping()
    public @ResponseBody Student updateStudent(@RequestBody() Student student){
        return updateFacade.updateStudent(student);
    }

    @ApiOperation(value = "Endpoint responsavel por consultar aluno por id")
    @GetMapping("/{studentId}")
    public @ResponseBody Student getStudent(@PathVariable("studentId") Long studentId){
        return consultFacade.getStudent(studentId);
    }

    @ApiOperation(value = "Endpoint responsavel por consultar todos os alunos da base")
    @GetMapping()
    public @ResponseBody List<Student> getStudentAll(){
        return consultFacade.getStudentAll();
    }
}
