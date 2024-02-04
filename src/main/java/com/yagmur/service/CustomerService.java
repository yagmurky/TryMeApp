package com.yagmur.service;

import com.yagmur.dto.request.LoginRequestDto;
import com.yagmur.dto.request.RegisterRequestDto;
import com.yagmur.dto.response.LoginResponseDto;
import com.yagmur.dto.response.RegisterResponseDto;
import com.yagmur.entity.Customer;
import com.yagmur.exception.ErrorType;
import com.yagmur.exception.TryMeAppException;
import com.yagmur.mapper.CustomerMapper;
import com.yagmur.repository.CustomerRepository;
import com.yagmur.utility.EStatus;
import com.yagmur.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICrudService<Customer,Long> {

    private final CustomerRepository customerRepository;
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Iterable<Customer> saveAll(Iterable<Customer> t) {
        return customerRepository.saveAll(t);
    }

    @Override
    public Customer deleteById(Long aLong) {
        Optional<Customer> optionalCustomer= customerRepository.findById(aLong);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get(); // get -> Optional<User> converts to User
            customer.setStatus(EStatus.INACTIVE); // Set the user to inactive
            customerRepository.save(customer);
            return customer;
        } else {
            throw new TryMeAppException(ErrorType.USER_NOT_FOUND);
        }
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return customerRepository.findById(aLong);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public RegisterResponseDto register (RegisterRequestDto registerRequestDto){
        Customer isExist = customerRepository.findByEmail(registerRequestDto.getEmail());
        if(isExist != null){
            throw new TryMeAppException(ErrorType.USER_ALREADY_EXISTS);
        }
        Customer customer = CustomerMapper.INSTANCE.fromRegisterRequestDtoToUser(registerRequestDto);
        if (!customer.getPassword().equalsIgnoreCase(customer.getRepassword()) || customer.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password does not match!");
        } else {
            customerRepository.save(customer);
            return CustomerMapper.INSTANCE.fromUserToRegisterResponseDto(customer);
        }
    }

    public LoginResponseDto login (LoginRequestDto loginRequestDto){
        Optional<Customer> customer = customerRepository.findByEmailAndPassword(loginRequestDto.getEmail(),loginRequestDto.getPassword());
        if(customer.isEmpty()){
            throw new TryMeAppException(ErrorType.USER_NOT_FOUND);
        }
        return CustomerMapper.INSTANCE.fromUserToLoginResponseDto(customer.get());
    }



}
