package cn.okclouder.architecturesamples.livedata;

import java.math.BigDecimal;

/**
 * @author caoshen
 * @date 2020/9/21
 */
public interface SimplePriceListener {
    void onPriceChanged(BigDecimal price);
}
