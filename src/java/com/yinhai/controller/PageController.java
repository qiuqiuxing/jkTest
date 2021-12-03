package com.yinhai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qiurong
 * @version 1.0.0
 * @Description
 * @ClassName PageController.java
 * @createTime 2021年02月26日 10:36:00
 */
@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    @RequestMapping("/jweui/{page}")
    public String showJweuiPage(@PathVariable String page) {
        return "jweui/"+page;
    }
}
