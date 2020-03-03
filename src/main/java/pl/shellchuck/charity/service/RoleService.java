package pl.shellchuck.charity.service;

import pl.shellchuck.charity.entity.Role;

public interface RoleService {

    Role findRoleByName(String name);
}
