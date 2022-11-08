package com.technoavi.fourthproject.util;

import org.springframework.stereotype.Component;

@Component
public class Util {
    public String printSMethod(String methodName){
        return methodName +" method is started!!";
    }

    public String printEMethod(String methodName){
        return methodName +" method is executed!!";
    }
}
