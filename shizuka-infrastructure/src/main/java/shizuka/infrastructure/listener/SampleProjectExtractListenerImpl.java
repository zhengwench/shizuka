package shizuka.infrastructure.listener;

import shizuka.domain.evaluate.listener.SampleProjectExtractEventListener;
import org.springframework.stereotype.Component;

/**
 * @Author: siskin_zh
 * @Date: 2020 2020-07-28 15:54
 */
@Component
public class SampleProjectExtractListenerImpl implements SampleProjectExtractEventListener {
    @Override
    public void onExtract() {

    }
}
