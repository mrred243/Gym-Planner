package fi.haagahelia.GymPlanner.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.GymPlanner.domain.CoachRepository;
import fi.haagahelia.GymPlanner.domain.Training;
import fi.haagahelia.GymPlanner.domain.TrainingRepository;


@Controller
public class TrainingController {

	@Autowired
	private TrainingRepository trepo;
	@Autowired
	private CoachRepository crepo;

	
	
    // Fetch all training
    @RequestMapping(value = {"/", "/traininglist"})
	public String trainingList (Model model) {
		model.addAttribute("trainings", trepo.findAll());
		return "traininglist";
	}
    
    // Add new training
    @RequestMapping(value = "/add")
    public String add(Model model){
    	model.addAttribute("training", new Training());
    	model.addAttribute("coaches", crepo.findAll());
        return "addtraining";
    }   
    
    // Save new training
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Training training, Model model){
        trepo.save(training);
        model.addAttribute("trainings", trepo.findAll());
        return "redirect:traininglist";
    }  
    
    //Delete training by id
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, Model model) {
    	trepo.deleteById(id);

        return "redirect:../traininglist";
    }
    
    //Edit training
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("training", trepo.findById(id));
    	model.addAttribute("coaches", crepo.findAll());
        return "edittraining";
    }
    
    //RESTful service to get all trainings
    @RequestMapping(value = "/trainings", method = RequestMethod.GET)
    public @ResponseBody List <Training> traningRest() {
    	return (List<Training>) trepo.findAll();
    }
    
    // RESTful service to get training by id
    @RequestMapping(value="/training/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Training> findBookRest(@PathVariable("id") Long Id) {
		return trepo.findById(Id);
	}
    
    // Login controller
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	

	
	
}
