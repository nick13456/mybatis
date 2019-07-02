package mybatis.learn.dao;

import mybatis.learn.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;


import java.util.List;

public interface UserDao {

    @Select("select * from user")
    @Results(id = "userMap1", value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "address",property = "address"),
            @Result(column = "id",property = "accountList",javaType = List.class,
                    many=@Many(select = "mybatis.learn.dao.AccountDao.findAccountByUid")),
            @Result(column = "uid",property = "roleTList",javaType = List.class,
                    many=@Many(select="mybatis.learn.dao.RoleDao.findRolesById"))
    })
    List<User> findAll();

    @Select("select * from user")
    @ResultMap("userMap1")
    List<User> findUserAccount();


    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    /**
     * 多对多
     */
    @Select("select * from user")
    @Results(id = "userMap2",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "address",property = "address"),
            @Result(column = "id",property = "accountList",javaType = List.class,
                    many=@Many(select = "mybatis.learn.dao.AccountDao.findAccountByUid")),
            @Result(column = "id",property = "roleTList",javaType = List.class,
                    many=@Many(select="mybatis.learn.dao.RoleDao.findRolesById",fetchType = FetchType.LAZY))
    })
    List<User> findUserRole();

    @Select("select * from user where id in(select uid from user_role where rid=#{rid})")
    @ResultMap("userMap2")
    List<User> findUsersById(Integer rid);
}
