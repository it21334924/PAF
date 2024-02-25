package lk.zerocode.StudentManagingSystem.controller;

import lk.zerocode.StudentManagingSystem.controller.reqeast.StudentM;
import lk.zerocode.StudentManagingSystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class StudentController {

    private StudentService studentService;


    @PostMapping(value = "/student", headers = "Version=v1")
    public StudentM add(@RequestBody StudentM studentM){
        return studentService.save(studentM);
    }

    @GetMapping (value = "/student/{id}", headers = "Version=v1")
    public Optional<StudentM> getById(@PathVariable Long id){

        return studentService.FindById(id);
    }

    @GetMapping (value = "/student", headers = "Version=v1")
    public List<StudentM> getAll(){

         return studentService.getAll();
    }


    @PutMapping (value = "/student/{id}", headers = "Version=v1")
    public void updateById(@RequestBody StudentM studentM ,@PathVariable Long id){
        studentService.updateById(studentM,id);
    }

    @DeleteMapping(value = "/student/{id}", headers = "Version=v1")
    public void deleteById (@PathVariable Long id){
        studentService.removeById(id);
    }

}
