package com.hl.excel.util;

import com.hl.excel.base.AbstractPoiExcel;
import com.hl.excel.base.PoiInterface;

/**
 * @author Hailin
 */
public class PoiBeanFactory<T extends AbstractPoiExcel> {


    //静态内部类懒汉单例
    private PoiBeanFactory() {
    }

    public static synchronized final PoiBeanFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //静态内部类
    private static class SingletonHolder {
        static final PoiBeanFactory INSTANCE = new PoiBeanFactory();
    }

    //根据状态获得想要的实例
    public PoiInterface<T> getPoiUtil(int type) {
        PoiInterface<T> poiInterface = null;
        switch (type) {
            case -1:
                poiInterface = new ExportBeanExcel();
                break;
            case -2:

                break;
            case -3:
                break;
            case -4:
                break;
            case -5:
                poiInterface = new ExportMapExcel();
                break;
            case -6:
                break;
        }
        return poiInterface;
    }

}
