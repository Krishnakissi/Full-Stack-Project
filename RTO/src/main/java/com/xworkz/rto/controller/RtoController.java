package com.xworkz.rto.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.rto.dto.RtoDto;
import com.xworkz.rto.dto.UserDto;
import com.xworkz.rto.mail.RtoMail;
import com.xworkz.rto.service.RtoService;

@Controller
@RequestMapping("/")

public class RtoController {
	@Autowired
	RtoService service;

	@Autowired
	RtoMail rtoMail;

	public RtoController() {
		System.out.println("this is RtoController");
	}

	@PostMapping("save")
	public String onSave(@ModelAttribute RtoDto dto, Model model) {

		List<RtoDto> dto2 = service.findAll();
		for (RtoDto rtodto : dto2) {
			if (rtodto.getEmail().equalsIgnoreCase(dto.getEmail())) {
				model.addAttribute("err", "Email is already exists");
			} else {
				System.out.println("Rto details");
				System.out.println("Dto" + dto);
				Set<ConstraintViolation<RtoDto>> voilations = service.onSave(dto);
				if (voilations.isEmpty()) {
					model.addAttribute("message", "No Voilation it is valid data");
					model.addAttribute("success", "Registered Successfully");
					return "signup";
				} else {
					model.addAttribute("voilations", voilations);
					return "signup";
				}
			}

		}
		return "signup";
	}

	@PostMapping("/user")
	public String onUserSave(@ModelAttribute UserDto udto, Model model) {
		System.out.println("on save method in controller");

		service.onUserSave(udto);
		System.out.println("udto" + udto);
		if (udto.getApplicationNumber() != null) {
			model.addAttribute("success",
					"Registered Successfully" + "Application Number:" + udto.getApplicationNumber());
		}

		return "userapplication";
	}

	@GetMapping("findAll")
	public String findAll(Model model) {
		List<RtoDto> dto = service.findAll();

		System.out.println(dto.toString());
		model.addAttribute("dtos", dto);
		return "findall";
	}

	@GetMapping("signin")
	public String onLogin(@RequestParam String email, @RequestParam String password, Model model) {
		RtoDto dto = service.checkLogin(email, password);
		List<UserDto> uDtos = service.searchByUserState(dto.getState());
		if (dto != null) {
			 model.addAttribute("dtos", dto.getFirstName().toUpperCase());
			model.addAttribute("Dto", dto);
			model.addAttribute("udtos", uDtos);

			return "profile";
		} else {
			model.addAttribute("err", "Invalid email or password");

		}
		return "profile";
	}

	/*
	 * @GetMapping("admin") public String adminLogin(@RequestParam String
	 * email, @RequestParam String otp, Model model) { System.out.println(email +
	 * " " + otp);
	 * 
	 * RtoDto dto = service.adminLogin(email, otp);
	 * 
	 * System.out.println(dto);
	 * 
	 * int randumNumber = (int) ((Math.random() * 90000) + 10000);
	 * 
	 * mail.sendMail(email, String.valueOf(randumNumber));
	 * 
	 * if (dto != null) {
	 * 
	 * model.addAttribute("d", dto);
	 * 
	 * List<RtoDto> dtos = service.searchByState(dto.getState());
	 * 
	 * if (!dtos.isEmpty()) {
	 * 
	 * model.addAttribute("users", dtos);
	 * 
	 * } else { model.addAttribute("err", "No applicationfrom this state"); } return
	 * "adminprofile"; }else { model.addAttribute("exp","invalid email or otp"); }
	 * return "admin";
	 * 
	 * }
	 * 
	 */

	@GetMapping("admin")
	public String adminLogin(@RequestParam String email, Model model, String admn) {
		RtoDto rtoDto = null;
		if (admn.equalsIgnoreCase("sendOtp")) {

			List<RtoDto> dtos = service.findAll();
			for (RtoDto rtoDepartmentDTO : dtos) {
				if (rtoDepartmentDTO.getEmail().equals(email)) {
					rtoDto = rtoDepartmentDTO;
					model.addAttribute("emailId", email);
				}
			}
			// System.err.println(emailId + "my beautiful otp is " + otp);
			// RTODepartmentDTO dto = service.login(emailId, otp);

			// System.out.println(dto);
			int randumNumber = (int) ((Math.random() * 90000) + 10000);
			boolean mail = rtoMail.sendMail(email, String.valueOf(randumNumber));
			// rtoDepartmentDTO = dto;
			System.err.println("my otp is" + String.valueOf(randumNumber));
			if (mail == true) {
				service.updateOtpById(rtoDto, String.valueOf(randumNumber));
				model.addAttribute("d", rtoDto);
				model.addAttribute("otp", "OTP sent");

				return "admin";
			} else 		if (admn.equalsIgnoreCase("next")) {
 {
				
			}
		}else {
			model.addAttribute("exp", "*invalid email or password");
			return "admin";

		}
		}
		// List<RTOUserDTO> dtos = userService.findState(dto.getState());
		return "adminprofile";

//			if (!dtos.isEmpty()) {
//
//				model.addAttribute("users", dtos);
//			} else {
//				model.addAttribute("err", "No applicationfrom this state");
//			}

	}

