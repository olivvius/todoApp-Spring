package fr.m2i.spring.Service;

import fr.m2i.spring.model.Todo;
import java.util.List;


public interface ITodoService {

    public List<Todo> findAll();
    
    public Todo findById(long id);
    
    public Todo create(Todo todo);

    public void delete(long id);
    
   // public void update(long id, Todo todo);
    
}
