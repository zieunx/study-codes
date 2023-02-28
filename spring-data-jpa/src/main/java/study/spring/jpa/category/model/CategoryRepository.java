package study.spring.jpa.category.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT category FROM Category category WHERE category.parentCategory.id = :id")
    List<Category> findChildren(@Param(value = "id") Long id);

    @Query("SELECT category FROM Category category WHERE category.parentCategory.id = :id AND category.displayYn = :displayYn")
    List<Category> findAllChildren(@Param(value = "id") Long id,
                                   @Param(value = "displayYn") boolean displayYn);

    @Query("SELECT category FROM Category category where category.parentCategory.id is null AND category.displayYn = :displayYn")
    List<Category> findRootCategories(@Param(value = "displayYn") boolean displayYn);
}
