package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.StudentRepository;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;


}
