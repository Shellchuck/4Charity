package pl.shellchuck.charity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.shellchuck.charity.entity.Category;
import pl.shellchuck.charity.repository.CategoryRepository;

public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category convert(String source) {
        return categoryRepository.findById(Long.parseLong(source)).get();
    }
}