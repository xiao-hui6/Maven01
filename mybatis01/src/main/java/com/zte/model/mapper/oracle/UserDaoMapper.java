package com.zte.model.mapper.oracle;

import com.zte.model.model.SmbmsUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-09-05 15:11
 */
public interface UserDaoMapper {
   List<Object> getList();
   @Select("select * from smbms_user where usercode=#{userCode}")
   List<SmbmsUser> getListByUsercode(String userCode);
}
