package numberseries.findnextnumberinseries.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import numberseries.findnextnumberinseries.entity.Sixnums;
import numberseries.findnextnumberinseries.entity.nextnumDetails;
import numberseries.findnextnumberinseries.service.CustomerService;


@Controller
@RequestMapping(value="/number",method=RequestMethod.GET)
public class NumberController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/showFormForEnteringIntegers")
	public String showFormForEnteringIntegers(Model theModel) {
		
		Sixnums theNums=new Sixnums();
		theModel.addAttribute("sixnums", theNums);
		return "number-form";
	}
	
	@SuppressWarnings("null")
	@PostMapping("/displayNumbers")
	public String displayNumbers(@RequestParam (name="moreInfo",required=false) String option,Sixnums theNums, ModelMap model) throws InterruptedException {
		
		theNums.setnextnum(customerService.nextNumInSeries(theNums.getNum1(),theNums.getNum2(),theNums.getNum3(),theNums.getNum4(),theNums.getNum5(),theNums.getNum6(),0));
	
		model.addAttribute("num1", theNums.getNum1());
		model.addAttribute("num2", theNums.getNum2());
		model.addAttribute("num3", theNums.getNum3());
		model.addAttribute("num4", theNums.getNum4());
		model.addAttribute("num5", theNums.getNum5());
		model.addAttribute("num6", theNums.getNum6());
		if (theNums.getnextnum().equals(null)) {
			model.addAttribute("nextnum", "99999.0");
		}		
		else {
			model.addAttribute("nextnum", theNums.getnextnum().getNextNum());
			model.addAttribute("seriesname", theNums.getnextnum().getNameOfSeries());
			model.addAttribute("logicalformula", theNums.getnextnum().getLogicalFlow());
		}		
		
		if (option != null && !option.isEmpty() && option.equalsIgnoreCase("NextTwoTerms")) {
			model.addAttribute("option","NextTwoTerms");
		}		
		if (option != null && !option.isEmpty() && option.equalsIgnoreCase("NameOfSeries")) {
			model.addAttribute("option","NameOfSeries");
		}
		if (option != null && !option.isEmpty() && option.equalsIgnoreCase("LogicalFlow")) {
			model.addAttribute("option","LogicalFlow");
		}
		return "display-numbers";
	}
}
