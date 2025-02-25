package com.biblioteka.Biblioteka.knjige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;

    public List<Integer> allISBNKnjige(){
        return knjigaRepository.isbnKnjige();
    }
    public List<String> allNazivKnjige(){
        return knjigaRepository.nazivKnjige();
    }
    public List<Knjiga> prikaziSve(){
        return knjigaRepository.prikaziSve();
    }
    public void createKnjiga(Knjiga knjiga){
        knjigaRepository.save(knjiga);
    }
    public void deleteKnjiga(Integer id){
        knjigaRepository.izbrisiKnjigu(id);
    }
    public void updateKnjiga(Knjiga knjiga){
        knjigaRepository.save(knjiga);
    }
}
