package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.StudentRepository;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getSudents(Model model) {
        List<Student> students = studentRepository.getStudents();
        model.addAttribute("students", students);
        return "studentList";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addStudent")
    public String addStudent() {
        return "studentAdd";
    }

    // TODO: 02.10.2018 admin?
    @RequestMapping(method = RequestMethod.POST, value = "/addStudent")
    public String addStudent(@RequestParam("name") String name, @RequestParam("age") String age, @RequestParam(name = "admin", defaultValue = "false") Boolean admin) {
        Student student = new Student();
        student.setName(name);
        student.setAge(Integer.parseInt(age));
        student.setAdmin(admin);
        student.setCreated_date();
        studentRepository.addStudent(student);
        return "redirect:/student/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delStudent/{id}")
    public String delStudent(@PathVariable("id") Integer id) {
        studentRepository.delStudent(id);
        return "redirect:/student/";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editStudent/{id}")
    public String editStudent(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("age") String age,
                              @RequestParam(name = "admin", defaultValue = "false") Boolean admin) {
        Student student = studentRepository.getStudentById(id);
        student.setAdmin(admin);
        student.setAge(Integer.parseInt(age));
        student.setName(name);
        studentRepository.editStudent(student);
        return "redirect:/student/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editStudent/{id}")
    public String editStudent(@PathVariable("id") Integer id, Model model) {
        Student student = studentRepository.getStudentById(id);
        model.addAttribute("student", student);
        return "studentEdit";
    }

}
