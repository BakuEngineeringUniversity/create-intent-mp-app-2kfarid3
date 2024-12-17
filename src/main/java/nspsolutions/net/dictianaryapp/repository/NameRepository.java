package nspsolutions.net.dictianaryapp.repository;

import nspsolutions.net.dictianaryapp.entity.Name;
import nspsolutions.net.dictianaryapp.entity.NameMeaningDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NameRepository extends JpaRepository<Name, Long> {

    @Query("SELECT new nspsolutions.net.dictianaryapp.entity.NameMeaningDTO(n.name, m.meaning) " +
            "FROM Name n INNER JOIN n.meanings m")
    List<NameMeaningDTO> findNameAndMeanings();

    Optional<Name> findByName(String name);
}
