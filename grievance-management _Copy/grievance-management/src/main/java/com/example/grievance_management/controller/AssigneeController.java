package com.example.grievance_management.controller;

import com.example.grievance_management.model.Assignee;
import com.example.grievance_management.service.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignees")
@CrossOrigin(origins = "http://localhost:3000")  // Enable CORS for this controller
public class AssigneeController {
    @Autowired
    private AssigneeService assigneeService;

    @PostMapping("/login")
    public ResponseEntity<?> loginAssignee(@RequestBody Assignee loginData) {
        return assigneeService.login(loginData.getAssigneeEmail(), loginData.getAssigneePassword());
    }
}
