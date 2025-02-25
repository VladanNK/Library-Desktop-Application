package com.biblioteka.Biblioteka.izdavackeKuce;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IzdavackaKucaRepository extends JpaRepository<IzdavackaKuca, Integer> {
    @Query(value = "SELECT * FROM izdavacka_kuca", nativeQuery = true)
    public List<IzdavackaKuca> podaciIzdavackihKuca();
    @Query(value = "SELECT naziv_izdavacke_kuce, id_grada FROM izdavacka_kuca", nativeQuery = true)
    public List<String> podaciBezId();
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM izdavacka_kuca WHERE izdavacka_kuca_id = :id_izdavacke_kuce", nativeQuery = true)
    public void izbrisiIK(int id_izdavacke_kuce);
}
