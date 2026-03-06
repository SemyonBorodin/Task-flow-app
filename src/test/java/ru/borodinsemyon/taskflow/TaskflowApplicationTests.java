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
					"spring.datasource.driver-class-name=org.postgresql.Driver",
					"spring.liquibase.enabled=false",
					"spring.jpa.hibernate.ddl-auto=create-drop",
					"spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect"
			).applyTo(context.getEnvironment());
		}
	}

	@Test
	void contextLoads() {
	}
}