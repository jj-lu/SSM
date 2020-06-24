package jj.test;

import jj.dao.StudentDao;
import jj.po.Student;
import jj.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestUtils {

    /**
     * 测试缓存
     */
    @Test
    public void testUtils(){
        //获取一个SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();

        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        //执行两次相同的SQL操作
        List<Student> students = studentDao.findStudentALL();
        List<Student> students2 = studentDao.findStudentALL();

        //遍历结果对象集
        System.out.println("students");
        students.forEach(System.out::println);
        System.out.println("students2");
        students2.forEach(System.out::println);

        //关闭SqlSession对象
        sqlSession.close();
    }


    /**
     * 测试不同对象的缓存
     */
    @Test
    public void test2(){
        //获取一个SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        //获取第二个sqlsession对象
        SqlSession sqlSession2 = MybatisUtils.getSession();
        StudentDao studentDao2 = sqlSession2.getMapper(StudentDao.class);

        System.out.println(sqlSession == sqlSession2);

        //不同的sqlsession对象执行两次相同的SQL操作
        List<Student> students = studentDao.findStudentALL();
        List<Student> students2 = studentDao2.findStudentALL();

        //遍历结果对象集
        System.out.println("students");
        students.forEach(System.out::println);
        System.out.println("students2");
        students2.forEach(System.out::println);

        //关闭SqlSession对象
        sqlSession.close();
        sqlSession2.close();
    }

    /**
     * 测试进行增删改后的缓存
     */
    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        //第一次查询
        List<Student> students = studentDao.findStudentALL();

        Student student = students.get(0);
        student.setAge(22);
        int i = studentDao.updateStudentById(student);

        //更新后查询
        students = studentDao.findStudentALL();
        students.forEach(System.out::println);

        sqlSession.close();
    }

    /**
     * 测试MyBatis自带二级缓存
     */
    @Test
    public void test4(){
        //创建两个SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        SqlSession sqlSession2 = MybatisUtils.getSession();
        StudentDao studentDao2 = sqlSession2.getMapper(StudentDao.class);

        //进行查询
        List<Student> students = studentDao.findStudentALL();
        sqlSession.close();

        List<Student> students2 = studentDao2.findStudentALL();
        sqlSession2.close();

        students.forEach(System.out::println);
        students2.forEach(System.out::println);


    }
}
