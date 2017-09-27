package com.dev.framework.core.session;


import java.util.function.Supplier;

/**
 * @Author fanr
 * @Date 2017/9/26 16:44
 * @desc
 */
public class CurrentSessionStoreFactory {

    private static Supplier<CurrentSessionStore> supplier;

    public static synchronized void setCurrentSessionStore(Supplier<CurrentSessionStore> supplier){
        CurrentSessionStoreFactory.supplier = supplier;
    }

    public static void init(){
        if(supplier == null){
            setCurrentSessionStore(() -> new ThreadLocalSessionStore());
        }
    }

    public static CurrentSessionStore getCurrentSessionStore(){

        if(supplier == null){
            init();
        }

        return supplier.get();

    }

}
