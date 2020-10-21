package pl.coderslab.app.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.app.model.Author;
import pl.coderslab.app.repository.AuthorDao;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String source) {
        return authorDao.getAuthorById(Long.parseLong(source));
    }
}
