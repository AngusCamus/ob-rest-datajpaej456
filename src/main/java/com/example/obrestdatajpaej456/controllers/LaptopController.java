package com.example.obrestdatajpaej456.controllers;

import com.example.obrestdatajpaej456.entities.Laptop;
import com.example.obrestdatajpaej456.repositories.LaptopRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop){
        laptopRepository.save(laptop);
        return laptop;
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        if (laptopOpt.isPresent()){
            return ResponseEntity.ok(laptopOpt.get());
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> update(@RequestBody Laptop newLaptop, @PathVariable Long id){
        Laptop laptop = laptopRepository.findById(id).get();
        if (laptopRepository.findById(id).isPresent()){

            laptopRepository.save(newLaptop);
            return ResponseEntity.ok(newLaptop);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        if (laptopOpt.isPresent()){
            laptopRepository.delete(laptopOpt.get());
            return ResponseEntity.ok(laptopOpt.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        return ResponseEntity.accepted().build();
    }
}
