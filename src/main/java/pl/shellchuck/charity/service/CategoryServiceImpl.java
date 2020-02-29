package pl.shellchuck.charity.service;

import org.springframework.stereotype.Service;
import pl.shellchuck.charity.entity.Category;
import pl.shellchuck.charity.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

}
