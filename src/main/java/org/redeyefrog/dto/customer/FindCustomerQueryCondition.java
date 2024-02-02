package org.redeyefrog.dto.customer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class FindCustomerQueryCondition {

    @ApiModelProperty(name = "id", value = "Customer Id", example = "0000000001")
    @NotBlank(message = "ID can not be blank")
    private String id;

    @ApiModelProperty(name = "name", value = "Customer Name", example = "Mary")
    private String name;

}
