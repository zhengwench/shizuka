package shizuka.infrastructure.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shizuka.domain.DomainRegistry;
import shizuka.domain.analyse.repository.AnalyseRepository;
import shizuka.domain.evaluate.repository.EvaluateRepository;
import shizuka.domain.service.push.PushService;
import shizuka.domain.upload.repository.UploadRepository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-28 13:42
 */
@Component
public class DomainRegisterAssemble {

    @Resource
    private EvaluateRepository evaluateRepository;

    @Resource
    private AnalyseRepository analyseRepository;

    @Resource
    private UploadRepository uploadRepository;

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private PushService pushService;

    @PostConstruct
    public void init() {
        DomainRegistry.evaluateRepository = evaluateRepository;
        DomainRegistry.analyseRepository = analyseRepository;
        DomainRegistry.uploadRepository = uploadRepository;
        DomainRegistry.pushService = pushService;

        DomainRegistry.threadPoolExecutor = threadPoolExecutor;
    }
}
