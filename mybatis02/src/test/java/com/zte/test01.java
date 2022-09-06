package com.zte;

import com.zte.mapper.oracle.UserMapper;
import com.zte.model.SmbmsUser;
import com.zte.utils.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * @author shkstart
 * @create 2022-09-06 9:24
 */
public class test01 {
    @Test
    public void testList() throws IOException {

        SqlSession sqlSession = MybatisUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<SmbmsUser> userList = mapper.getUserList();
//        List<SmbmsUser> userList = sqlSession.selectList("UserMapper.getUserList");
        for (SmbmsUser smbmsUser : userList) {
            System.out.println(smbmsUser);
        }
        sqlSession.close();
    }

    @Test
    public void testByName() {
        SqlSession sqlSession = MybatisUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SmbmsUser admin = mapper.getUserOne("admin");
        System.out.println(admin);
        sqlSession.close();

    }

    @Test
    public void testInsertOne() {
        SqlSession sqlSession = MybatisUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SmbmsUser user = new SmbmsUser(null, "XieXun", "谢逊", "123456", "1");
        mapper.insertUOne(user);
//        System.out.println(i);
        sqlSession.close();

    }

    @Test
    public void testUpdateOne() {
        SqlSession sqlSession = MybatisUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SmbmsUser user = new SmbmsUser("16", null, "张无忌", null, null);
        mapper.updateOne(user);
        sqlSession.close();
    }

    @Test
    public void testDeleteByID() {
        SqlSession sqlSession = MybatisUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteByID("17");
        sqlSession.close();
    }
    @Test
    public void testByLike(){
        SqlSession sqlSession = MybatisUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        SmbmsUser user = new SmbmsUser("16", null, "张无忌", null, null);
        List<SmbmsUser> listByLike = mapper.getListByLike(user);
        for (SmbmsUser smbmsUser : listByLike) {
            System.out.println(smbmsUser);
        }
    }
    @Test
    public void testByCondition(){
        SqlSession sqlSession = MybatisUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
//        map.put("usercode","admin");
//        map.put("username","张无忌");
        map.put("gender","1");
        List<SmbmsUser> users = mapper.getListByCondition(map);
        for (SmbmsUser user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testSmallID() {
        SqlSession sqlSession = MybatisUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<SmbmsUser> users = mapper.getListSmallID("10");
        for (SmbmsUser user : users) {
            System.out.println(user);
        }
    }
        @Test
        public void testBatchByID(){
            SqlSession sqlSession = MybatisUtil.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
mapper.deleteBathByID(new String[]{"16","14"});

        }
    }


