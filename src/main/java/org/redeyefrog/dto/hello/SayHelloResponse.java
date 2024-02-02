package org.redeyefrog.dto.hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SayHelloResponse {

    @JsonProperty("return_message")
    private String returnMessage;

}