	@GetMapping("userlogin")
	public String userLogin(@RequestParam String apporphone, @RequestParam String dob, Model model) {
		UserDto udto = service.userLogin(apporphone, dob);
		if (udto != null) {
			model.addAttribute("udt", udto);
			System.out.println(udto);
			return "userprofile";
		} else {
			model.addAttribute("invalid", "Invalid credentials");
			return "userlogin";
			}
	}

	@GetMapping("seachbystate")
	public String searchByState(@RequestParam String state, Model model) {
		List<RtoDto> dto = service.searchByState(state);
		model.addAttribute("state", dto);
		return "searchbystate";
	}

	@GetMapping("userState")
	public String userState(@RequestParam String state, Model model) {
		System.out.println("search by state......");
		List<UserDto> udto = service.searchByUserState(state);
		model.addAttribute("ustate", udto);
		System.out.println(udto);
		return "profile";
	}

	@GetMapping("updateUserStatus")
	public String userStatus(@RequestParam int id, Model model) {
		boolean update = service.updateById(id);
		if (update == true) {
			model.addAttribute("updateMessage", "Updated successfully");
			return "profile";
		} else {
			model.addAttribute("updateMessage", "Not Updated");
			return "profile";

		}

	}

	@GetMapping("updateOtp")
	public String up(@RequestParam int id, Model model) {
		boolean update = service.updateById(id);
		if (update == true) {
			model.addAttribute("updateMessage", "Updated successfully");
			return "profile";
		} else {
			{
				model.addAttribute("updateMessage", "Not Updated");
				return "profile";
			}
		}
	}
	
	@GetMapping("pass")
	public String forgotPass(@RequestParam String email,@RequestParam String otp, Model model,String navi) {
		RtoDto rtoDto = null;
	if(navi.equalsIgnoreCase("SendOtp")) {
		List<RtoDto> dtos = service.findAll();
		for (RtoDto rtodto1 : dtos) {
			if (rtodto1.getEmail().equals(email)) {
				rtoDto = rtodto1;
				model.addAttribute("emailId", email);
				System.out.println("********"+rtoDto);
			}
		}
		// System.err.println(emailId + "my beautiful otp is " + otp);
		// RTODepartmentDTO dto = service.login(emailId, otp);
	// System.out.println(dto);
		int randumNumber = (int) ((Math.random() * 90000) + 10000);
		boolean mail = rtoMail.sendMail(email, String.valueOf(randumNumber));
		// rtoDepartmentDTO = dto;
		System.err.println("my otp is" + String.valueOf(randumNumber));
		if (mail == true/* && rtoDto != null */) {
			service.updateOtpById(rtoDto, String.valueOf(randumNumber));
			model.addAttribute("dt", rtoDto); 
			System.out.println(rtoDto);
			model.addAttribute("otp", "OTP sent");
			return "forgotpassword";
		}
			else {
				model.addAttribute("exp", "*invalid email or password");
						return "forgotpassword";
				}
			}else if (navi.equalsIgnoreCase("next")) {
				RtoDto dto=service.forgotPass(email, otp);
				System.err.println("dto"+dto);
				if(dto!=null)
				 {
					model.addAttribute("dt", dto); 
					return "newpassword"; 
					}else {
				  model.addAttribute("message", "Otp is invalid");
				
			System.out.println(rtoDto);
	return "newpassword";
		}
			}
	return "newpassword";
	}
				

	/*@GetMapping("updateOtp")
	public String updateOtp(@ModelAttribute RtoDto rtoDto,@RequestParam String otp,Model model) {
		boolean update=		ser.updateOtpById(rtoDto,otp);

		if(update==true) {
			model.addAttribute("updateMessage", "Updated successfully");
			return "adminprofile";
		}else {
			{
				model.addAttribute("updateMessage", "Not Updated");
				return "adminprofile";
			}
		}*/
		
		

	
}
