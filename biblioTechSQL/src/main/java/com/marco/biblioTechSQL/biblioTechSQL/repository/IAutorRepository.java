package com.marco.biblioTechSQL.biblioTechSQL.repository;

import com.marco.biblioTechSQL.biblioTechSQL.DTO.TituloLibroDTO;
import com.marco.biblioTechSQL.biblioTechSQL.model.AutorCls;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAutorRepository extends JpaRepository<AutorCls, Long> {
    Optional<AutorCls> findByNombre(String nombre);

    @Override
    List<AutorCls> findAll(Sort sort);

    @Query("SELECT l FROM LibroCls l JOIN l.autor a WHERE a.nombre = :nombre")
    List<TituloLibroDTO> findLibrosByAutorNombre(@Param("nombre") String nombre);

    @Query("SELECT a FROM AutorCls a " +
            "WHERE CAST(a.anhoNacimiento AS int) <= :anio " +
            "AND (a.anhoMuerte IS NULL OR CAST(a.anhoMuerte AS int) > :anio)")
    List<AutorCls> findAutoresVivosEnAnio(@Param("anio") int anio);

}
