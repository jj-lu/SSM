package jj.dao;

import jj.po.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findStudentALL();

    int updateStudentById(Student student);

    Student findStudentByName(String name);
}
