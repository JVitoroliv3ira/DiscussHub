package api.contracts;

import api.exceptions.BadRequestException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICrudService<E extends IEntity<T>, T, R extends JpaRepository<E, T>> {
    R getRepository();

    String getEntityNotFoundErrorMessage();

    default E create(E entity) {
        entity.setId(null);
        return this.getRepository().save(entity);
    }

    default E read(T id) throws RuntimeException {
        return this.getRepository()
                .findById(id)
                .orElseThrow(() -> new BadRequestException(this.getEntityNotFoundErrorMessage()));
    }

    default E update(E entity) {
        if (Boolean.TRUE.equals(this.getRepository().existsById(entity.getId()))) {
            return this.getRepository().save(entity);
        }

        throw new BadRequestException(this.getEntityNotFoundErrorMessage());
    }

    default void delete(T id) {
        if (Boolean.FALSE.equals(this.getRepository().existsById(id))) {
            throw new BadRequestException(this.getEntityNotFoundErrorMessage());
        }

        this.getRepository().deleteById(id);
    }
}
