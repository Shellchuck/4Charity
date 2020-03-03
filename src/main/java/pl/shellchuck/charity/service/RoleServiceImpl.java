package pl.shellchuck.charity.service;

import org.springframework.stereotype.Service;
import pl.shellchuck.charity.entity.Role;
import pl.shellchuck.charity.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }


}
