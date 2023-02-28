package study.spring.jpa.category.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.jpa.category.dto.CategoryInfo;
import study.spring.jpa.category.model.Category;
import study.spring.jpa.category.model.CategoryRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<CategoryInfo> findCategoriesById(Long id) {
        List<Category> rootCategories;

        if (id != null) {
            rootCategories = categoryRepository.findAllChildren(id, true);
        } else {
            rootCategories = categoryRepository.findRootCategories(true);
        }

        return rootCategories.stream()
                .map(category -> CategoryInfo.create(category, findChildren(category)))
                .collect(Collectors.toList());
    }

    private List<CategoryInfo> findChildren(Category category) {
        List<Category> children = categoryRepository.findAllChildren(category.getId(), true);

        return children.stream()
                .map(child -> CategoryInfo.create(child, findChildren(child)))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        log.info("[delete] 시작");
        categoryRepository.deleteById(id);
        log.info("[delete] 끝");
    }

    @Transactional
    public void create(String name, Long parentId) {
        log.info("[create] 시작");
        Category parentCategory = categoryRepository.findById(parentId)
                .orElseThrow(EntityNotFoundException::new);

        Category category = new Category(name, parentCategory);

        categoryRepository.save(category);
        log.info("카테고리 저장완료");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("[create] 끝");
    }
}
