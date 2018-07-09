package com.uncapped.uncappedmvc.controllers;


import com.uncapped.uncappedmvc.models.Beer;
import com.uncapped.uncappedmvc.models.Style;
import com.uncapped.uncappedmvc.models.data.BeerDao;
import com.uncapped.uncappedmvc.models.data.StyleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("beer")
public class BeerController {

    @Autowired
    private BeerDao beerDao;

    @Autowired
    private StyleDao styleDao;


    @RequestMapping(value= "")
    public String index(Model model) {

        model.addAttribute("beers", beerDao.findAll());
        model.addAttribute("title", "My List of Beers");

        return "beer/index";
    }

    @RequestMapping(value = "check-in", method = RequestMethod.GET)
    public String displayCheckInForm(Model model) {
        model.addAttribute("title", "Check in New Beer");
        model.addAttribute(new Beer());
        model.addAttribute("styles", styleDao.findAll());
        return "beer/check-in";
    }

    @RequestMapping(value = "check-in", method = RequestMethod.POST)
    public String processCheckInForm(@ModelAttribute @Valid Beer newBeer,
                                     Errors errors, Model model, @RequestParam int styleId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Check in New Beer");
            model.addAttribute("styles", styleDao.findAll());
            return "beer/check-in";
        }
        Style s = styleDao.findOne(styleId);
        newBeer.setStyle(s);
        beerDao.save(newBeer);
        return "redirect:";
    }

}
