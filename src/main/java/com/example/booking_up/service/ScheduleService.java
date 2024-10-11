package com.example.booking_up.service;

import com.example.booking_up.entity.Schedule;
import com.example.booking_up.repository.ScheduleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class ScheduleService {
    ScheduleRepository scheduleRepository;

    public void createSchedule(Schedule schedule){scheduleRepository.save(schedule);}

    public Optional<Schedule> getScheduleById(int id){
        return scheduleRepository.findById(id);
    }

    public void updateSchedule(Schedule schedule){
        scheduleRepository.save(schedule);
    }
}
