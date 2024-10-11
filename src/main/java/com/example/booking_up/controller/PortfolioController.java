package com.example.booking_up.controller;

import com.example.booking_up.entity.Portfolio;
import com.example.booking_up.service.PortfolioService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/portfolio")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PortfolioController {
    PortfolioService portfolioService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Portfolio portfolio) {
        portfolioService.createPortfolio(portfolio);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Portfolio>> findById(@PathVariable int id) {
        return ResponseEntity.ok(portfolioService.getPortfolioById(id));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Portfolio portfolio) {
        portfolioService.updatePortfolio(portfolio);
        return ResponseEntity.ok("ok");
    }
}
