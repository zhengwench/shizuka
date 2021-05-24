package shizuka.domain.upload.repository;

import shizuka.domain.upload.model.UploadTask;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-09-10 18:30
 */
public interface UploadRepository {
    void saveUploadTask(UploadTask uploadTask);
}
