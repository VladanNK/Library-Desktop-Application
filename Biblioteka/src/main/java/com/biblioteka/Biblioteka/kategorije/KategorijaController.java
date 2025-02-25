package com.biblioteka.Biblioteka.kategorije;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Ovde sve radi
@RestController
public class KategorijaController {
    @Autowired
    private KategorijaService kategorijaService;

    @GetMapping("/allKategorije")
    public List<Kategorija> allKategorije(){
        if(kategorijaService.vratiSveKategorije() != null){
            return kategorijaService.vratiSveKategorije();
        }
        return null;
    }
    @GetMapping("/idKategorija")
    public List<Integer> getAllIDKategorija(){
        if(kategorijaService.allIdKategorije() != null){
            return kategorijaService.allIdKategorije();
        }
        return null;
    }
    @GetMapping("/naziviKategorija")
    public List<String> getAllNazivKategorije(){
        if(kategorijaService.allNazivKategorije() != null){
            return kategorijaService.allNazivKategorije();
        }
        return null;
    }
    @PostMapping("/createKategorija")
    public String createKategorija(@RequestBody Kategorija kategorijaCreate){
        if(kategorijaCreate != null){
            kategorijaService.createKategorija(kategorijaCreate);
            return "Uspesno kreirana kategorija!";
        }
        return "Uneti potrebne podatke za kreiranje kategorije!";
    }
    @PutMapping("/updateKategorija/{id}")
    public String updateKategorija(@PathVariable Integer id, @RequestBody Kategorija kategorijaUpdate){
        if(id != null && id.equals(kategorijaUpdate.getId_kategorije())){
            kategorijaService.updateKategorija(kategorijaUpdate);
            return "Uspesno azurirana kategorija!";
        }
        return "Kategorija sa zadatim ID-jem ne postoji!";
    }
    @DeleteMapping("/deleteKategorija/{id}")
    public String deleteKategorija(@PathVariable Integer id){
        if(id != null) {
            kategorijaService.deleteKategorija(id);
            return "Uspesno obrisana kategorija!";
        }
        return "Niste uneli ID za brisanje kategorije!";
    }
}
