package com.odea.service;

import org.springframework.stereotype.Service;

@Service
public class ServicioFalso {
    private String msg;

    public ServicioFalso() {
        this.msg = "mentiraaaa";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
