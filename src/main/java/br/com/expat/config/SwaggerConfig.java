package br.com.expat.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private final ResponseMessage m401 = simpleMessage(401, "Não autorizado");
	private final ResponseMessage m403 = simpleMessage(403, "Acesso negado");
	private final ResponseMessage m404 = simpleMessage(404, "Não encontrado");
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, Arrays.asList(m401, m403, m404))
				.globalResponseMessage(RequestMethod.POST, Arrays.asList(m401, m403)) 
				.globalResponseMessage(RequestMethod.PUT, Arrays.asList(m401, m403, m404))
				.globalResponseMessage(RequestMethod.DELETE, Arrays.asList(m401, m403, m404))
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.expat.resource"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
			"EXPAT API",
			"Projeto de sistema colaborativo de custo de vida nas cidades.\n"
			+ "Por Bruno da Silva Pereira, Eric Pasini Martins, Matheus Henrique Misumoto, e Thiago Augusto Franco de Moraes Alvarenga\n"
			+ "Desenvolvido durante a disciplina de Desenvolvimento de Servidores II - FATEC Baixada Santista",
			"Versão 1.0",
			null, // termos de serviço
			new Contact("Repositório no GitHub",
			"http://github.com/matheusmisumoto/expat",
			null),
			"Uso exclusivamente acadêmico",
			null, // termos de uso
			Collections.emptyList() // Vendor Extensions
		);
	}
	
	private ResponseMessage simpleMessage(int code, String msg) {
		return new ResponseMessageBuilder()
			.code(code).message(msg).build();
	}
}
