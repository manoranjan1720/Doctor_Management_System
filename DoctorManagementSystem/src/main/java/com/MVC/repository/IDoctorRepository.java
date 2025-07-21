package com.MVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MVC.entity.DoctorEntity;

/**
 * Repository interface for DoctorEntity.
 * 
 * Extends JpaRepository to provide standard CRUD operations
 * without requiring implementation.
 * 
 * This acts as a Data Access Layer (DAO) for DoctorEntity.
 */
public interface IDoctorRepository extends JpaRepository<DoctorEntity, Integer> {

}
