package com.pratheek.restaurentlisting.repository;

import com.pratheek.restaurentlisting.entity.Restaurent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurentRepository extends JpaRepository<Restaurent, Integer> {
}
