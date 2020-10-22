package pl.coderslab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.app.model.Draft;

@Repository
public interface DraftRepository extends JpaRepository<Draft, Long> {

}
