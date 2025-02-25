package com.biblioteka.Biblioteka.izdavackeKuce;

import com.biblioteka.Biblioteka.gradovi.Grad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "izdavacka_kuca")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IzdavackaKuca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer izdavacka_kuca_id;
    @Column(name = "naziv_izdavacke_kuce")
    private String naziv_izdavacke_kuce;

    @ManyToOne
    @JoinColumn(name = "id_grad")
    private Grad grad;
}
