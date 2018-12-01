package com.lynas.crud

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@SpringBootApplication
class CrudApplication

fun main(args: Array<String>) {
    SpringApplication.run(CrudApplication::class.java, *args)
}


@Controller
class HomeController {

    @RequestMapping("/")
    fun home() : String = "home"
}