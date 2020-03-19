package pl.shellchuck.charity.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import pl.shellchuck.charity.converter.CategoryConverter;
import pl.shellchuck.charity.converter.InstitutionConverter;
import pl.shellchuck.charity.entity.Category;
import pl.shellchuck.charity.entity.Donation;
import pl.shellchuck.charity.entity.Institution;
import pl.shellchuck.charity.service.CategoryServiceImpl;
import pl.shellchuck.charity.service.DonationServiceImpl;
import pl.shellchuck.charity.service.InstitutionServiceImpl;
import pl.shellchuck.charity.service.UserServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = DonationController.class)
public class DonationControllerTest {

    @MockBean
    private CategoryServiceImpl categoryService;
    @MockBean
    private DonationServiceImpl donationService;
    @MockBean
    private InstitutionServiceImpl institutionService;
    @MockBean
    private UserServiceImpl userService;

    private List<Institution> institutions;
    private List<Category> categories;
    private Donation donation = new Donation();
    private final String FORM_ACTION_VIEW = "form";
    private final String CONFIRM_ACTION_VIEW = "form-confirmation";

    private MockMvc mockMvc;
    private WebApplicationContext webApplicationContext;

    @Autowired
    public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    private CategoryConverter categoryConverter;
    private InstitutionConverter institutionConverter;

    @Before
    public void setUp() {

        categoryConverter = new CategoryConverter();
        institutionConverter = new InstitutionConverter();
        FormattingConversionService cs = new FormattingConversionService();
        cs.addConverter(categoryConverter);
        cs.addConverter(institutionConverter);

        mockMvc = webAppContextSetup(webApplicationContext).build();
        Category clothes = new Category();
        clothes.setName("clothes");
        Category toys = new Category();
        toys.setName("toys");
        categories = Arrays.asList(clothes, toys);
        when(categoryService.listCategories()).thenReturn(categories);
        Institution charity = new Institution();
        charity.setName("charity");
        Institution fromHeart = new Institution();
        fromHeart.setName("fromHeart");
        institutions = Arrays.asList(charity, fromHeart);
        when(institutionService.listInstitutions()).thenReturn(institutions);
        when(donationService.addDonation(donation)).thenReturn(donation);
    }

    @Test
    public void test_addAction_in_fillDonation_contains_modelForm() throws Exception {
        mockMvc.perform(get("/donation/add"))
                .andExpect(model().attributeExists("donation"))
                .andExpect(model().attribute("donation", donation))
                .andExpect(model().attributeExists("allCategories"))
                .andExpect(model().attribute("allCategories", categories))
                .andExpect(model().attribute("allCategories", hasSize(2)))
                .andExpect(model().attribute("allCategories", hasItem(anyOf(hasProperty("name"), is("toys")))))
                .andExpect(model().attributeExists("allInstitutions"))
                .andExpect(model().attribute("allInstitutions", institutions))
                .andExpect(model().attribute("allInstitutions", hasSize(2)))
                .andExpect(model().attribute("allInstitutions", hasItem(anyOf(hasProperty("name"), is("fromHeart")))))
                .andExpect(status().isOk())
                .andExpect(view().name(FORM_ACTION_VIEW))
                .andDo(print());
    }

    @Test
    public void when_save_valid_data_in_addAction() throws Exception {
        mockMvc.perform(post("/donation/add")
                .content(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("id", String.valueOf(1L))
                .param("city", "Katowice")
                .param("quantity", String.valueOf(6))
                .param("street", "Francuska")
                .param("zipCode", "41-200")
                .param("pickUpDate", String.valueOf(LocalDate.now()))
                .param("pickUpTime", String.valueOf(LocalTime.of(12, 30)))
                .param("pickUpComment", "is it ok?"))
                .andExpect(status().isOk())
                .andExpect(view().name(CONFIRM_ACTION_VIEW))
                .andDo(print());
    }

}

