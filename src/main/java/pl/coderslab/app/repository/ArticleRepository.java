package pl.coderslab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.app.model.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    @Query(value = "SELECT * FROM Article join article_category on Article.id = article_category.article_id where category_id=?",
    nativeQuery = true)
    List<Article> getArticleByCategoryListContaining(long id);
}
