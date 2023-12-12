package com.veterinaria.apiveterinaria.controller;

import com.veterinaria.apiveterinaria.domain.entity.Pet;
import com.veterinaria.apiveterinaria.domain.entityDto.PetDto;
import com.veterinaria.apiveterinaria.repository.PetRepository;
import com.veterinaria.apiveterinaria.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/pet")
public record PetController(
        PetService petService

) {

    @PostMapping
    public ResponseEntity<?> registerPet(@RequestBody PetDto petDto){
        petService.createPet(petDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> showPets(){
        return new ResponseEntity<>(petService.getAllPets(),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> removePet(@PathVariable("id") Integer id) {
        petService.removePet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("update")
    public ResponseEntity<?> updatePet(@RequestBody PetDto petDto){
        petService.updatePet(petDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
