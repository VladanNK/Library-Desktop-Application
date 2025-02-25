package com.biblioteka.Biblioteka.knjige;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Integer> {
    @Query(value = "SELECT isbn FROM knjiga", nativeQuery = true)
    List<Integer> isbnKnjige();
    @Query(value = "SELECT naziv_knjige FROM knjiga", nativeQuery = true)
    List<String> nazivKnjige();
    @Query(value = "SELECT * FROM knjiga", nativeQuery = true)
    List<Knjiga> prikaziSve();
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM knjiga WHERE isbn = :knjiga_id", nativeQuery = true)
    public void izbrisiKnjigu(int knjiga_id);
}
