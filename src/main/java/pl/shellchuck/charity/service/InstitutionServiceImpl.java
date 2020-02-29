package pl.shellchuck.charity.service;

import org.springframework.stereotype.Service;
import pl.shellchuck.charity.entity.Institution;
import pl.shellchuck.charity.repository.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    private InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> listInstitutions() {
        return institutionRepository.findAll();
    }

}
