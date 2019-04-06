package pl.bykowski.springbootjdbcthymeleaf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentGui {

    private StudentDao studentDao;

    @Autowired
    public StudentGui(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("/gui")
    public String showGui(Model model) {
        model.addAttribute("student", new Student());
        return "gui";
    }

    @PostMapping("/add")
    public String showId(@ModelAttribute Student student) {
        studentDao.save(student);
        return "result";
    }

}
