package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.CustomerProfile;

@Repository
public interface CustomerProfileRepo extends JpaRepository<CustomerProfile, Integer>{

}
