package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InstitutionServiceImpl implements InstitutionService{

    private final InstitutionRepository institutionRepository;


    @Override
    public void saveInstitution(Institution institution) {

    }

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }
}
