package test01;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.mybatis.mapper.SmbsUserMapper;
import com.zte.mybatis.pojo.SmbsUser;
import com.zte.mybatis.pojo.SmbsUserExample;
import com.zte.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-09-06 16:23
 */
public class reverse_test01 {
    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtil.openSession();
        SmbsUserMapper mapper = sqlSession.getMapper(SmbsUserMapper.class);
//        根据id查询
        SmbsUser smbsUser = mapper.selectByPrimaryKey(BigDecimal.valueOf(18));
        System.out.println(smbsUser);
    }
    @Test
    public void test02(){
        SqlSession sqlSession = MybatisUtil.openSession();
        SmbsUserMapper mapper = sqlSession.getMapper(SmbsUserMapper.class);
//        查询所有数据
//        List<SmbsUser> list = mapper.selectByExample(null);
//        list.forEach(System.out::println);

//        根据条件查询
//        SmbsUserExample example = new SmbsUserExample();
//        example.createCriteria().andUsernameEqualTo("谢逊");
//        example.or().andUsercodeEqualTo("XieXun");
//        List<SmbsUser> list = mapper.selectByExample(example);
//        list.forEach(System.out::println);

//        测试普通修改
        SmbsUser smbsUser = new SmbsUser(BigDecimal.valueOf(18), "XieXun", "谢逊");
//        mapper.updateByPrimaryKey(smbsUser);
        mapper.updateByPrimaryKeySelective(smbsUser);
    }
    @Test
    public void testPage(){
        SqlSession sqlSession = MybatisUtil.openSession();
        SmbsUserMapper mapper = sqlSession.getMapper(SmbsUserMapper.class);
        Page<Object> page = PageHelper.startPage(3, 5);
        SmbsUser smbsUser = new SmbsUser(Long.valueOf(1));
        List<SmbsUser> list = mapper.selectByExample(null);
        list.forEach(System.out::println);
        PageInfo<SmbsUser> info = new PageInfo<>(list, 2);
        System.out.println(info);
    }
}
