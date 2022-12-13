package com.msusers.feign;

import com.msusers.feign.feignmodel.BillDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "ms-bill")
public interface BillFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/bills/{id}")
    List<BillDto> getBillById(@PathVariable String id);

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/bills"
    )
    BillDto createBill(@RequestBody BillDto billDto);
}
