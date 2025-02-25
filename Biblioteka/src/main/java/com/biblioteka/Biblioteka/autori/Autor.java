package com.biblioteka.Biblioteka.autori;


import com.biblioteka.Biblioteka.knjige.Knjiga;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "autor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
    @Id
    @Column(name = "id_autora")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_autora;
    @Column(name = "ime_autora")
    private String ime_autora;
    @Column(name = "prezime_autora")
    private String prezime_autora;
    @Column(name = "godine_autora")
    private Integer godine_autora;

    /*@ManyToMany(mappedBy = "autor")
    private List<Knjiga> knjige;*/
}
