package perscholas.SpringCRUDDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import perscholas.SpringCRUDDemo.model.Tutorial;

import java.util.List;
import java.util.Optional;
@RepositoryRestResource(path = "learningtutorials")
public interface TutorialRepository extends JpaRepository<Tutorial, Long>
// Tutorial → Entity type and Long --> primary key
{
    // findByPublished is a custom method()
    List<Tutorial> findByPublished(boolean published);
}
