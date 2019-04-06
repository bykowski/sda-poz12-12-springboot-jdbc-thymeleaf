package pl.bykowski.springbootjdbcthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentApi {

    private StudentDao studentDao;

    @Autowired
    public StudentApi(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("/student")
    public List<Map<String, Object>> addStudent(@RequestParam long id) {
        return studentDao.getStudent(id);
    }

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student) {
        studentDao.save(student);
    }
}
