package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	@Setter(onMethod_ = @Autowired)	// DataSource를 주입 받음
	private DataSource dataSource;
	
	@Setter(onMethod_ = @Autowired)	// SqlSessionFactory를 주입 받음
	private SqlSessionFactory sqlSessionFactory;
	
//	@Test
	public void testConnection() {
		try (Connection conn = dataSource.getConnection()){
			log.info(conn);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMyBatis() {
		// session 객체는 내부적으로 사용된다.
		// 예전에는 session 객체를 이용해서 데이터베이스에 접근을 했었지만
		// 새로운 버전에서는 사용하지 않음(내부적으로 동작함)
		try (SqlSession session = sqlSessionFactory.openSession();
				Connection conn = session.getConnection()){
			log.info(session);
			log.info(conn);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
