package ca.sheridancollege.yussufa.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.yussufa.beans.Voter;
import ca.sheridancollege.yussufa.database.DatabaseAccess;

@Controller
public class VoterController {
	@Autowired
	DatabaseAccess da;
	
	private int kodosCount = 0;
	private int kangsCount = 0;
	
	List<Voter> voterList = new CopyOnWriteArrayList<Voter>();
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("vote", new Voter());
		
		return "index";
	}
	
	@PostMapping("/addVote")
	public String addVote(Model model, @ModelAttribute Voter vote) {
		
		voterList.add(vote);
		da.insertVoter(vote);
		
		model.addAttribute("vote", new Voter());
		model.addAttribute("voterList", da.getVoterList());

		
		if(vote.getCandidate().equals("Kodos") || (vote.getCandidate().charAt(vote.getCandidate().length() - 1) == 'z')) {
			kodosCount++;
		} else if(vote.getCandidate().equals("Kang")) {
			kangsCount++;
		} if (vote.getCandidate().length() > 8) {
			kangsCount+=2;
		}

		System.out.println("Kodos Count " + kodosCount);
		System.out.println("Kangs Count " + kangsCount);

		
		return "index";
	}
	
	@PostMapping("/checkResults")
	public String checkResult(Model model) {
		
		model.addAttribute("kodosCount", kodosCount);
		model.addAttribute("kangsCount", kangsCount);
		
		return "checkResults";
	}
	
}
