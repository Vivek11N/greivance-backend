package com.example.grievance_management.service;

import com.example.grievance_management.model.Grievance;
import com.example.grievance_management.repository.GrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrievanceService {

    @Autowired
    private GrievanceRepository grievanceRepository;

    public List<Grievance> getAllGrievances() {
        return grievanceRepository.findAll();
    }

    public Grievance addGrievance(Grievance grievance) {
        return grievanceRepository.save(grievance);
    }

    public Grievance getGrievanceById(Long id) {
        return grievanceRepository.findById(id).orElse(null);
    }

    public void deleteGrievance(Long id) {
        grievanceRepository.deleteById(id);
    }
}
