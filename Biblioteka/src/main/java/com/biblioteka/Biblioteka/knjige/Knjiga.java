package com.biblioteka.Biblioteka.knjige;

import com.biblioteka.Biblioteka.autori.Autor;
import com.biblioteka.Biblioteka.izdavackeKuce.IzdavackaKuca;
import com.biblioteka.Biblioteka.kategorije.Kategorija;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "knjiga")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Knjiga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer isbn;
    @Column(name = "naziv_Knjige")
    private String naziv_Knjige;

    @ManyToMany
    @JoinTable(
            name = "autor_knjiga",
            joinColumns = @JoinColumn(name = "knjiga_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autor;

    @ManyToOne
    @JoinColumn(name = "id_kategorije")
    private Kategorija kategorija;

    @Column(name = "godina_Izdavanja")
    private Integer godina_Izdavanja;

    @ManyToOne
    @JoinColumn(name = "izdavacka_kuca_id")
    private IzdavackaKuca izdavackaKuca;

}
