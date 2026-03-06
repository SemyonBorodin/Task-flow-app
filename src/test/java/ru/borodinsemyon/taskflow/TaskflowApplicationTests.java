package ru.borodinsemyon.taskflow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
@ContextConfiguration(initializers = {TaskflowApplicationTests.Initializer.class})
class TaskflowApplicationTests {

	@Container
	static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
			.withDatabaseName("testdb")
			.withUsername("test")
			.withPassword("test");

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		public void initialize(ConfigurableApplicationContext context) {
			TestPropertyValues.of(
					"spring.datasource.url=" + postgres.getJdbcUrl(),
					"spring.datasource.username=" + postgres.getUsername(),
					"spring.datasource.password=" + postgres.getPassword(),
					// let Liquibase apply schema + test data in the container
					"spring.liquibase.enabled=true",
					"spring.liquibase.change-log=classpath:db/changelog/db.changelog-master.xml",
					// disable Hibernate auto-ddl to avoid conflicts with Liquibase
					"spring.jpa.hibernate.ddl-auto=none"
			).applyTo(context.getEnvironment());
		}
	}

	@Test
	void contextLoads() {
	}
}
