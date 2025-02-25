package com.biblioteka.Biblioteka.gradovi;

import com.biblioteka.Biblioteka.drzave.Drzava;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grad")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Grad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_grada;
    @Column(name = "naziv_grada")
    private String naziv_grada;
    @Column(name = "postanski_broj")
    private String postanski_broj;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_drzave")
    private Drzava drzava;
}
