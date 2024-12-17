package nspsolutions.net.dictianaryapp.repository;

import nspsolutions.net.dictianaryapp.entity.Meaning;
import nspsolutions.net.dictianaryapp.entity.MeaningDto;
import nspsolutions.net.dictianaryapp.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MeaningRepository extends JpaRepository<Meaning, Long> {

    @Query("SELECT new nspsolutions.net.dictianaryapp.entity.MeaningDto(m.meaning) " +
            "FROM Meaning m WHERE m.name = :name")
    MeaningDto findMeaning(@Param("name") Name name);
}
