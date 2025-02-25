package com.biblioteka.Biblioteka.autori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    @Query(value = "SELECT * FROM autor", nativeQuery = true)
    List<Autor> prikaziSveAutore();
    @Query(value = "SELECT id_autora FROM autor", nativeQuery = true)
    List<Integer> prikaziSveAutoreId();
    @Query(value = "SELECT ime_autora, prezime_autora, godine_autora FROM autor", nativeQuery = true)
    List<String> prikaziSveAutoreOsimID();
}
