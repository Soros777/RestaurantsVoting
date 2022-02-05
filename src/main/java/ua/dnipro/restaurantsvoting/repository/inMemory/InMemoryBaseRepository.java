package ua.dnipro.restaurantsvoting.repository.inMemory;

import ua.dnipro.restaurantsvoting.model.AbstractBaseEntity;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static ua.dnipro.restaurantsvoting.model.AbstractBaseEntity.START_SEQ;

public class InMemoryBaseRepository<T extends AbstractBaseEntity> {
        static final AtomicInteger counter = new AtomicInteger(START_SEQ);
        final Map<Integer, T> map = new ConcurrentHashMap<>();

        public T save(T entity) {
            Objects.requireNonNull(entity, "Entity must not be null");
            if(entity.isNew()) {
                entity.setId(counter.incrementAndGet());
                map.put(entity.getId(), entity);
                return entity;
            }
            return map.computeIfPresent(entity.getId(), (id, oldT) -> entity);
        }

        public boolean delete(int id) {
            return map.remove(id) != null;
        }

        public T get(int id) {
            return map.get(id);
        }

        public Collection<T> getAll() {
            return map.values();
        }
}
