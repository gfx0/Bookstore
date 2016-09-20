package fi.haagahelia.jani.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookstoreController {
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String greetingForm(Model model) {
    	//model.addAttribute("message", new Message());
        return "hello";
    }
}


