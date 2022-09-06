package com.zte.mapper.oracle;

import java.util.HashMap;
import java.util.List;

import com.zte.model.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author shkstart
 * @create 2022-09-06 9:20
 */
public interface UserMapper {
    //获取所有user
    @Select("select * from smbms_user")
    List<SmbmsUser> getUserList();

    //根据code获取user
    SmbmsUser getUserOne(@Param("code") String code);

    //    插入一个user
    void insertUOne(SmbmsUser user);

    //    更新一个user
    void updateOne(SmbmsUser user);

    //根据id删除user
    void deleteByID(@Param("id") String id);

    //模糊查询
    List<SmbmsUser> getListByLike(SmbmsUser user);

    //根据条件查询
    List<SmbmsUser> getListByCondition(HashMap<String, Object> map);

    //查询<id的user
    List<SmbmsUser> getListSmallID(@Param("id") String id);
    //根据id批量删除
    void deleteBathByID(String[] ids);

}
