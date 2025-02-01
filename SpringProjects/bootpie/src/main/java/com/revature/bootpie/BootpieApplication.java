package com.revature.bootpie;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.bootpie.models.Pie;
import com.revature.bootpie.services.PieService;

@SpringBootApplication
@RestController
public class BootpieApplication {
	
	@Value("${spring.application.name}")
	private String appName;


	public static void main(String[] args) {SpringApplication.run(BootpieApplication.class, args);}

	/**
	 * same function as the piePicker bean lambda
	 * @param pieService
	 * @return pie details for the PieService
	 */
	@GetMapping
	public String piePickerHttp(PieService pieService) {
		Pie randomPie = pieService.getRandomPie();

		return String.format("The pie selected for you is %s with calories equal to %d with %d slices left", randomPie.getPieName(), 
		randomPie.getCalories(), randomPie.getSlicesAvailable());
	}

	@Bean
	public CommandLineRunner inspectorBean(ApplicationContext applicationContext) {
		return args -> {
			System.out.printf("Inspecting the beans provided by Spring Boot in %s", appName).println();
			
			String[] beans = applicationContext.getBeanDefinitionNames();

			Arrays.sort(beans);
			for(String bean: beans) {
				if(bean.contains("pie") || bean.contains("inspector"))
				System.out.println(bean);
			}
		};
	}

	// @Bean
	// public CommandLineRunner piePickerBean(PieService pieService) {
	// 	return args -> {
	// 		Pie randomPie = pieService.getRandomPie();

	// 		System.out.printf("The pie selected for you is %s with calories equal to %d with %d slices left", randomPie.getPieName(), 
	// 		randomPie.getCalories(), randomPie.getSlicesAvailable()).println();
	// 	};
	// }
}
