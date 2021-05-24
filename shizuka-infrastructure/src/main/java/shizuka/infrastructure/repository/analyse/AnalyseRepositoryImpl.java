package shizuka.infrastructure.repository.analyse;

import shizuka.domain.analyse.model.AnalyseExecutor;
import shizuka.domain.analyse.repository.AnalyseRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-08-24 14:01
 */
@Repository
public class AnalyseRepositoryImpl implements AnalyseRepository {
    @Override
    public AnalyseExecutor getAnalyseExecutor() {
        return null;
    }

    @Override
    public void saveAnalyseExecutor(AnalyseExecutor analyseExecutor) {

    }

    @Override
    public Integer queryIptAnalyseResultPageCount() {
        return null;
    }
}
