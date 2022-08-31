package com.digitalhouse.mspost.infrastructure.services;

import com.digitalhouse.mspost.domain.models.Editor;
import com.digitalhouse.mspost.domain.repositories.EditorRepository;
import com.digitalhouse.mspost.infrastructure.shared.GenericServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditorServiceImpl extends GenericServiceImpl<Editor, Long> implements EditorServiceAPI {

    public final EditorRepository repository;

    @Override
    public JpaRepository<Editor, Long> getJpaRepository() {
        return repository;
    }
}
