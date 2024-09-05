package com.example.springsecurity;

import com.example.springsecurity.Model.Todo;
import com.example.springsecurity.Model.User;
import com.example.springsecurity.Repository.AuthRepository;
import com.example.springsecurity.Repository.TodoRepository;
import com.example.springsecurity.Service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @InjectMocks
     TodoService todoService;

    @Mock
    TodoRepository todoRepository;

    @Mock
    AuthRepository authRepository;

    User user;

    Todo todo1,todo2,todo3;

    List<Todo> todos;


    @BeforeEach
    void setUp() {
        user = new User(1,"Reenad","1234","ADMIN",null);
        todo1 = new Todo(1,"Todo 1",user);
        todo2 = new Todo(2,"Todo 2",user);
        todo3 = new Todo(3,"Todo 3",user);

        todos = new ArrayList<>();
        todos.add(todo1);
        todos.add(todo2);
        todos.add(todo3);
    }


    @Test
    public void getAllTodosTest() {
        when(this.todoRepository.findAll()).thenReturn(todos);
        List<Todo> allTodos = todoService.getAllTodos();
        //امتدادها مو core
        Assertions.assertEquals(3,allTodos.size());
        verify(todoRepository,times(1)).findAll();
    }

    @Test
    public void getMyTodosTest(){
        when(authRepository.findUserById(user.getId())).thenReturn(user);
        when(todoRepository.findAllByUser(user)).thenReturn(todos);

        List<Todo> todoList=todoService.getMyTodos(user.getId());
        Assertions.assertEquals(todoList,todos);
        verify(authRepository,times(1)).findUserById(user.getId());
        verify(todoRepository,times(1)).findAllByUser(user);
    }

    @Test
    public void addTodoTest() {
        when(authRepository.findUserById(user.getId())).thenReturn(user);

        todoService.addTodo(user.getId(),todo3);
        verify(authRepository,times(1)).findUserById(user.getId());
        verify(todoRepository,times(1)).save(todo3);
    }



    @Test
    public void updateTodoTest(){
        when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);
        when(authRepository.findUserById(user.getId())).thenReturn(user);

        todoService.updateTodo(user.getId(),todo1.getId(),todo2);


        verify(authRepository,times(1)).findUserById(user.getId());
        verify(todoRepository,times(1)).findTodoById(todo1.getId());
        verify(todoRepository,times(1)).save(todo1);
    }

    @Test
    public void deleteTodoTest(){
        when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);
        when(authRepository.findUserById(user.getId())).thenReturn(user);

        todoService.deleteTodo(user.getId(),todo1.getId());
        verify(authRepository,times(1)).findUserById(user.getId());
        verify(todoRepository,times(1)).findTodoById(todo1.getId());
        verify(todoRepository,times(1)).delete(todo1);
    }

}
