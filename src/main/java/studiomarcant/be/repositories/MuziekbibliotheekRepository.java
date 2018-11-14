package studiomarcant.be.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import studiomarcant.be.model.ArrangementData;

/**
 * Created by Win 10 on 13/11/2018.
 */
public interface MuziekbibliotheekRepository extends JpaRepository<ArrangementData,Long> {

}
