package com.biblioteka.Biblioteka.gradovi;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradRepository extends JpaRepository<Grad, Integer> {
    @Query(value = "SELECT * FROM grad", nativeQuery = true)
    public List<Grad> showAllCities();
    @Query(value = "SELECT naziv_grada, id_drzave FROM grad", nativeQuery = true)
    public List<String> showNameCities();
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM grad WHERE id_grada = :idGrada", nativeQuery = true)
    public void izbrisiGrad(int idGrada);
}
