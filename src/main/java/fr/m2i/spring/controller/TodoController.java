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
public class TodoController {

    private TodoRepository todoRepository;
    private TodoService todoService;

    @Autowired
    public TodoController(TodoRepository todoRepository, TodoService todoService) {
        this.todoRepository = todoRepository;
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/list-todos")
    public String getTodoList(ModelMap model) {
        return "list-todos";
    }

    @GetMapping("/add-todo")
    public String add(ModelMap model) {
        model.addAttribute("add", new Todoadded());
        return "add-todo";
    }

    @GetMapping("/delete-todo")
    public String delete(ModelMap model) {
        return "list-todos";
    }

    @GetMapping("/modify-todo")
    public String modify(@RequestParam("id") int id, ModelMap model) {
        model.addAttribute("modify", todoService.findById(id));
        return "modify-todo";
    }

    @PostMapping("/add-todo")
    public String addTodo(@ModelAttribute("add") @Valid Todoadded todoadded) {
        Todo todo = new Todo();
        todo.setUsername(todoadded.getUsername());
        todo.setDescription(todoadded.getDescription());
        if (todoadded.getTargetDate() != null) {
            LocalDate datte = LocalDate.parse(todoadded.getTargetDate());
            todo.setTargetDate(datte);
        }

        todoService.create(todo);
        return "redirect:list-todos";
    }

    @PostMapping("/delete-todo")
    public String deleteTodo(@ModelAttribute("delete") Todo todo) {
        todoService.delete(todo.getId());
        return "redirect:list-todos";
    }

    @PostMapping("/modify-todo")
    public String modifyTodo(@ModelAttribute("modify") @Valid Todo todo) {
        todoService.create(todo);
        return "list-todos";
    }

    @ModelAttribute("list")
    public List<Todo> list() {
        return todoService.findAll();
    }

    @ModelAttribute("delete")
    public Todo delete() {
        return new Todo();
    }
}
