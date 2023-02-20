package study.spring.jpa.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private CategoryRepository categoryRepository;
    private Long PARENT_CATEGORY_ID;
    
    @BeforeEach
    void init() {
        Category parentCategory = categoryRepository.saveAndFlush(new Category("부모카테고리", null));
        PARENT_CATEGORY_ID = parentCategory.getId();
    }

    @Test
    void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 자식 등록
        executorService.execute(() -> {
            categoryService.create("자식카테고리", PARENT_CATEGORY_ID);
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 부모 삭제
        executorService.execute(() -> {
            categoryService.delete(PARENT_CATEGORY_ID);
        });

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<Category> categories = categoryRepository.findAll();
        log.info("categories: " + categories);
    }
}