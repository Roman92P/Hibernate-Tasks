package pl.coderslab.app.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.model.Article;
import pl.coderslab.app.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;


    public void saveAuthor(Author author){
        if(String.valueOf(author.getId())==null){
            entityManager.persist(author);
        }else{
            entityManager.merge(author);
        }
    }
    public void deleteAuthor(Author author){
        entityManager.remove(entityManager.contains(author)?
                author: entityManager.merge(author));
    }
    public void updateAuthor(Author author){
        entityManager.merge(author);
    }
    public List<Author> getAllAuthors(){
        Query authors = entityManager.createQuery("SELECT t FROM Author t");
        List resultList = authors.getResultList();
        return resultList;
    }
    public Author getAuthorById(long id){
        return entityManager.find(Author.class, id);
    }

}
