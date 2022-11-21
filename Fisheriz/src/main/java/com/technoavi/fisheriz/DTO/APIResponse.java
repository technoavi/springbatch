package com.technoavi.fisheriz.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class APIResponse implements Serializable {
    private static final long serialVersionUID= 1L;
    private int responseCode;
    private String responseMessage;
    private Object data;

}
