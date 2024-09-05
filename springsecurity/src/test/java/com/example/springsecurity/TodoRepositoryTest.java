package com.example.springsecurity;

import com.example.springsecurity.Model.Todo;
import com.example.springsecurity.Model.User;
import com.example.springsecurity.Repository.TodoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TodoRepositoryTest {

    @Autowired
    TodoRepository todoRepository;

    User user;

    Todo todo1,todo2,todo3;

    List<Todo> todos;

    Todo todo;



    @BeforeEach
    void setUp() {
        user = new User(1,"reenad","1234","ADMIN",null);
        todo1=new Todo(null,"todo1",user);
        todo2=new Todo(null,"todo2",user);
        todo3=new Todo(null,"todo3",user);
    }

    @Test
    public void findAllByUser(){
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);
        todos = todoRepository.findAllByUser(user);
        Assertions.assertThat(todos.get(0).getUser().getId()).isEqualTo(user.getId());
    }

    @Test
    public void findTodoById(){
        todoRepository.save(todo1);
        todo=todoRepository.findTodoById(todo1.getId());
        Assertions.assertThat(todo).isEqualTo(todo1);
    }


}
