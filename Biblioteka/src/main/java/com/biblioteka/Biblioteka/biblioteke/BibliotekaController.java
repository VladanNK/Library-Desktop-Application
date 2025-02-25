package com.biblioteka.Biblioteka.biblioteke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Ovo radi
@RestController
public class BibliotekaController {
    @Autowired
    private BibliotekaService bibliotekaService;

    @GetMapping("/allBiblioteke")
    public List<Biblioteka> getAllBiblioteke() {
        return bibliotekaService.sveBiblioteke();
    }
    @GetMapping("/allIDBiblioteka")
    public List<Integer> getAllIDBiblioteke() {
        return bibliotekaService.sveIDBiblioteka();
    }
    @GetMapping("/allBibliotekeNoID")
    public List<String> getAllBibliotekeNoID() {
        return bibliotekaService.sveBibliotekeOsimID();
    }
    @PostMapping("/createBiblioteka")
    public void createBiblioteka(@RequestBody Biblioteka bibliotekaCreate) {
        bibliotekaService.createBiblioteka(bibliotekaCreate);
    }
    @PutMapping("/updateBiblioteka/{id}")
    public String updateBiblioteka(@RequestBody Biblioteka bibliotekaUpdate, @PathVariable Integer id) {
        if(id != null && id.equals(bibliotekaUpdate.getId_biblioteke())){
            bibliotekaService.updateBiblioteka(bibliotekaUpdate);
            return "Uspesno azurirana Biblioteka!";
        }
        return "Nije pronadjena biblioteka sa datim ID-jem!";
    }
    /*@DeleteMapping("/deleteBiblioteka/{id}")
    public String deleteBiblioteka(@PathVariable Integer id) {
        if(id != null){
            bibliotekaService.deleteBiblioteka(id);
            return "Uspesno obrisana biblioteka!";
        }
        return "Nije pronadjena biblioteka sa zadatim ID-jem!";
    }*/
    @DeleteMapping("/deleteBiblioteka/{id}")
    public String deleteBiblioteka(@PathVariable Integer id){
        if(id != null){
            bibliotekaService.deleteBiblioteka(id);
            return "Uspesno obrisana biblioteka!";
        }
        return "Nije pronadjedna biblioteka sa zadatim ID-jem!";
    }
}
