package com.MVC.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MVC.service.IDoctorMgmtService;
import com.MVC.vo.DoctorVO;

import jakarta.servlet.http.HttpSession;

/**
 * Controller for managing doctor-related operations such as 
 * registration, updating, deleting, and displaying doctor records.
 */
@Controller
public class DoctorOperationsController 
{
	@Autowired
	private IDoctorMgmtService docService;
	
	/**
	 * Displays the home (welcome) page.
	 * @return logical view name for home page.
	 */
	@GetMapping("/") 
	public String ShowHome()
	{
		return "welcome";
	}
	
	/**
	 * Displays report page with list of doctors.
	 * @param map model attributes map.
	 * @return logical view name for report page.
	 */
	@GetMapping("/report")
	public String showReport(Map<String,Object>map)
	{
		List<DoctorVO> listVO = docService.findAllDoctors();
		map.put("doctorsList", listVO);
		return "show_report";
	}

	/**
	 * Displays the doctor registration form.
	 * @param vo empty DoctorVO object to bind form data.
	 * @return logical view name for registration form page.
	 */
	 @GetMapping("/register")
	 public String showRegisterDoctorForm(@ModelAttribute("docVO") DoctorVO vo) {
		 return "register_doctor_form";
	 }

	/**
	 * Handles doctor registration form submission.
	 * Stores result message in session for redirect scope.
	 * @param vo DoctorVO containing form data.
	 * @param ses HttpSession for storing flash messages.
	 * @return redirect to report page.
	 */
	 @PostMapping("/register") 
	 public String registerDoctor(@ModelAttribute("docVO") DoctorVO vo,
	                              HttpSession ses) {
	     System.out.println("DoctorOperationsController.registerDoctor()");
	     String msg = docService.registerDoctor(vo);
	     ses.setAttribute("resultMsg", msg);
	     return "redirect:report";
	 }
	 
	/**
	 * Displays the edit form pre-filled with doctor data.
	 * @param no doctor ID to fetch.
	 * @param vo DoctorVO to bind existing data.
	 * @return logical view name for edit form page.
	 */
	 @GetMapping("/edit")
	 public String showEditDoctorFromPage(@RequestParam("did") int no, @ModelAttribute("docVO") DoctorVO vo) 
	 {
		 DoctorVO vo1 = docService.showDoctorById(no);
	     if (vo1 == null)
	     {
	         return "redirect:report";
	     }
	     BeanUtils.copyProperties(vo1, vo);
	     return "edit_doctor_form";
	 }

	/**
	 * Handles edit form submission.
	 * Stores result message using RedirectAttributes.
	 * @param vo DoctorVO containing updated data.
	 * @param attrs RedirectAttributes for flash messaging.
	 * @return redirect to report page.
	 */
	 @PostMapping("/edit")
	 public String editDoctor(@ModelAttribute("docVO") DoctorVO vo, RedirectAttributes attrs) { 
	     String msg = docService.editDoctor(vo);
	     attrs.addFlashAttribute("resultMsg", msg);
	     return "redirect:report";
	 }
	 
	/**
	 * Deletes a doctor based on ID.
	 * Stores deletion result message using RedirectAttributes.
	 * @param did doctor ID to delete.
	 * @param attrs RedirectAttributes for flash messaging.
	 * @return redirect to report page.
	 * @throws Exception in case of errors during deletion.
	 */
	 @GetMapping("/delete")
	 public String removeDoctor(@RequestParam("didNo") int did, RedirectAttributes attrs) throws Exception {
	     System.out.println("DoctorOperationController.removeDoctor()");
	     String msg = docService.removeDoctor(did);
	     attrs.addFlashAttribute("resultMsg", msg);
	     return "redirect:report";
	 }
}
