package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Institution;

import java.util.List;

public interface InstitutionService {
    
    void saveInstitution(Institution institution);


    List<Institution> findAll();
}
