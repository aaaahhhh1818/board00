package org.zerock.board00.common.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.zerock.board00.board.config.BoardRootConfig;

import javax.sql.DataSource;
import java.util.ArrayList;

@Configuration
@Import(BoardRootConfig.class) //로딩될 때 한번에 로딩해옴
public class RootConfig {

    //MyBatis 연결을 쉽게 해주는 도구 만들기
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception { //사실 인터페이스

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean(); //설정파일 없이 만들고 싶어서 Bean 사용 (spring에서 지원해줌)
        sqlSessionFactoryBean.setDataSource(dataSource());

        return sqlSessionFactoryBean.getObject();

    }

    @Bean
    public DataSource dataSource() {

        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/bit08db");
        config.setUsername("myuser");
        config.setPassword("myuser");

        HikariDataSource dataSource = new HikariDataSource(config);

        return dataSource; //기본적으로 싱글톤. 한번만 로딩함! enum으로 뺐던거를 bean으로 뺀 것

    }

    @Bean(name = "names") //객체 생성 (bean 이름 메서드랑 통일)
    public ArrayList<String> names() { //메서드명 동사가아니라 명사

        ArrayList<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        return list;
    }

}
