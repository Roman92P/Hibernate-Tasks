//package pl.coderslab.app.model;
//
//import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CategoryValidateConstraint implements DefaultGroupSequenceProvider<Article> {
//    @Override
//    public List<Class<?>> getValidationGroups(Article article) {
//        List<Class<?>> defaultGroupSequence = new ArrayList<>();
//        defaultGroupSequence.add(Article.class);
//        defaultGroupSequence.add(CategoryGroup.class);
//        return defaultGroupSequence;
//    }
//}
