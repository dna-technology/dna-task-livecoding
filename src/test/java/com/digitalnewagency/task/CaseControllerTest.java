package com.digitalnewagency.task;

import com.digitalnewagency.task.persistence.Case;
import com.digitalnewagency.task.persistence.CaseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CaseControllerTest {

	@Value("${server.port}")
	int port;

	@Value("${server.servlet.context-path}")
	String contextPath;

	@Autowired
	private CaseRepository caseRepository;

	@Test
	void shouldAddCase() throws URISyntaxException, IOException, InterruptedException {
		// given
		// when
		Path path = Paths.get("src/test/resources/case.json");
		URI uri = new URI("http://localhost:" + port + contextPath + "/cases");
		HttpRequest request = HttpRequest.newBuilder()
				.uri(uri)
				.headers("Content-Type", "application/json;charset=UTF-8")
				.POST(HttpRequest.BodyPublishers.ofFile(path))
				.build();
		HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());


		// then
		List<Case> cases = caseRepository.findAll();
		assertThat(cases.size()).isEqualTo(1);
		System.out.println(cases);
	}

}
