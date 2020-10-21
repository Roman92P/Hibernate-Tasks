package pl.coderslab.app.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

//    zapis encji
//    usuwanie encji
//    edycję encji
@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveArticle(Article article){
        if(String.valueOf(article.getId())==null){
            entityManager.persist(article);
        }else{entityManager.merge(article);}

    }

    public void deleteArticle(Article article){
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }

    public void updateArticle(Article article){
        entityManager.merge(article);
    }

    public List<Article> getAllArticles(){
        Query articles = entityManager.createQuery("SELECT a FROM Article a");
        List resultList = articles.getResultList();
        return resultList;
    }
    public Article getArtickleById(long id){
        return entityManager.find(Article.class, id);
    }
}
