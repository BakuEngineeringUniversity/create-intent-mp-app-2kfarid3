package nspsolutions.net.dictianaryapp.service;


import nspsolutions.net.dictianaryapp.entity.Meaning;
import nspsolutions.net.dictianaryapp.entity.MeaningDto;
import nspsolutions.net.dictianaryapp.entity.Name;
import nspsolutions.net.dictianaryapp.entity.NameMeaningDTO;
import nspsolutions.net.dictianaryapp.repository.MeaningRepository;
import nspsolutions.net.dictianaryapp.repository.NameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NameService {

    private final NameRepository nameRepository;
    private final MeaningRepository meaningRepository;

    public NameService(NameRepository nameRepository, MeaningRepository meaningRepository) {
        this.nameRepository = nameRepository;
        this.meaningRepository = meaningRepository;
    }

    public Name createName(String name) {
        return nameRepository.save(new Name(name));
    }

    public Meaning addMeaningToName(Long nameId, String meaningText) {
        Optional<Name> optionalName = nameRepository.findById(nameId);
        if (optionalName.isPresent()) {
            Name name = optionalName.get();
            Meaning meaning = new Meaning(meaningText);
            name.addMeaning(meaning);
            return meaningRepository.save(meaning);
        }
        throw new RuntimeException("Name not found");
    }

    public MeaningDto getMeaningByName(String name) {

        Name nameEntity = nameRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Name not found: " + name));


        return meaningRepository.findMeaning(nameEntity);
    }

    public List<Name> getAllNames() {
        return nameRepository.findAll();
    }

    public List<NameMeaningDTO> getAllNameAndMeanings() {
        return nameRepository.findNameAndMeanings();
    }
}
