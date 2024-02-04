package com.yagmur.controller;

import com.yagmur.dto.request.LoginRequestDto;
import com.yagmur.dto.request.RegisterRequestDto;
import com.yagmur.dto.response.LoginResponseDto;
import com.yagmur.dto.response.RegisterResponseDto;
import com.yagmur.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(customerService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(customerService.login(dto));
    }




}
