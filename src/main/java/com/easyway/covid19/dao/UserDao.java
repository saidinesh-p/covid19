package com.easyway.covid19.dao;

import com.easyway.covid19.model.User;
import org.apache.ibatis.annotations.Param;



public interface UserDao {

     User getUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password) throws Exception;

     void addUserInfo(User user)throws Exception;

    User getUserByUserName(@Param("userName") String userName)throws Exception;

    User getUserByUserId(@Param("id") int id)throws Exception;


}
