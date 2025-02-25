package com.biblioteka.Biblioteka.kategorije;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategorijaService {
    @Autowired
    private KategorijaRepository kategorijaRepository;

    public List<Kategorija> vratiSveKategorije(){
        return kategorijaRepository.sveKategorije();
    }
    public List<Integer> allIdKategorije(){
        return kategorijaRepository.idKategorije();
    }
    public List<String> allNazivKategorije(){
        return kategorijaRepository.nazivKategorije();
    }
    public void createKategorija(Kategorija kategorija){
        kategorijaRepository.save(kategorija);
    }
    public void updateKategorija(Kategorija kategorijaUpdate){
        kategorijaRepository.save(kategorijaUpdate);
    }
    public void deleteKategorija(Integer id) {
        kategorijaRepository.izbrisiKategoriju(id);
    }
}
