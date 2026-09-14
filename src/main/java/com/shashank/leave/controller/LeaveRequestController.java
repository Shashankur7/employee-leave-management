package com.shashank.leave.controller;

import com.shashank.leave.entity.LeaveRequest;
import com.shashank.leave.service.LeaveRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveRequestController {
    private final LeaveRequestService service;
    public LeaveRequestController(LeaveRequestService service) { this.service = service; }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public LeaveRequest create(@Valid @RequestBody LeaveRequest request) { return service.create(request); }
    @GetMapping public List<LeaveRequest> findAll() { return service.findAll(); }
    @GetMapping("/{id}") public LeaveRequest findById(@PathVariable Long id) { return service.findById(id); }
    @GetMapping("/employee/{employeeId}") public List<LeaveRequest> findByEmployee(@PathVariable Long employeeId) { return service.findByEmployee(employeeId); }
}
