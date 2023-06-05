package com.polentzi.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.polentzi.languages.models.Language;
import com.polentzi.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	public List<Language> allLanguages(){
		return languageRepo.findAll();
	}
	public Language findLang(Long id) {
		Optional<Language> optionalLang = languageRepo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	public Language createLang(Language language) {
		return languageRepo.save(language);
	}
	public Language updateLang(Long id, String name, String creator, String version) {
		Optional<Language> optionalLang = languageRepo.findById(id);
		if(optionalLang.isPresent()) {
			Language updateLanguage = optionalLang.get();
			// Update fields
			updateLanguage.setName(name);
			updateLanguage.setCreator(creator);
			updateLanguage.setVersion(version);
			
			return languageRepo.save(updateLanguage);
		} else {
			return null;
		}
	}
	public void deleteLang(Long id) {
		languageRepo.deleteById(id);
	
    }

}
