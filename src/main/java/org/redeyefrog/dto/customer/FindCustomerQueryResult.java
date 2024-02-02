package org.redeyefrog.dto.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class FindCustomerQueryResult {

    @JsonProperty("return_code")
    private String returnCode;

    @JsonProperty("return_desc")
    private String returnDesc;

    @JsonProperty("customer_list")
    private List<Customer> customerList;

}
