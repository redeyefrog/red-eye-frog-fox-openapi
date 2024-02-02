package org.redeyefrog.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.redeyefrog.dto.customer.CustomerRequest;
import org.redeyefrog.dto.customer.CustomerResponse;
import org.redeyefrog.dto.customer.FindCustomerQueryCondition;
import org.redeyefrog.dto.customer.FindCustomerQueryResult;
import org.redeyefrog.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation("FindCustomer")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Customer Id", example = "0000000001", dataTypeClass = String.class),
            @ApiImplicitParam(name = "name", value = "Customer Name", example = "Mary", dataTypeClass = String.class)
    })
    @GetMapping("/find")
    public FindCustomerQueryResult findCustomer(@Valid @ModelAttribute FindCustomerQueryCondition condition) {
        return customerService.findCustomer(condition);
    }

    @ApiOperation("SaveCustomer")
    @PostMapping("/save")
    public CustomerResponse saveCustomer(@Valid @RequestBody CustomerRequest request) {
        return customerService.saveCustomer(request);
    }

    @ApiOperation("UpdateCustomer")
    @PutMapping("/update")
    public CustomerResponse updateCustomer(@Valid @RequestBody CustomerRequest request) {
        return customerService.updateCustomer(request);
    }

    @ApiOperation("DeleteCustomer")
    @ApiImplicitParam(name = "id", value = "Customer Id", example = "0000000001", dataTypeClass = String.class)
    @DeleteMapping("/delete/{id}")
    public CustomerResponse deleteCustomer(@PathVariable String id) {
        return customerService.deleteCustomer(id);
    }

}
