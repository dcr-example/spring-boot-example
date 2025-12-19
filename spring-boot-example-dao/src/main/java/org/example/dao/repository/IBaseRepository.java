package org.example.dao.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface IBaseRepository<T, ID>  extends Repository<T, ID> {

    <S extends T> S save(S entity);

    <S extends T> List<S> saveAll(Iterable<S> entities);

    boolean existsById(ID id);

    void deleteById(ID id);

    void deleteAllById(Iterable<? extends ID> ids);

    List<T> findAllById(Iterable<ID> ids);

    Optional<T> findById(ID id);
}
