package com.example.obrestdatajpaej456.repositories;

import com.example.obrestdatajpaej456.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{
}
