package pl.coderslab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.app.model.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
