package com.br.monitoria.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ap1Controller {

    @GetMapping("/ap1")
    public String ap1() {
        return "ap1"; 
    }
}
