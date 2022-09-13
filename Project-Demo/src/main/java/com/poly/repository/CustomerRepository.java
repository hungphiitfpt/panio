package com.poly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.model.Customes;

public interface CustomerRepository extends JpaRepository<Customes, Long>{

}
