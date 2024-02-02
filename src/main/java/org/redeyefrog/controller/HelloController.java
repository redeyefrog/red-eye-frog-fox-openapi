package org.redeyefrog.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.redeyefrog.dto.hello.SayHelloRequest;
import org.redeyefrog.dto.hello.SayHelloResponse;
import org.redeyefrog.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @ApiOperation("SayHello")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "Someone", example = "Mary", required = true)
    })
    @GetMapping("/say")
    public SayHelloResponse sayHello(@RequestParam String name) {
        return helloService.sayHello(name);
    }

    @ApiOperation("SayHello")
    @PostMapping("/say")
    public SayHelloResponse sayHello(@Valid @RequestBody SayHelloRequest request) {
        return helloService.sayHello(request);
    }

}
