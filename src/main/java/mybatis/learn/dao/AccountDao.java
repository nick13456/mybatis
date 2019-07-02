package mybatis.learn.dao;

import mybatis.learn.domain.Account;

import mybatis.learn.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface AccountDao {

    @Select("select a.id as aid,a.uid,a.money from account a")
    @Results(id="accountMap",value={
            @Result(id=true,property = "aid",column = "aid"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(column="id",property = "user.id"),
            @Result(column = "uid",property = "user",
                    many=@Many(select="mybatis.learn.dao.UserDao.findById",fetchType = FetchType.LAZY))
    })
    List<Account> findAll();

    @Select("select u.*,a.id as aid,a.uid,a.money from user u,account a where u.id=a.uid")
    @Results(id="accountMap1",value={
            @Result(id=true,property = "aid",column = "aid"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(column="id",property = "user.id"),
            @Result(column = "sex",property = "user.sex"),
            @Result(column = "birthday",property = "user.birthday"),
            @Result(column = "address",property = "user.address"),
            @Result(column = "username",property = "user.username")
    })
    List<Account> findByAccount();

    @Select("select a.id as aid,a.uid,a.money from account a where uid=#{uid}")
    @ResultMap(value = "accountMap")
    List<Account> findAccountByUid(Integer uid);


}
