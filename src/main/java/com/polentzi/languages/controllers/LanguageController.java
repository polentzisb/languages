package com.polentzi.languages.controllers;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.polentzi.languages.models.Language;
import com.polentzi.languages.services.LanguageService;


import jakarta.validation.Valid;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	@RequestMapping("/languages")
	public String index(Model model,@ModelAttribute("language")Language language) {
//		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languageService.allLanguages());
		return "index.jsp";
	}
	@RequestMapping(value="/languages/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> languages = languageService.allLanguages();
			model.addAttribute("languages", languages);
			return "index.jsp";
		}else {
			languageService.createLang(language);
			return "redirect:/languages";
		}
	}
	@RequestMapping(value="/languages/{id}", method=RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLang(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}
	@RequestMapping(value="/languages/{id}/edit", method=RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLang(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	@RequestMapping(value="/languages/{id}/edit", method=RequestMethod.PUT)
	public String edit(@PathVariable("id") Long id, Model model,@Valid @ModelAttribute("language") Language language,BindingResult result,@RequestParam(value="name") String name,@RequestParam(value="creator") String creator,@RequestParam(value="version") String version) {
		if (result.hasErrors()) {
            return "redirect:/languages/{id}/edit";
        } else {
        	languageService.updateLang(id,name,creator,version);
            return "redirect:/languages";
        }
	}

	@RequestMapping("/languages/{id}/delete")
	public String destory(@PathVariable("id") Long id) {
		languageService.deleteLang(id);
		return "redirect:/languages";
	}

}