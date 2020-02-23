package pl.shellchuck.charity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.shellchuck.charity.entity.Institution;
import pl.shellchuck.charity.repository.InstitutionRepository;

public class InstitutionConverter implements Converter<String, Institution> {
    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public Institution convert(String source) {
        return institutionRepository.findById(Long.parseLong(source)).get();
    }
}