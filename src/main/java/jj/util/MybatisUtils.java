package jj.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 工具类创建SqlSession
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        Reader reader = null;
        try {
            //使用Mybatis提供的Resources类加载MyBatis的配置文件
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //构建sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    /**
     * 获取SqlSession对象的静态方法
     * @return
     */
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }


}
