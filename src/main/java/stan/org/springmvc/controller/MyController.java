package stan.org.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stan.org.springmvc.model.Automobile;
import stan.org.springmvc.service.AutomobileService;

@Controller
@RequestMapping("/")
public class MyController {

	@Autowired
	AutomobileService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * List all existing Automobiles.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listAutomobiles(ModelMap model) {

		List<Automobile> automobiles = service.findAllAutomobiles();
		model.addAttribute("automobiles", automobiles);
		return "allautomobiles";
	}

	/*
	 * Add a new Automobile.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newAutomobile(ModelMap model) {
		Automobile automobile = new Automobile();
		model.addAttribute("automobile", automobile);
		model.addAttribute("edit", false);
		return "registration";
	}

	/*
	 * Handling POST request for validating the user input and saving Automobile in database.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveAutomobile(@Valid Automobile automobile, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}
		
				
		service.saveAutomobile(automobile);

		model.addAttribute("success", "Automobile " + automobile.getName() + " registered successfully");
		return "success";
	}


	/*
	 * Provide the existing Automobile for updating.
	 */
	@RequestMapping(value = { "/edit-{id}-automobile" }, method = RequestMethod.GET)
	public String editAutomobile(@PathVariable Integer id, ModelMap model) {
		Automobile automobile = service.findById(id);
		model.addAttribute("automobile", automobile);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	/*
	 * Handling POST request for validating the user input and updating Automobile in database.
	 */
	@RequestMapping(value = { "/edit-{id}-automobile" }, method = RequestMethod.POST)
	public String updateAutomobile(@Valid Automobile automobile, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "registration";
		}

		
		service.updateAutomobile(automobile);

		model.addAttribute("success", "Automobile " + automobile.getName()	+ " updated successfully");
		return "success";
	}

	
	/*
	 * Delete an Automobile by it's CODE value.
	 */
	@RequestMapping(value = { "/delete-{id}-automobile" }, method = RequestMethod.GET)
	public String deleteAutomobile(@PathVariable Integer id) {
		service.deleteAutomobileById(id);
		return "redirect:/list";
	}

}
