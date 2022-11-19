package package1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Test {

    @RequestMapping("/msg")
    public String printMessage() {
        return "Hello GhostCoder This is your first project!!";
    }
}
