package org.redeyefrog.dto.customer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class CustomerRequest {

    @ApiModelProperty(name = "id", value = "Customer Id", example = "0000000001", required = true)
    @NotBlank
    private String id;

    @ApiModelProperty(name = "name", value = "Customer Name", example = "Mary", required = true)
    @NotBlank
    private String name;

    @ApiModelProperty(name = "birthday", value = "Customer Birthday", example = "1990/01/01")
    private String birthday;

    @ApiModelProperty(name = "phone", value = "Customer Phone", example = "09123456789", required = true)
    @NotBlank
    private String phone;

    @ApiModelProperty(name = "email", value = "Customer Email", example = "mary@contact.org", required = true)
    @Email
    private String email;

}
