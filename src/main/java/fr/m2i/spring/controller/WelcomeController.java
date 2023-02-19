package fr.m2i.spring.controller;

import fr.m2i.spring.Service.TodoService;
import fr.m2i.spring.Todoadded;
import java.util.List;
import fr.m2i.spring.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.spring.repository.TodoRepository;
import java.time.LocalDate;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    private TodoRepository todoRepository;
    private TodoService todoService;

    @Autowired
    public WelcomeController(TodoRepository todoRepository, TodoService todoService) {
        this.todoRepository = todoRepository;
        this.todoService = todoService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }


}
