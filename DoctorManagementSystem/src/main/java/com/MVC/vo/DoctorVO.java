package com.MVC.vo;

import lombok.Data;

/**
 * Value Object (VO) class representing Doctor data used for data transfer
 * between presentation and service layers.
 * 
 * Acts as a carrier for doctor information in the application.
 * 
 * Author: Your Name
 */
@Data
public class DoctorVO {

    /** Unique identifier of the doctor. */
    private Integer did;

    /** Doctor's name. */
    private String dname;

    /** Doctor's specialization field. */
    private String specialization;

    /** Consultation fee charged by the doctor. */
    private Double fee;

    /** Doctor's qualification. */
    private String qlfy;

    // private Integer update_count; // Reserved for future use if needed.
}
