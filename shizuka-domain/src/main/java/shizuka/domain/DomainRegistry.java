package shizuka.domain;

import shizuka.domain.analyse.repository.AnalyseRepository;
import shizuka.domain.evaluate.repository.EvaluateRepository;
import shizuka.domain.service.push.PushService;
import shizuka.domain.upload.repository.UploadRepository;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-27 16:42
 */
public class DomainRegistry {

    public static EvaluateRepository evaluateRepository;

    public static AnalyseRepository analyseRepository;

    public static UploadRepository uploadRepository;

    public static PushService pushService;

    public static ThreadPoolExecutor threadPoolExecutor;
}
