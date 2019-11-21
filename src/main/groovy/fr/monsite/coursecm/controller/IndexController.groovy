package fr.monsite.coursecm.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {
    @RequestMapping("/")
    String home() {
        "Hello Thomas!"
    }
}