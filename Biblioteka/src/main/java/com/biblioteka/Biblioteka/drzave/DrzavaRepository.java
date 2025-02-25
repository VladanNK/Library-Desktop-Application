package com.biblioteka.Biblioteka.drzave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrzavaRepository extends JpaRepository<Drzava, Integer> {
    @Query(value = "SELECT * FROM drzava", nativeQuery = true)
    public List<Drzava> prikaziSveDrzave();
    @Query(value = "SELECT naziv_drzave FROM drzava", nativeQuery = true)
    public List<String> prikaziNaziveDrzava();
}
