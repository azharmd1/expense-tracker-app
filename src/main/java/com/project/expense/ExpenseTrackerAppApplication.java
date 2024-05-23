package com.project.expense;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "Expense Tracker App",
				version = "v1.0",
				description = "Expense Tracker App",
				contact = @Contact(
						name = "Md Azhar",
						email = "azhar123@gmail.com"
		),
		license = @License(
				name = "Apache 2.0",
				url = "http://www.apache.org/licenses/LICENSE-2.0.html"
		)
		),
		externalDocs = @ExternalDocumentation(
				description = "Expense Tracker App Wiki",
				url = "http://localhost:8080/swagger-ui/index.html"
)
)
@SpringBootApplication
public class ExpenseTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerAppApplication.class, args);
	}

}
