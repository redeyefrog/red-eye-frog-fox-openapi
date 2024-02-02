package org.redeyefrog.dto.hello;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SayHelloRequest {

    @ApiModelProperty(name = "name", value = "Someone", example = "Mary", required = true)
    @NotBlank
    private String name;

    @ApiModelProperty(name = "message", value = "Greeting", example = "Have a good one.", required = true)
    @NotBlank
    private String message;

}
