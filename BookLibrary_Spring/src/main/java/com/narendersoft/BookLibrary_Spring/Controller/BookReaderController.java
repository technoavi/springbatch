package com.narendersoft.BookLibrary_Spring.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookReaderController {

    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    public String getMessage(@PathVariable String name) {
        return "GET: Hello "+name;
    }
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String message(@PathVariable String name) {
        return "POST: Hello "+name;
    }
}
