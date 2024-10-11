package com.example.booking_up.repository;

import com.example.booking_up.entity.Master;
import com.example.booking_up.enums.Enum_Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface MasterRepository extends JpaRepository<Master, Integer> {

     @Query("SELECT a FROM Master a " +
             "LEFT JOIN a.listServices s " +
             "WHERE (:location IS NULL OR a.location = :location) AND " +
             "(:type IS NULL OR s.service = :type) AND " +
             "(:price IS NULL OR s.price = :price) ")
     Page<Master> findByLocation(
             @Param("location") String location,
             @Param("type") Enum_Service type,
             @Param("price") int price,
             Pageable pageable
     );
}
