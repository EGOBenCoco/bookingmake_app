package com.example.booking_up.service;

import com.example.booking_up.entity.Master;
import com.example.booking_up.enums.Enum_Service;
import com.example.booking_up.repository.MasterRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class MasterService {
    MasterRepository masterRepository;

    public void createMaster(Master master){masterRepository.save(master);}

    public Optional<Master> getMasterById(int id){
        return masterRepository.findById(id);
    }

    public List<Master> getAllMasters(){return masterRepository.findAll();}

    public void deleteMaster(int id){
        masterRepository.deleteById(id);
    }

    public void updateMaster(Master master){
        masterRepository.save(master);
    }


    @Transactional(readOnly = true)
    public Page<Master> filter(String location,
                               Enum_Service service,
                               int price,
                               int page,
                               int size) {
        Page<Master> announcements = masterRepository.findByLocation(location, service, price, PageRequest.of(page,size));


       return announcements;
    }
}
