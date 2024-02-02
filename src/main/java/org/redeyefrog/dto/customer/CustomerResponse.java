package org.redeyefrog.dto.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerResponse {

    @JsonProperty("return_code")
    private String returnCode;

    @JsonProperty("return_desc")
    private String returnDesc;

}
