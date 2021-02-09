package com.github.arpitmehra.nameo.controller;

import com.github.arpitmehra.nameo.service.NameOService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Max;

@Controller
@Validated
@Slf4j
public class NameOController {

    @Autowired
    NameOService nameOService;

    @RequestMapping({"/{size}", "/"})
    @ResponseBody
    public String loginCode(@PathVariable(name = "size", required = false) @Max(4) Integer size) {
        long startTime = System.currentTimeMillis();
        size = (size == null) ? 2 : size;
        log.info("Total time taken - " + (System.currentTimeMillis() - startTime));
        return nameOService.generateLoginCode(size);
        //return "Hello World!";
    }

}
