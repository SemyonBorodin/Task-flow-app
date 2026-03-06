//package ru.borodinsemyon.taskflow.repository;
//
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Repository;
//import ru.borodinsemyon.taskflow.model.Task;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Primary
//@Repository
//public class InMemTaskRepository implements TaskRepository {
//    private final List<Task> tasks = new ArrayList<>() {{
//        this.add(new Task());
//        this.add( new Task("Task with some details"));
//    }}; // todo thread safety
//
//    @Override
//    public List<Task> findAll() {
//        return new ArrayList<>(tasks); // immutable
//    }
//
//}
