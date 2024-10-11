package com.example.booking_up.controller;

import com.example.booking_up.entity.Master;
import com.example.booking_up.enums.Enum_Service;
import com.example.booking_up.service.MasterService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/master")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MasterController {
    MasterService masterService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Master master) {
        masterService.createMaster(master);
        return ResponseEntity.ok("ok");}

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Master>> findById(@PathVariable int id) {
        return ResponseEntity.ok(masterService.getMasterById(id));
    }

    @GetMapping
    public ResponseEntity<List<Master>> findAll() {
        return ResponseEntity.ok( masterService.getAllMasters());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        masterService.deleteMaster(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Master master) {
        masterService.updateMaster(master);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<Master>> filter(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Enum_Service service,
            @RequestParam(required = false) int price,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        Page<Master> announcements = masterService.filter(
                location, service, price,page,size
        );
        return ResponseEntity.ok(announcements);
    }

}
// запустить это приложение и протестировать его на создание сущнстей клиента и мастера
// также протестировать методы сервиса мастер и клиента особенно протестировать методы сортировки и фильтрации