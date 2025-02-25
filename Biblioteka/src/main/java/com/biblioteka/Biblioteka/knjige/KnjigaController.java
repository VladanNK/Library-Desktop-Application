package com.biblioteka.Biblioteka.knjige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Delete popraviti i za kategoriju da ne bude null
@RestController
public class KnjigaController {
    @Autowired
    private KnjigaService knjigaService;

    @GetMapping("/idKnjiga")
    public List<Integer> getAllIDKnjiga(){
        return knjigaService.allISBNKnjige();
    }
    @GetMapping("/naziviKnjiga")
    public List<String> getAllNaziviKnjiga(){
        return knjigaService.allNazivKnjige();
    }
    @GetMapping("/allKnjige")
    public List<Knjiga> getAllKnjige(){
        return knjigaService.prikaziSve();
    }
    @PostMapping("/createKnjiga")
    public void createKnjiga(@RequestBody Knjiga knjiga){
        knjigaService.createKnjiga(knjiga);
    }
    @DeleteMapping("/deleteKnjiga/{id}")
    public String deleteKnjiga(@PathVariable Integer id){
        if(id != null){
            knjigaService.deleteKnjiga(id);
            return "Uspesno obrisana knjiga!";
        }
        return "Niste uneli ID knjige!";
    }
    @PutMapping("/updateKnjiga/{id}")
    public String updateKnjiga(@PathVariable Integer id, @RequestBody Knjiga knjiga){
        if(id != null && id.equals(knjiga.getIsbn())){
            knjigaService.updateKnjiga(knjiga);
            return "Uspesno azurirana knjiga!";
        }
        return "Knjiga nema dati ID!";
    }
}
