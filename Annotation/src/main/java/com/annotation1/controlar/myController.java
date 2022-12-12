package com.annotation1.controlar;

import com.annotation1.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class myController {
    @Autowired
    @Qualifier("student1")
    private Student student;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    @ResponseBody
    public Student home(@RequestBody Student st) {
        st.studying();
        this.student.setName(st.getName());
        System.out.println("This is home page!!");
//        return "Home page is returned";
        return student;
    }

    @RequestMapping(value = "/setName/{id}", method = RequestMethod.GET)
    public Student setName(@PathVariable("id") String name) {
        this.student.setName(name);
        return student;
    }
}
