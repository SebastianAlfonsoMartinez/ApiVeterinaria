package com.veterinaria.apiveterinaria.controller;


import com.veterinaria.apiveterinaria.domain.entityDto.DoctorDto;
import com.veterinaria.apiveterinaria.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctor")
public record DoctorController(
        DoctorService doctorService
) {

    @PostMapping("/create")
    public ResponseEntity<?> createDoctor(@RequestBody DoctorDto doctorDto) {
        doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> searchAll() {
        return new ResponseEntity<>(doctorService.doctorList(), HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> searchDoctor(@PathVariable("id") Integer id) {
        return new  ResponseEntity<>(doctorService.findDoctorById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable("id") Integer id) {
        doctorService.deleteDoctor(id);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDoctor(@RequestBody DoctorDto doctorDto){
        doctorService.updateDoctor(doctorDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
