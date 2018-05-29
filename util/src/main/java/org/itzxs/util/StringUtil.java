package org.itzxs.util;

/**
 * Created by Itzxs on 2018/5/29.
 */
public class StringUtil {
    public static boolean isEmpty(String str){
        if(null != str && !"".equals(str)){
            return false;
        }
        return true;
    }
}
