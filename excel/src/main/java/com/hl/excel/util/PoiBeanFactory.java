package com.hl.excel.util;

import com.hl.excel.base.AbstractPoiExcel;
import com.hl.excel.base.PoiInterface;

/**
 * Excel导出工厂类
 *
 * @author Hailin
 */
public class PoiBeanFactory<T extends AbstractPoiExcel> {

    /**
     * 静态内部类懒汉单例
     */
    private PoiBeanFactory() {
    }

    public static synchronized PoiBeanFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        static final PoiBeanFactory INSTANCE = new PoiBeanFactory();
    }

    /**
     * 根据状态获得想要的实例
     *
     * @param type 状态
     * @return 实例
     */
    public PoiInterface<T> getPoiUtil(int type) {
        PoiInterface<T> poiInterface = null;
        switch (type) {
            case -1:
                return new ExportBeanExcel();
            case -2:
                return null;
            case -3:
                return null;
            case -4:
                return null;
            case -5:
                return new ExportMapExcel();
            case -6:
                return null;
            default:
                return new ExportBeanExcel();
        }
    }
}
