package com.inbox.app;

import com.inbox.app.datastax.DataStaxAstraProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@SpringBootApplication
@RestController
public class SpringGitHubAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGitHubAuthApplication.class, args);
	}

//	@RequestMapping(value = "/user")
//	public String getUser(@AuthenticationPrincipal OAuth2User principle){
//		System.out.println(principle);
//		return principle.getAttribute("name");
//	}

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle);
	}




}
