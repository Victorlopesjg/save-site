package victor.ufrn.br.savesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan(basePackages = {"victor.ufrn.br.savesite.model"})
@EnableJpaRepositories(basePackages = {"victor.ufrn.br.savesite.repository"})
@EnableSwagger2
public class SavesiteApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SavesiteApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SavesiteApplication.class);
    }
}
