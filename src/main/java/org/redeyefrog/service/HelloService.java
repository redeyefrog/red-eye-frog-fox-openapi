package org.redeyefrog.service;

import org.redeyefrog.dto.hello.SayHelloRequest;
import org.redeyefrog.dto.hello.SayHelloResponse;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class HelloService {

    public SayHelloResponse sayHello(String name) {
        return SayHelloResponse.builder()
                               .returnMessage(MessageFormat.format("Hello {0}", name))
                               .build();
    }

    public SayHelloResponse sayHello(SayHelloRequest request) {
        return SayHelloResponse.builder()
                               .returnMessage(MessageFormat.format("Hello {0}, {1}", request.getName(), request.getMessage()))
                               .build();
    }

}
