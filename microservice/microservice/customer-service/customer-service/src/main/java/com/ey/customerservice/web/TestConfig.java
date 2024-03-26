package com.ey.customerservice.web;

import com.ey.customerservice.config.GlobalConfig;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class TestConfig {

    @Value("${global.params.p1}")
    private int p1;
    @Value("${global.params.p2}")
    private int p2;

    @GetMapping("/testconfig")
    public Map<String, Integer> testConfig(){
        return Map.of("p1",p1
                ,"p2",p2);
    }
    @Autowired
    private GlobalConfig globalConfig;

    @GetMapping("/globalconfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
}
