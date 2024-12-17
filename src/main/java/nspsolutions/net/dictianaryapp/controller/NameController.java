package nspsolutions.net.dictianaryapp.controller;

import nspsolutions.net.dictianaryapp.entity.Meaning;
import nspsolutions.net.dictianaryapp.entity.MeaningDto;
import nspsolutions.net.dictianaryapp.entity.Name;
import nspsolutions.net.dictianaryapp.entity.NameMeaningDTO;
import nspsolutions.net.dictianaryapp.service.NameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dictionary")
public class NameController {

    private NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @PostMapping("/add")
    public ResponseEntity<Name> add(@RequestBody Name name) {
        Name name1 = nameService.createName(name.getName());
        return ResponseEntity.ok(name1);
    }

    @PostMapping("addmeaning/{id}")
    public ResponseEntity<Meaning> addMeaning(@PathVariable Long id, @RequestBody Meaning meaningText) {
        Meaning meaning = nameService.addMeaningToName(id, meaningText.getMeaning());
        return ResponseEntity.ok(meaning);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Name>> getAll() {
        List<Name> names = nameService.getAllNames();
        return ResponseEntity.ok(names);
    }

    @GetMapping("/names-with-meanings")
    public ResponseEntity<List<NameMeaningDTO>> getNamesWithMeanings() {
        List<NameMeaningDTO> nameMeanings = nameService.getAllNameAndMeanings();
        return ResponseEntity.ok(nameMeanings);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<MeaningDto> findByName(@PathVariable String name) {
        MeaningDto meaningDto = nameService.getMeaningByName(name);
        return ResponseEntity.ok(meaningDto);
    }
}
