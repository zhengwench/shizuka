package shizuka.domain.analyse.repository;

import shizuka.domain.analyse.model.AnalyseExecutor;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-08-24 13:52
 */
public interface AnalyseRepository {
    void saveAnalyseExecutor(AnalyseExecutor analyseExecutor);

    AnalyseExecutor getAnalyseExecutor();

    Integer queryIptAnalyseResultPageCount();
}
