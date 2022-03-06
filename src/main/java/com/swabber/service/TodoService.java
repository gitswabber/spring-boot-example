package com.swabber.service;

import com.google.common.collect.Lists;
import com.swabber.controller.dto.Todo;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

@Service
public class TodoService {

    private List<Todo> todos = Lists.newArrayList();
    private static int no = 1;

    @PostConstruct
    public void setUp() {
        todos.add(new Todo(no++, "Read the book", "me"));
        todos.add(new Todo(no++, "Go to market", "me"));
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public List<Todo> addTodo(String title, String by) {
        todos.add(new Todo(no++, title, by));
        return todos;
    }

    public List<Todo> deleteTodo(Integer no) {
        var todo = todos.stream().filter(v -> v.getNo().equals(no)).findAny().orElse(null);
        if (Objects.nonNull(todo)) {
            todos.remove(todo);
        }
        return todos;
    }
}
