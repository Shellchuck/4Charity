package pl.shellchuck.charity.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.shellchuck.charity.entity.Role;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryTest {

    private RoleRepository roleRepository;
    private TestEntityManager testEntityManager;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setTestEntityManager(TestEntityManager testEntityManager) {
        this.testEntityManager = testEntityManager;
    }

    @Test
    public void given_name_when_findByName_then_returnRole() {
        //given
        Role role = new Role();
        role.setName("ROLE_STAKEHOLDER");
        testEntityManager.persist(role);
        //when
        Role roleStakeholder = roleRepository.findByName("ROLE_STAKEHOLDER");
        //then
        assertEquals(role.getName(), roleStakeholder.getName());
    }

    @Test
    public void given_nameNotPersisted_when_findByName_then_returnNull() {
        //given
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_STAKEHOLDER");
        //when
        Role role_stakeholder = roleRepository.findByName("ROLE_STAKEHOLDER");
        //then
        assertNull(role_stakeholder);
    }

    @Test(expected = NoSuchElementException.class)
    public void given_id_when_FindById_then_throwNoSuchElement() {
        //given
        Long categoryId = 1L;
        //when
        roleRepository.findById(categoryId).get();
    }

}
