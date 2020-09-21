package cn.okclouder.architecturesamples.livedata;

import java.util.ArrayList;

/**
 * @author caoshen
 * @date 2020/9/21
 */
public class StockManager {

    private final ArrayList<SimplePriceListener> simplePriceListeners = new ArrayList<>();

    public StockManager(String symbol) {

    }

    public void requestPriceUpdates(SimplePriceListener listener) {
        synchronized (simplePriceListeners) {
            simplePriceListeners.add(listener);
        }
    }

    public void removeUpdates(SimplePriceListener listener) {
        synchronized (simplePriceListeners) {
            simplePriceListeners.remove(listener);
        }
    }
}
