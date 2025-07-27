package microservice.vocabulary_lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"microservice.vocabulary_lesson", "microservice.common_lib"})
@EntityScan(basePackages = {"microservice.vocabulary_lesson.entity"})
public class VocabularyLessonApplication {

	public static void main(String[] args) {
		SpringApplication.run(VocabularyLessonApplication.class, args);
	}

}
