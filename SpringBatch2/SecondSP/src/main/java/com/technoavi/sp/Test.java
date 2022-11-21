package com.technoavi.sp;


import org.springframework.web.bind.annotation.*;


@RestController("/")
public class Test {

    @PostMapping("/create/emp")
    public String create(){
        return "distinction";
    }

    @GetMapping("/emp/{id}")
    public String getEmpDetails(@PathVariable("msg") String msg,
                               @PathVariable("age") String age){

        return "hello "+msg+ " age : "+age;
    }
    @PutMapping ("/emp/{id}/{salary}")
    public String update(@PathVariable("msg") String msg,
                         @PathVariable("age") String age){

        return "hello "+msg+ " age : "+age;
    }
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("msg") String msg,
                               @PathVariable("age") String age){

        return "hello "+msg+ " age : "+age;
    }
}
