package lv.lu.finalwork;

import lv.lu.finalwork.ui.ConsulUi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableAutoConfiguration
@SpringBootApplication
public class ProductAccountingApp {

    public static void main(String[] args) {
       // ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
final ConfigurableApplicationContext context =
        SpringApplication.run(ProductAccountingApp.class);
       context.getBean(ConsulUi.class).run();

    }
}