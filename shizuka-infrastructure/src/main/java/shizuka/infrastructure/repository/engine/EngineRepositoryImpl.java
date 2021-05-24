package shizuka.infrastructure.repository.engine;

import shizuka.domain.engine.repository.EngineRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-09-10 14:13
 */
@Repository
public class EngineRepositoryImpl implements EngineRepository {

    @Override
    public void executeEngine() {
        System.out.println("run");
    }
}
