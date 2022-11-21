package package1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstApplication {
    public static void main(String[] args) {//From here only out project will start

        //SpringApplications(class) can read all the beans
        SpringApplication.run(FirstApplication.class, args);//run() executes IOC Container
        System.out.println("Hello this is GhostCoder!!");
    }
}
