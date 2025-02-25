package com.biblioteka.Biblioteka.stavkaKnjige;

import com.biblioteka.Biblioteka.biblioteke.Biblioteka;
import com.biblioteka.Biblioteka.knjige.Knjiga;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stavka_knjiga")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StavkaKnjige {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_stavka_knjiga;

    @ManyToOne
    @JoinColumn(name = "isbn")
    private Knjiga knjiga;

    @ManyToOne
    @JoinColumn(name = "id_biblioteke")
    private Biblioteka biblioteka;
}
