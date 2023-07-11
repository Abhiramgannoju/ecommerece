package login.trail.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import login.trail.model.books;

public interface BooksRepo extends JpaRepository<books,Integer> {

	Optional<books> findById(Long bookId);

	

	List<books> findAllBycategory_id(int id);

}
