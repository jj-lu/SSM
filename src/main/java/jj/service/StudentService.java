package jj.service;

import jj.dao.StudentDao;
import jj.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> findStudentAll() {
        List<Student> students = studentDao.findStudentALL();
        students.forEach(System.out::println);
        return students;
    }
}
