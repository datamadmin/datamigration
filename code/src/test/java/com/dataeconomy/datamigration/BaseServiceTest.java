package com.dataeconomy.datamigration;

import java.util.Properties;

import javax.mail.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dataeconomy.framework.util.ThreadLocalUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/config/applicationContext.xml" })
public abstract class BaseServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	@BeforeClass
	public static void setUp() {
		ThreadLocalUtil.setThreadVariable(ThreadLocalUtil.CURRENT_USER, "SUNITHAP");
		try {
			System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
			InitialContext ic = new InitialContext();
			ic.createSubcontext("java:");
			ic.createSubcontext("java:comp");
			ic.createSubcontext("java:comp/env");
			ic.createSubcontext("java:comp/env/jdbc");
			ic.createSubcontext("java:comp/env/mail");
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			dataSource.setUrl("jdbc:sqlserver://192.168.1.97:1433;databaseName=dipdev;");
			dataSource.setUsername("sa");
			dataSource.setPassword("admin@123");
			ic.rebind("java:comp/env/jdbc/gable", dataSource);
			setupMailSession(ic);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void setupMailSession(InitialContext ic) {
		try {
			Properties props = new Properties();
			props.setProperty("auth", "Container");
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.host", "smtp.outlook.com");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.user", "suneetha.reddy@guvvala.com");
			props.setProperty("password", "guvala@123");
			Session session = Session.getInstance(props);
			ic.rebind("java:comp/env/mail/session", session);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
