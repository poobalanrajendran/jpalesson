package com.chainsys.jpa.application.doctor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DoctorService {
	@Autowired
	private DoctorRepository repo;
//	@Bean
//	public void setRepo(DoctorRepository repo)
//	{
//		this.repo=repo;
//	}
	@GetMapping("/getdoctor")
	public Doctor getDoctor(int id)
	{
		return repo.findById(id);
	}
	@PostMapping(value="/addDoctors", consumes="application/json")
	// we need to give where to readdata from the http request and also the content type (application/json)
	public String AddNewDoctor(@RequestBody Doctor dr) {
//		System.out.println("Doctor: "+dr.getDoc_id()+" "+dr.getDoc_name());
		repo.save(dr);
		return "redirect:/AddNewDoctors";
	}
	@PostMapping(value="/modifyDoctors", consumes="application/json")
	public String modifyDoctor(@RequestBody Doctor dr) {
//		System.out.println("Doctor: "+dr.getDoc_id()+" "+dr.getDoc_name());
		repo.save(dr);
		return "redirect:/ModifyDoctors";
	}
	@GetMapping("getAllDoctors")
	public List<Doctor> GetAllDoctors(){
		return repo.findAll();
	}
	@DeleteMapping("/deleteDoctors")
	public String DeleteDoctor(int id) {
		repo.deleteById(id);
		return "redirect:/DeleteDoctors";
	}
}
