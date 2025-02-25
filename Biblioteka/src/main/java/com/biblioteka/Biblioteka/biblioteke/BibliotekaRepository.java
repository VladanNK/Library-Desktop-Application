package com.biblioteka.Biblioteka.biblioteke;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BibliotekaRepository extends JpaRepository<Biblioteka, Integer> {
    @Query(value = "SELECT * FROM biblioteka", nativeQuery = true)
    public List<Biblioteka> prikaziSve();
    @Query(value = "SELECT id_biblioteke FROM biblioteka", nativeQuery = true)
    public List<Integer> sveIdBiblioteke();
    @Query(value = "SELECT naziv_biblioteke, adresa_biblioteke FROM biblioteka", nativeQuery = true)
    public List<String> sveBibliotekeOsimID();
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM biblioteka WHERE id_biblioteke = :id_biblioteke2", nativeQuery = true)
    public void obrisiBiblioteku(int id_biblioteke2);
}
