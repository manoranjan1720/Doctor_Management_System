package com.MVC.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MVC.entity.DoctorEntity;
import com.MVC.service.IDoctorMgmtService;
import com.MVC.vo.DoctorVO;

/**
 * Service implementation for managing doctor-related operations.
 * Handles CRUD operations and conversions between Entity and VO layers.
 */
@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService 
{
    @Autowired
    private IDoctorRepository doctorRepo;

    /**
     * Fetches all doctors from the database and converts them to VO objects.
     * 
     * @return List of DoctorVO containing doctor details.
     */
    @Override
    public List<DoctorVO> findAllDoctors() {
        List<DoctorEntity> listEntities = doctorRepo.findAll();
        List<DoctorVO> listVO = new ArrayList<>();
        listEntities.forEach(entity -> {
            DoctorVO vo = new DoctorVO();
            BeanUtils.copyProperties(entity, vo);
            listVO.add(vo);
        });
        return listVO;
    }

    /**
     * Registers a new doctor by saving the data into the database.
     * 
     * @param vo DoctorVO containing the doctor details to be registered.
     * @return Success message with registered doctor ID.
     */
    @Override
    public String registerDoctor(DoctorVO vo) {
        DoctorEntity entity = new DoctorEntity();
        BeanUtils.copyProperties(vo, entity);
        entity.setCreateBy(System.getProperty("user.name"));
        int idVal = doctorRepo.save(entity).getDid();
        return "Doctor is Registered with id value::" + idVal;
    }

    /**
     * Fetches doctor details by ID and converts to VO.
     * 
     * @param id Doctor ID to fetch.
     * @return DoctorVO containing fetched doctor details.
     */
    @Override
    public DoctorVO showDoctorById(int id) {
        DoctorEntity entity = doctorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        DoctorVO vo = new DoctorVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    /**
     * Updates existing doctor details.
     * 
     * @param vo DoctorVO containing updated doctor data.
     * @return Success message indicating update.
     */
    @Override
    public String editDoctor(DoctorVO vo) {
        Integer id = vo.getDid();
        DoctorEntity entity = doctorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));

        BeanUtils.copyProperties(vo, entity, "did", "createdOn", "createdBy");
        entity.setUpdatedBy(System.getProperty("user.name"));

        doctorRepo.save(entity);

        return "Doctor with ID " + id + " has been updated successfully.";
    }

    /**
     * Deletes a doctor by ID.
     * 
     * @param did Doctor ID to delete.
     * @return Success message after deletion.
     * @throws Exception if doctor not found.
     */
    @Override
    public String removeDoctor(int did) throws Exception {
        @SuppressWarnings("unused")
		DoctorEntity entity = doctorRepo.findById(did)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id: " + did));
        doctorRepo.deleteById(did);
        return did + "id Doctor is Deleted";
    }
}
