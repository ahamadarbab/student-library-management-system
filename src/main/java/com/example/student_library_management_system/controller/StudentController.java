package com.example.student_library_management_system.controller;

import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.requestdto.StudentRequestDto;
import com.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto) {
        String response = studentService.saveStudent(studentRequestDto);
        return response;
    }

    @GetMapping("/findById/{id}")
    public Student findStudentById(@PathVariable int id) {
        Student student = studentService.findStudentById(id);
        return student;
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudent() {
        List<Student> studentList = studentService.findAllStudents();
        return studentList;
    }

    @GetMapping("/count")
    public String countStudent() {
        String response = studentService.countStudent();
        return response;
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteStudentById(@PathVariable int id) {
        String response = studentService.deleteStudentById(id);
        return response;
    }

    @PutMapping("/updateByPut/{id}")
    public String updateStudentUsingPut(@PathVariable int id, @RequestBody StudentRequestDto studentRequestDto) {
        String response = studentService.updateStudentUsingPut(id, studentRequestDto);
        return response;
    }

}
