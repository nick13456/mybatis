package mybatis.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.transaction.PlatformTransactionManager;
import org.mybatis.spring.SqlSessionFactoryBean;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("mybatis")
@MapperScan("mybatis")
public class Config {

    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean getSqlSession(DataSource dataSource){
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(dataSource);
        return sfb;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql:///mybatislearn?serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("luohepeng");
        return ds;
    }

    @Bean
    public PlatformTransactionManager getTxManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
