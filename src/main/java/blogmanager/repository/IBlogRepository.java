package blogmanager.repository;

import blogmanager.model.Blog;
import blogmanager.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByNameContaining (String name, Pageable pageable);
    Page<Blog> findAllByCategory (Category category, Pageable pageable);
    Page<Blog> findAllByOrderByDate(Pageable pageable);
    Page<Blog> findAllByOrderByName(Pageable pageable);
    Page<Blog> findAllByOrderById(Pageable pageable);
    Iterable<Blog> findAllByCategory (Category category);
    Iterable<Blog> findAllByNameContaining(String name);

    @Query(value = "select * from blog limit ?, 3", nativeQuery = true)
    Iterable<Blog> getNext3Blog(int row);

    @Query(value = "select * from blog order by id limit 3 ", nativeQuery = true)
    Iterable<Blog> getTop3();
}
