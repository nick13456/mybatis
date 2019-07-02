package mybatis.learn.dao;

import mybatis.learn.domain.RoleT;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;


import java.util.List;

public interface RoleDao {


//    @Select("select r.id as rid, r.role_name,r.role_desc,u.id from rolet r left outer join user_role ur on r.id=ur.rid " +
//            "left outer join user u on u.id=ur.uid")
//    @Results(id="roleMap",value={
//            @Result(id=true,column = "rid",property = "roleId"),
//            @Result(column = "role_name",property = "roleName"),
//            @Result(column = "role_desc",property = "roleDesc"),
//            @Result(column = "id" ,property = "userList",javaType = List.class,
//                    many=@Many(select = "mybatis.learn.dao.UserDao.findById"
//                    ))
//    })

    /**
     * 下面使用xml配置
     * @return
     */
    List<RoleT> findAllDetail();



    @Select("select * from rolet")
    @ResultMap(value="roleMap1")
    List<RoleT> findAll();

    @Select("select * from rolet where id in(select rid from user_role where uid=#{uid})")
    @Results(id="roleMap1",value={
            @Result(id=true,column = "id",property = "roleId"),
            @Result(column = "role_name",property = "roleName"),
            @Result(column = "role_desc",property = "roleDesc")
            })
    List<RoleT> findRolesById(Integer uid);

    @Select("select * from rolet")
    @Results(id="roleMap2",value={
            @Result(id=true,column = "id",property = "roleId"),
            @Result(column = "role_name",property = "roleName"),
            @Result(column = "role_desc",property = "roleDesc"),
            @Result(column = "id",property = "userList",
                    many=@Many(select = "mybatis.learn.dao.UserDao.findUsersById",fetchType = FetchType.LAZY))
    })
    List<RoleT> findRoleUser();


























}
