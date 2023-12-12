package com.veterinaria.apiveterinaria.service;

import com.veterinaria.apiveterinaria.domain.entity.Pet;
import com.veterinaria.apiveterinaria.domain.entityDto.PetDto;
import com.veterinaria.apiveterinaria.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public record PetService(
        PetRepository petRepository
) {


    public void createPet(PetDto petDto){
        Pet pet = Pet.builder()
                .name(petDto.name())
                .type(petDto.type())
                .age(petDto.age())
                .build();
        petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(Integer id) {
        return petRepository.findById(id);
    }

    public void removePet(Integer id){
        Pet pet = petRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pet not found..."));

        petRepository.delete(pet);
    }

    public void updatePet(PetDto petDto){
        Pet pet = petRepository.findById(petDto.id())
                .orElseThrow(() -> new RuntimeException("Pet not found..."));
        updatePetData(pet, petDto);
        petRepository.save(pet);
    }

    private void updatePetData(Pet pet, PetDto petDto) {

        pet.setName(petDto.name());
        pet.setType(petDto.type());
        pet.setAge(petDto.age());

    }
}
