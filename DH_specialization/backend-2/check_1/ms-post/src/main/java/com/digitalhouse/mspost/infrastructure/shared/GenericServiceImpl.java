package com.digitalhouse.mspost.infrastructure.shared;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl<E, ID extends Serializable> implements GenericServiceAPI<E, ID> {
    @Override
    public E save(E entity) {
        return getJpaRepository().save(entity);
    }

    @Override
    public void delete(ID id) {
        getJpaRepository().deleteById(id);
    }

    @Override
    public E getOne(ID id) {
        //Optional Java8
        Optional<E> optional = getJpaRepository().findById(id);
        //E or Throw
        return optional.orElse(null);
    }

    @Override
    public List<E> getAll() {
        return getJpaRepository().findAll();
    }

    public abstract JpaRepository<E, ID> getJpaRepository();
}
