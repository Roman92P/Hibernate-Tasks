package pl.coderslab.app.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.model.Article;
import pl.coderslab.app.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveCategory(Category category){
       if(String.valueOf(category.getId())==null){
           entityManager.persist(category);
       }else{
           entityManager.merge(category);
       }
    }

    public void deleteCategory(Category category){
        entityManager.remove(entityManager.contains(category)?
                category: entityManager.merge(category));
    }
    public void updateCategory(Category category){
        entityManager.merge(category);
    }

    public List<Category> getAllCategories(){
        Query categories = entityManager.createQuery("SELECT c FROM Category c");
        List resultList = categories.getResultList();
        return resultList;
    }

    public Category getCategoryById(long id) {
         return entityManager.find(Category.class, id);
    }
}
