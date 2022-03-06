package com.swabber.controller;

import com.swabber.controller.dto.Todo;
import com.swabber.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public ResponseEntity<?> todos() {
        return new ResponseEntity<>(service.getTodos(), HttpStatus.OK);
    }

    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public ResponseEntity<?> createTodo(@RequestBody Todo todo) {
        return new ResponseEntity<>(service.addTodo(todo.getTitle(), todo.getBy()), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/todos", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateMessage(@RequestBody Todo todo) {
        // todo
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/todos", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMessage(@RequestParam Integer no) {
        return new ResponseEntity<>(service.deleteTodo(no), HttpStatus.OK);
    }
}
