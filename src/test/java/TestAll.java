import mybatis.learn.dao.AccountDao;
import mybatis.learn.dao.RoleDao;
import mybatis.learn.dao.UserDao;
import mybatis.learn.domain.Account;

import mybatis.learn.domain.RoleT;
import mybatis.learn.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestAll {
    private InputStream stream;
    private SqlSession session;
    private UserDao userdao;
    private AccountDao accountDao;
    private RoleDao roleDao;


    @Before
    public void init() throws IOException {
        stream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(stream);
        session = factory.openSession();
        userdao = session.getMapper(UserDao.class);
        accountDao = session.getMapper(AccountDao.class);
        roleDao = session.getMapper(RoleDao.class);
    }
    @After
    public void end() throws IOException {
        session.commit();
        stream.close();
        session.close();
    }

    @Test
    public void testFindAccountById(){
        List<Account> accountList= accountDao.findAccountByUid(2);
        //System.out.println(account);

    }

    @Test
    public void testFindAll(){
        List<User> userList = userdao.findAll();
        for(User user:userList){
            System.out.println(user);
            System.out.println(user.getAccountList());
        }
        List<Account> accountList = accountDao.findAll();
        for(Account account:accountList){
            System.out.println(account);
        }
    }
    @Test
    public void testFindAccountDetail(){
        List<Account> accountList = accountDao.findByAccount();
        for(Account account:accountList){
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
    @Test
    public void testFindById(){
        User user = userdao.findById(50);
        System.out.println(user);
    }

    @Test
    public void testRoleFindAll(){
        List<RoleT> roleTList = roleDao.findAllDetail();
        for(RoleT role: roleTList){
            System.out.println("------------每个角色信息------------");
            System.out.println(role);
            System.out.println(role.getUserList());
        }

    }



    @Test
    public void testFindRoleById(){
       // RoleT rolet = roleDao.findRoleById(3);
        //System.out.println(rolet);
    }

    @Test
    public void testFinAllAccount(){
        List<Account> accountList = accountDao.findAll();
        for(Account account:accountList){
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void testFindAllUser(){
        List<User> userList = userdao.findAll();
        for(User user:userList){
            System.out.println(user);
            System.out.println(user.getAccountList());
        }
    }

    @Test
    public void testFindAccountUser(){
        List<User> userList = userdao.findUserAccount();
        for(User user:userList){
            System.out.println("--------------------");
            System.out.println(user);
            System.out.println(user.getAccountList());


        }
    }

    @Test
    public void testFindAllRole(){
        List<User> userList = userdao.findUserRole();
        for(User user:userList){
            System.out.println("-------------"+user+"-------------");
            System.out.println("-------------"+user.getRoleTList()+"-------------");
        }
    }

    @Test
    public void testFindRoleUsers(){
        List<RoleT> roleTList = roleDao.findRoleUser();
        for(RoleT role:roleTList){
            System.out.println("-------------"+role+"-------------");
            System.out.println("-------------"+role.getUserList()+"-------------");
        }
    }
}
