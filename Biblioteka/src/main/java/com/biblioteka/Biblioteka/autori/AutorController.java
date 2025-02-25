package com.biblioteka.Biblioteka.autori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping("/allAutori")
    public List<Autor> getAllAutori() {
        if(!autorService.prikaziPodatkeAutora().isEmpty()){
            return autorService.prikaziPodatkeAutora();
        }
        return null;
    }
    @GetMapping("/idAutora")
    public List<Integer> getAllIDAutori(){
        if(!autorService.uzmiIDAutora().isEmpty()){
            return autorService.uzmiIDAutora();
        }
        return null;
    }
    @GetMapping("/allAutoriNoID")
    public List<String> getAllAutoriNoID() {
        if(!autorService.uzmiSvePodatkeOsimID().isEmpty()){
            return autorService.uzmiSvePodatkeOsimID();
        }
        return null;
    }
    @PostMapping("/createAutor")
    public void createAutor(@RequestBody Autor autorCreate) {
        autorService.createAutor(autorCreate);
    }
    @PutMapping("/updateAutor/{id}")
    public String updateAutor(@RequestBody Autor autorUpdate, @PathVariable Integer id) {
        if(id != null && id.equals(autorUpdate.getId_autora())){
            autorService.updateAutor(autorUpdate);
            return "Uspesno azuriran autor!";
        }
        return "Nije unet ID za azuriranje autora!";
    }
    @DeleteMapping("/deleteAutor/{id}")
    public String deleteAutor(@PathVariable Integer id) {
        if(id != null){
            autorService.deleteAutor(id);
            return "Uspesno obrisan autor!";
        }
        return "Nije pronadjen autor sa datim ID-jem!";
    }
}
