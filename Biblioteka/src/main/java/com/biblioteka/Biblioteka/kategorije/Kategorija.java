package com.biblioteka.Biblioteka.kategorije;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kategorija")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kategorija {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_kategorije;
    @Column(name = "naziv_kategorije")
    private String naziv_kategorije;
}
