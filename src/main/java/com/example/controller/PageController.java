package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String goto_main(){
        return "redirect:/html/index.html";
    }

    @RequestMapping("/table")
    public String goto_table() {
        return "redirect:/html/table/table.html";
    }

    @RequestMapping("/dataTable")
    public String goto_dataTable() {
        return "redirect:/html/table/dataTable.html";
    }
}
