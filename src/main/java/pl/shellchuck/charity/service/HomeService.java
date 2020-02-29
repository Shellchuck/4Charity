package pl.shellchuck.charity.service;

import pl.shellchuck.charity.entity.Institution;
import java.util.List;

public interface HomeService {

    int giftsSum();

    int donationsSum();

    List<Institution> listInstitutions();
}
