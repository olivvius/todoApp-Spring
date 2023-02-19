package fr.m2i.spring;

import fr.m2i.spring.Service.TodoService;
import fr.m2i.spring.model.Todo;
import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// Equivalent de
// @SpringBootConfiguration
// @EnableAutoConfiguration
//@ComponentScan(basePackages = {"fr.m2i.spring.lesson", "fr.m2i.data"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        TodoService todoService=ctx.getBean(TodoService.class);
       Todo tache=new Todo("ollie","get a brainwashing",LocalDate.parse("2022-09-28"));
       todoService.create(tache);
       //employeeService.findAll();
        
    }
}
