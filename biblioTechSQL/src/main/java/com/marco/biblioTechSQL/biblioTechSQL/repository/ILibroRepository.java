package com.marco.biblioTechSQL.biblioTechSQL.repository;


import com.marco.biblioTechSQL.biblioTechSQL.model.LibroCls;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILibroRepository extends JpaRepository<LibroCls,Long> {
    @Override
    List<LibroCls> findAll(Sort sort);
    Optional<LibroCls> findByTituloContaining(String titulo);
    List<LibroCls> findByLenguaje(String lenguaje);
}
