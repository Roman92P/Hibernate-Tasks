package pl.coderslab.app.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.app.model.Category;
import pl.coderslab.app.repository.CategoryDao;


public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category convert(String source) {
        return categoryDao.getCategoryById(Long.parseLong(source));
    }
}
