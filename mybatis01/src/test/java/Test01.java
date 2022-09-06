import com.zte.model.mapper.oracle.UserDaoMapper;
import com.zte.model.model.SmbmsUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-09-05 16:01
 */
public class Test01 {
    @Test
    public void test01() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession();
//        List<Object> objects = sqlSession.selectList(namespace + ".getList", SmbmsUser.class);
//        sqlSession.close();
        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
        List<SmbmsUser> list = mapper.getListByUsercode("admin");
        for (Object o : list) {
            System.out.println(o);
        }

//        //读取MyBatis的核心配置文件
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
////创建SqlSessionFactoryBuilder对象
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
////通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
////创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
////SqlSession sqlSession = sqlSessionFactory.openSession();
////创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
////通过代理模式创建UserMapper接口的代理实现类对象
//        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
////调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配 映射文件中的SQL标签，并执行标签中的SQL语句
//        List<Object> list = mapper.getList();
////sqlSession.commit();
//        for (Object o : list) {
//            System.out.println(o);
//        }
    }
}
