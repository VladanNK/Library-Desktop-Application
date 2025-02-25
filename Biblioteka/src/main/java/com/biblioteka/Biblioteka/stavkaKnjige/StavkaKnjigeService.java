package com.biblioteka.Biblioteka.stavkaKnjige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StavkaKnjigeService {
    @Autowired
    private StavkaKnjigeRepository stavkaKnjigeRepository;

    public List<StavkaKnjige> sviPodaciSK(){
        if(!stavkaKnjigeRepository.stavkaKnjigaPodaci().isEmpty()){
            return stavkaKnjigeRepository.stavkaKnjigaPodaci();
        }
        return null;
    }
    public void createSK(StavkaKnjige stavkaKnjigeCreate){
        stavkaKnjigeRepository.save(stavkaKnjigeCreate);
    }
    public void updateSK(StavkaKnjige stavkaKnjigeUpdate){
        stavkaKnjigeRepository.save(stavkaKnjigeUpdate);
    }
    public void deleteSK(Integer idSKDelete){
        stavkaKnjigeRepository.izbrisiStavkaKnjiga(idSKDelete);
    }
}
