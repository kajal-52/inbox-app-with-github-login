package com.inbox.app;

import com.inbox.app.datastax.DataStaxAstraProperties;
import com.inbox.app.folders.Folder;
import com.inbox.app.repo.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.nio.file.Path;

@SpringBootApplication
@RestController
@EnableCassandraRepositories
public class SpringGitHubAuthApplication {

	@Autowired
	private FolderRepository folderRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringGitHubAuthApplication.class, args);
	}

//	@RequestMapping(value = "/user")
//	public String getUser(@AuthenticationPrincipal OAuth2User principal){
//		System.out.println(principal);
//		return principal.getAttribute("login");
//	}

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle).build();
	}

	@PostConstruct
	public void init(){
		folderRepository.save(new Folder("kajal-52","Inbox", "blue"));
		folderRepository.save(new Folder("kajal-52","Sent", "green"));
		folderRepository.save(new Folder("kajal-52","Draft", "yellow"));

	}




}
