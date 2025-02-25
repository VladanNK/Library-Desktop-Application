package com.biblioteka.Biblioteka.biblioteke;

import com.biblioteka.Biblioteka.gradovi.Grad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "biblioteka")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Biblioteka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_biblioteke;
    @Column(name = "naziv_biblioteke")
    private String naziv_biblioteke;
    @Column(name = "adresa_biblioteke")
    private String adresa_biblioteke;

    @ManyToOne
    @JoinColumn(name = "id_grada")
    private Grad grad;
}
