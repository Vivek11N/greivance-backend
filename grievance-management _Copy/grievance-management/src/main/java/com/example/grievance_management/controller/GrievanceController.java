package com.example.grievance_management.controller;

import com.example.grievance_management.model.Grievance;
import com.example.grievance_management.repository.GrievanceRepository;
import com.example.grievance_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grievances")
public class GrievanceController {

    @Autowired
    private GrievanceRepository grievanceRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<Grievance> addGrievance(@RequestBody Grievance grievance) {
        if (grievance.getUser() != null && grievance.getUser().getUserId() != null) {
            grievance.setUser(userRepository.findById(grievance.getUser().getUserId()).orElse(null));
        }
        Grievance newGrievance = grievanceRepository.save(grievance);
        return ResponseEntity.ok(newGrievance);
    }
}
