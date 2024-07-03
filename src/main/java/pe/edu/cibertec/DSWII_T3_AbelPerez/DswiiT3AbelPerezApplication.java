package pe.edu.cibertec.DSWII_T3_AbelPerez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DswiiT3AbelPerezApplication {

	public static void main(String[] args) {
		SpringApplication.run(DswiiT3AbelPerezApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer configGlobalCors(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("api/v1/**")
						.allowedOrigins("https://www.cibertec.edu.pe")
						.allowedMethods("GET", "POST", "PUT")
						.allowedHeaders("*");
			}
		};
	}


}
