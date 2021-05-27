package shizuka.infrastructure.appservice.query;

import org.springframework.stereotype.Service;
import shizuka.query.UploadQueryService;

/**
 * @author muzhi
 * @create 2021/5/25
 */
@Service
public class UploadQueryServiceImpl implements UploadQueryService {
    @Override
    public String test() {
        return "this is test";
    }
}
