package com.uncapped.uncappedmvc.controllers;


import com.uncapped.uncappedmvc.models.Style;
import com.uncapped.uncappedmvc.models.data.StyleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("Style")
public class StyleController {

    @Autowired
    private StyleDao styleDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("styles", styleDao.findAll());
        model.addAttribute("title", "Styles");

        return "style/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddStyleForm(Model model) {
        model.addAttribute("title", "Add Style");
        model.addAttribute(new Style());
        return "style/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddStyleForm(@ModelAttribute @Valid Style newStyle,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Style");
            return "category/add";
        }

        styleDao.save(newStyle);
        return "redirect:";
    }
}
