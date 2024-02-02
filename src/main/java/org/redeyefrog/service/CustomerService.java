package org.redeyefrog.service;

import lombok.extern.slf4j.Slf4j;
import org.redeyefrog.dto.customer.CustomerRequest;
import org.redeyefrog.dto.customer.CustomerResponse;
import org.redeyefrog.dto.customer.FindCustomerQueryCondition;
import org.redeyefrog.dto.customer.FindCustomerQueryResult;
import org.redeyefrog.enums.StatusCode;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
public class CustomerService {

    public FindCustomerQueryResult findCustomer(FindCustomerQueryCondition condition) {
        log.info("condition: {}", condition);
        return FindCustomerQueryResult.builder()
                                      .returnCode(StatusCode.SUCCESS.getCode())
                                      .returnDesc(StatusCode.SUCCESS.getDesc())
                                      .customerList(Collections.emptyList())
                                      .build();
    }

    public CustomerResponse saveCustomer(CustomerRequest request) {
        log.info("request: {}", request);
        return CustomerResponse.builder()
                               .returnCode(StatusCode.SUCCESS.getCode())
                               .returnDesc(StatusCode.SUCCESS.getDesc())
                               .build();
    }

    public CustomerResponse updateCustomer(CustomerRequest request) {
        log.info("request: {}", request);
        return CustomerResponse.builder()
                               .returnCode(StatusCode.SUCCESS.getCode())
                               .returnDesc(StatusCode.SUCCESS.getDesc())
                               .build();
    }

    public CustomerResponse deleteCustomer(String id) {
        log.info("id: {}", id);
        return CustomerResponse.builder()
                               .returnCode(StatusCode.SUCCESS.getCode())
                               .returnDesc(StatusCode.SUCCESS.getDesc())
                               .build();
    }

}
