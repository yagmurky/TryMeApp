package com.yagmur.repository;

import com.yagmur.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
    Optional<Customer> findByEmailAndPassword(String email, String password);
}
