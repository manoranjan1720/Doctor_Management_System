package com.MVC.service;

import java.util.List;
import com.MVC.vo.DoctorVO;

/**
 * Service interface for managing doctor-related operations.
 * 
 * Defines methods for fetching, registering, updating, and deleting doctors.
 * Acts as the business layer contract for Doctor management.
 * 
 * Author: Your Name
 */
public interface IDoctorMgmtService {

    /**
     * Fetches the list of all doctors.
     * 
     * @return List of DoctorVO containing doctor details.
     */
    public List<DoctorVO> findAllDoctors();

    /**
     * Registers a new doctor.
     * 
     * @param vo DoctorVO containing doctor data to register.
     * @return Success message with registered doctor ID.
     */
    public String registerDoctor(DoctorVO vo);

    /**
     * Fetches details of a doctor by ID.
     * 
     * @param id Doctor ID.
     * @return DoctorVO containing doctor details.
     */
    public DoctorVO showDoctorById(int id);

    /**
     * Updates details of an existing doctor.
     * 
     * @param vo DoctorVO containing updated doctor data.
     * @return Success message after update.
     */
    public String editDoctor(DoctorVO vo);

    /**
     * Deletes a doctor record based on ID.
     * 
     * @param did Doctor ID to delete.
     * @return Success message after deletion.
     * @throws Exception if the doctor is not found or deletion fails.
     */
    public String removeDoctor(int did) throws Exception;

}
