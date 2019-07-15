package anno;

import mybatis.config.Config;
import mybatis.learn.dao.AccountDao;
import mybatis.learn.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class Tests {

    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;


    @Test
    public void testFindAll(){
       List<Account> accounts = accountDao.findAll();
        System.out.println(accounts);
    }

    @Test
    public void testfindByAccount(){
        List<Account> accountList = accountDao.findByAccount();
        for(Account account:accountList){
            System.out.println(account);
        }
    }
}
