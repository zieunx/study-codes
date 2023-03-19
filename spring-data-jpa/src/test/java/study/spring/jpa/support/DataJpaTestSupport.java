package study.spring.jpa.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("test")
@DataJpaTest
@Transactional
public class DataJpaTestSupport {
    @Autowired
    private EntityManager entityManager;

    protected <T> T save(T entity) {
        entityManager.persist(entity);
        flushAndClearPersistentContext();
        return entity;
    }

    protected <T> Iterable<T> saveAll(Iterable<T> entities) {
        for (T entity : entities) {
            entityManager.persist(entity);
        }
        flushAndClearPersistentContext();
        return entities;
    }

    protected void flushAndClearPersistentContext() {
        entityManager.flush();
        entityManager.clear();
    }
}
