package com.example.student_library_management_system.service;

import com.example.student_library_management_system.enums.CardStatus;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.repository.StudentRepository;
import com.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String saveStudent(StudentRequestDto studentRequestDto) {

        // convert the request DTO into model class
        Student student = new Student();
        student.setStudentName(studentRequestDto.getStudentName());
        student.setEmail(studentRequestDto.getEmail());
        student.setPhone(studentRequestDto.getPhone());
        student.setDob(studentRequestDto.getDob());
        student.setGender(studentRequestDto.getGender());
        student.setAddress(studentRequestDto.getAddress());
        student.setSemester(studentRequestDto.getSemester());
        student.setCourse(studentRequestDto.getCourse());
        student.setDept(studentRequestDto.getDept());

        // whenever student adds, card also gets added as part of cascading
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setExpiryDate(LocalDate.now().plusYears(3).toString());
        card.setMaxBooksAllowed(5);
        card.setStudent(student);
        student.setCard(card);

        studentRepository.save(student);
        return "Student saved successfully!";
    }

    public Student findStudentById(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent())
        {
            return studentOptional.get();
        }
        else
        {
            return null;
        }
    }

    public List<Student> findAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public String countStudent() {
       long totalStudentCount = studentRepository.count();
       return "Total number of students are: " + totalStudentCount;

    }

    public String deleteStudentById(int id) {
        Student student = findStudentById(id);
        if(student != null)
        {
            studentRepository.deleteById(id);
            return "Student with id: " + id + " got deleted successfully!";
        }
        else
        {
            return "Student with id: " + id + " is not present, hence cannot delete";
        }
    }

    public String updateStudentUsingPut(int id, StudentRequestDto newStudentRequestDto) {
        Student existingStudent = findStudentById(id);
        if(existingStudent != null)
        {
            existingStudent.setStudentName(newStudentRequestDto.getStudentName());
            existingStudent.setEmail(newStudentRequestDto.getEmail());
            existingStudent.setPhone(newStudentRequestDto.getPhone());
            existingStudent.setDob(newStudentRequestDto.getDob());
            existingStudent.setGender(newStudentRequestDto.getGender());
            existingStudent.setAddress(newStudentRequestDto.getAddress());
            existingStudent.setSemester(newStudentRequestDto.getSemester());
            existingStudent.setCourse(newStudentRequestDto.getCourse());
            existingStudent.setDept(newStudentRequestDto.getDept());

            studentRepository.save(existingStudent);
            return "Student with id: " + id + " got updated successfully!";
        }
        else
        {
            return "Student with id: " + id + " is not present, hence cannot update";
        }
    }

}
