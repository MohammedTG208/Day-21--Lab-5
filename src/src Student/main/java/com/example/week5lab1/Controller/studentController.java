package com.example.week5lab1.Controller;

import com.example.week5lab1.ApiResponse.ApiResponse;
import com.example.week5lab1.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/student/info")
public class studentController {
    ArrayList<Student> students = new ArrayList<Student>();

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
    }

    @GetMapping("/name/{index}")
    public String getStudents(@PathVariable int index) {
        if (students.isEmpty()){
            return new ApiResponse("is empty").toString();
        }else {
            return students.get(index).getName();
        }
    }

    @GetMapping("/age/{index}")
    public int getStudentAge(@PathVariable int index) {
        return students.get(index).getAge();
    }

    @GetMapping("/college/degree/{index}")
    public String getStudentDegree(@PathVariable int index) {
        if (students.isEmpty()){
            return new ApiResponse("is empty").toString();
        }else {
            return students.get(index).getDegree();
        }
    }

    @GetMapping("/study/status/{index}")
    public boolean getStudentStatus(@PathVariable int index) {
        return students.get(index).getStatus().equalsIgnoreCase("graduated");
    }

    @GetMapping("/students")
    public ArrayList<Student> getAllStudents() {
        return students;
    }
}
