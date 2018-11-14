package studiomarcant.be.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import studiomarcant.be.model.ArrangementData;
import studiomarcant.be.repositories.ArrangementDataRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Win 10 on 13/11/2018.
 */
public abstract class ArrangementDataRepositoryImpl implements ArrangementDataRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ArrangementDataRepository arrangementDataRepository;

    @Override
    public ArrangementData findOne (Long aLong) {
        ArrangementData toReturn=arrangementDataRepository.findOne (aLong);
        return toReturn;
    }

    @Override
    public boolean exists (Long aLong) {
        return false;
    }

    @Override
    public List<ArrangementData> findAll () {
        return null;
    }

    @Override
    public List<ArrangementData> findAll (Sort sort) {
        return null;
    }

    @Override
    public Page<ArrangementData> findAll (Pageable pageable) {
        return null;
    }

    @Override
    public List<ArrangementData> findAll (Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count () {
        return 0;
    }

    @Override
    public void flush () {

    }

    @Override
    public void deleteInBatch (Iterable<ArrangementData> iterable) {

    }

    @Override
    public void deleteAllInBatch () {

    }

    @Override
    public ArrangementData getOne (Long aLong) {
        return null;
    }


    @Override
    public void delete (Long aLong) {

    }

    @Override
    public void delete (ArrangementData arrangementData) {

    }

    @Override
    public void delete (Iterable<? extends ArrangementData> iterable) {

    }


    @Override
    public void deleteAll () {

    }



}
