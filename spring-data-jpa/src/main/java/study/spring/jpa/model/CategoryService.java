package study.spring.jpa.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
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
