package com.example.booking_up.controller;

import com.example.booking_up.entity.Schedule;
import com.example.booking_up.service.ScheduleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ScheduleController {
    ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Schedule schedule) {
        scheduleService.createSchedule(schedule);
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Schedule>> findById(@PathVariable int id) {
        return ResponseEntity.ok(scheduleService.getScheduleById(id));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Schedule schedule) {
        scheduleService.updateSchedule(schedule);
        return ResponseEntity.ok("Ok");
    }
}
