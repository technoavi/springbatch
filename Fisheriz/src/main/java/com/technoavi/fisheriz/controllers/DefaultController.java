package com.technoavi.fisheriz.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController("/")
public class DefaultController {

	@GetMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {

        response.sendRedirect("/swagger-ui/index.html");
    }
	
}
