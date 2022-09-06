package com.zte.model.dao.Impl;

import com.zte.model.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-09-05 15:17
 */
public class UserDaoImpl implements IUserDao {
//    private String namespace="com.zte.mapper.oracle.UserDaoMapper";
    @Override
    public List<Object> getList() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession();
        List<Object> list = sqlSession.selectList( "UserDaoMapper.getList" );
        sqlSession.close();
//        UserDaoMapper mapper = sqlSession.getMapper(UserDaoMapper.class);
//        List<Object> list = mapper.getList();
        return list;
    }
}
