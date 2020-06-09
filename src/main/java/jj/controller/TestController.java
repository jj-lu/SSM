package jj.controller;


import jj.po.Student;
import jj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        Student student = new Student();
        return "hello ssm2";
    }

    @RequestMapping("/student")
    @ResponseBody
    public List<Student> findStudentAll(){
        return studentService.findStudentAll();
    }
}
