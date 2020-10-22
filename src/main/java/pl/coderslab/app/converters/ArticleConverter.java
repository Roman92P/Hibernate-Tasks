//package pl.coderslab.app.converters;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.converter.Converter;
//import pl.coderslab.app.model.Article;
//import pl.coderslab.app.repository.ArticleDao;
//
//public class ArticleConverter implements Converter<String, Article> {
//    @Autowired
//    ArticleDao articleDao;
//    @Override
//    public Article convert(String s) {
//        return articleDao.getArtickleById(Long.parseLong(s));
//    }
//}
