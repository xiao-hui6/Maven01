package com.zte.model.dao;

import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-09-05 15:16
 */
public interface IUserDao {
    public List<Object> getList() throws IOException;
}
