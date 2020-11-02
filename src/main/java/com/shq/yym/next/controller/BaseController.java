package com.shq.yym.next.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: BaseController
 * @Description: 基础controller
 * @author: sihanqiu
 * @date: 2020年08月19日 13:44
 */
@RestController
@RequestMapping("/base")
public class BaseController {

    @GetMapping("hello")
    public String hello() {

        return "Hello, My Name is test man";
    }
}
