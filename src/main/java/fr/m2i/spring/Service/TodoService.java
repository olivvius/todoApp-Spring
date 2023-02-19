package fr.m2i.spring.Service;

import fr.m2i.spring.model.Todo;
import fr.m2i.spring.repository.TodoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService implements ITodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(long id) {
        Todo result= todoRepository.findById(id).orElse(null);
             return result;
    }

    @Override
    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void delete(long id) {
        todoRepository.deleteById(id);
    }

}
