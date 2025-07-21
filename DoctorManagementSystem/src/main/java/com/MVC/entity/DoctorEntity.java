package com.MVC.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

/**
 * Entity class representing Doctor information stored in the database.
 * Mapped to the table MP_JPA_DOCTOR.
 * 
 * Includes audit columns, optimistic locking, and metadata like created/updated timestamps.
 * 
 * Author: Your Name
 */
@Entity
@Table(name = "MP_JPA_DOCTOR")
@Data
public class DoctorEntity {

    /** Primary key: Auto-generated Doctor ID using sequence DID_SEQ. */
    @Id
    @SequenceGenerator(name = "gen1", sequenceName = "DID_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
    private Integer did;

    /** Name of the doctor (max 30 characters). */
    @Column(length = 30)
    private String dname;

    /** Doctor's specialization (unlimited length). */
    private String specialization;

    /** Consultation fee charged by the doctor. */
    private Double fee;

    /** Doctor's qualification (max 30 characters). */
    @Column(length = 30)
    private String qlfy;

    /** Optimistic locking version field, auto-managed by Hibernate. */
    @Version
    private Integer updateCount;

    /** Timestamp when the record was created (auto-set on insert). */
    @CreationTimestamp
    @Column(updatable = false, insertable = true)
    private LocalDateTime createdOn;

    /** Timestamp when the record was last updated (auto-updated). */
    @UpdateTimestamp
    @Column(updatable = true, insertable = false)
    private LocalDateTime lastAccessedOn;

    /** Status flag indicating whether the doctor is active (default 'active'). */
    @Column(length = 30)
    private String active_SW = "active";

    /** Name of the user who created the record (immutable after insertion). */
    @Column(length = 30, updatable = false)
    private String createBy;

    /** Name of the user who last updated the record (not insertable during creation). */
    @Column(length = 30, insertable = false)
    private String updatedBy;

    /**
     * Constructor initializing default status.
     * Sets active_SW to 'active' by default.
     */
    public DoctorEntity() {
        this.active_SW = "active";
    }
}
