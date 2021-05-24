package shizuka.infrastructure.repository.upload;

import shizuka.domain.upload.model.UploadTask;
import shizuka.domain.upload.repository.UploadRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-09-10 18:33
 */
@Repository
public class UploadRepositoryImpl implements UploadRepository {

    @Transactional
    @Override
    public void saveUploadTask(UploadTask uploadTask) {

    }
}
