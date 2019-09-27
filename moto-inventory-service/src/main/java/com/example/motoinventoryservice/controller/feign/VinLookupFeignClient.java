package com.example.motoinventoryservice.controller.feign;

import com.example.motoinventoryservice.model.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vin-lookup-service")
public interface VinLookupFeignClient {
    @GetMapping("/vehicle/{vin}")
    Vehicle getVehicleByVin(@PathVariable String vin);
}
