package com.veterinaria.apiveterinaria.service;

import com.veterinaria.apiveterinaria.domain.entity.Doctor;
import com.veterinaria.apiveterinaria.domain.entityDto.DoctorDto;
import com.veterinaria.apiveterinaria.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record DoctorService(
        DoctorRepository doctorRepository
) {

    public void createDoctor(DoctorDto doctorDto){
        Doctor doctor = Doctor.builder()
                .name(doctorDto.name())
                .numberLicence(doctorDto.numberLicence())
                .email(doctorDto.email())
                .numberPhone(doctorDto.numberPhone())
                .build();
        doctorRepository.save(doctor);
    }

    public List<Doctor> doctorList() {
        return doctorRepository.findAll();
    }

    public Doctor findDoctorById(Integer id) {
        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found..."));
    }

    public void deleteDoctor(Integer id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found..."));
        doctorRepository.delete(doctor);
    }

    public void updateDoctor(DoctorDto doctorDto){
        Doctor doctor = doctorRepository.findById(doctorDto.id())
                .orElseThrow(() -> new RuntimeException("Doctor not found..."));
        updateDoctorData(doctor, doctorDto);
        doctorRepository.save(doctor);
    }

    private void updateDoctorData(Doctor doctor, DoctorDto doctorDto) {
        doctor.setName(doctorDto.name());
        doctor.setNumberLicence(doctorDto.numberLicence());
        doctor.setEmail(doctorDto.email());
        doctor.setNumberPhone(doctorDto.numberPhone());
    }


}
