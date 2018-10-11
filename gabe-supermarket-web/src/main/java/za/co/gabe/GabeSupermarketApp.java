package za.co.gabe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"za.co.gabe"})
public class GabeSupermarketApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GabeSupermarketApp.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GabeSupermarketApp.class, args);
    }
}
