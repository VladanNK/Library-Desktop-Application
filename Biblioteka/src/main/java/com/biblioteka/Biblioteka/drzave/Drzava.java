package com.biblioteka.Biblioteka.drzave;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "drzava")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drzava {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_drzave;
    @Column(name = "naziv_drzave")
    private String naziv_drzave;
}
