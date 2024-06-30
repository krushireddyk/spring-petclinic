package org.springframework.samples.petclinic.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import javax.validation.Valid;

@Controller
class UserController {

	@Autowired
	private UserRepository users;

	@GetMapping("/user/register.html")
	public String initRegisterForm(Map<String, Object> model) {
		model.put("user", new User());
		return "user/register";
	}

	@PostMapping("/user/register.html")
	public String processCreationForm(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user/register";
		}
		else {
			this.users.save(user);
			return "redirect:/users/" + user.getId();
		}
	}

	@GetMapping("/users/{id}")
	public ModelAndView showOwner(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("user/userDetails");
		User user = this.users.findById(id);
		mav.addObject(user);
		return mav;
	}

}
