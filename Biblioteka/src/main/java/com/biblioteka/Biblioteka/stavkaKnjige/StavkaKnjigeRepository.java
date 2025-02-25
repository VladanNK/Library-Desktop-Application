package com.biblioteka.Biblioteka.stavkaKnjige;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StavkaKnjigeRepository extends JpaRepository<StavkaKnjige, Integer> {
    @Query(value = "SELECT * FROM stavka_knjiga", nativeQuery = true)
    public List<StavkaKnjige> stavkaKnjigaPodaci();
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM stavka_knjiga WHERE id_stavka_knjiga = :stavka_knjiga_id", nativeQuery = true)
    public void izbrisiStavkaKnjiga(int stavka_knjiga_id);
}
