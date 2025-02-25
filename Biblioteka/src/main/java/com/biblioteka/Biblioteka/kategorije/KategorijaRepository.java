package com.biblioteka.Biblioteka.kategorije;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija, Integer> {
    @Query(value = "SELECT * FROM kategorija", nativeQuery = true)
    List<Kategorija> sveKategorije();
    @Query(value = "SELECT id_kategorije FROM kategorija", nativeQuery = true)
    List<Integer> idKategorije();
    @Query(value = "SELECT naziv_Kategorije FROM kategorija", nativeQuery = true)
    List<String> nazivKategorije();
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM kategorija WHERE id_kategorije = :kategorija_id", nativeQuery = true)
    public void izbrisiKategoriju(int kategorija_id);
}
