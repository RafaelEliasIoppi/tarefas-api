package com.tarefas.tarefas_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/index.html")
    @ResponseBody
        public String servirIndexManual() {
        return "<html><body><h1>Olá Rafael!</h1></body></html>";
}
}