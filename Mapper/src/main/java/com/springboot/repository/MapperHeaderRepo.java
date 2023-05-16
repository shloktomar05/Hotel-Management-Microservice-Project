package com.springboot.repository;

import com.springboot.model.Header;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapperHeaderRepo extends JpaRepository<Header, String> {
}
