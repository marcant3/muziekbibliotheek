package studiomarcant.be.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import studiomarcant.be.model.ArrangementData;

import java.util.List;

/**
 * Created by Win 10 on 13/11/2018.
 */
public interface ArrangementDataRepository extends JpaRepository<ArrangementData,Long> {

    ArrangementData findOne (Long aLong);

    boolean exists (Long aLong);


    List<ArrangementData> findAll ();


    List<ArrangementData> findAll (Sort sort);


    Page<ArrangementData> findAll (Pageable pageable);


    List<ArrangementData> findAll (Iterable<Long> iterable);


    long count ();


    void flush();

    ArrangementData getOne (Long aLong);


    void delete (Long aLong);


    void delete (ArrangementData arrangementData);


    void deleteAll ();
}
