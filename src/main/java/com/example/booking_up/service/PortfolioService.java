package com.example.booking_up.service;

import com.example.booking_up.entity.Portfolio;
import com.example.booking_up.repository.PortfolioRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class PortfolioService {
    PortfolioRepository portfolioRepository;

    public void createPortfolio(Portfolio portfolio){
        portfolioRepository.save(portfolio);
    }

    public Optional<Portfolio> getPortfolioById(int id){
        return portfolioRepository.findById(id);
    }

    public void updatePortfolio(Portfolio portfolio){
        portfolioRepository.save(portfolio);
    }
}
