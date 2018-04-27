package org.itzxs.util;

import java.lang.reflect.Array;

/**
 * Created by Itzxs on 2018/4/25.
 */
public class Base64Fun {

    public String enc(String str){
        char [] strChar = str.toCharArray();
        Integer [] strInt = new Integer[strChar.length];
        for (int i = 0; i < strChar.length; i++) {
            for (int j = 0; j < Base64.BASE64_ALPHABET.length; j++) {
                if(strChar[i]==Base64.BASE64_ALPHABET[j]){
                    for (int k = 0; k < Base64.BASE64_DEALPHABET.length; k++) {
                        if(j == Base64.BASE64_DEALPHABET[k]){
                            strInt[i] = k;
                        }
                    }
                }
            }
        }

        StringBuffer sb  = new StringBuffer();
        for (int i = 0; i < strInt.length; i++) {
            if(i != strInt.length){
                sb.append(strInt[i]+"/");
            }else{
                sb.append(strInt[i]);
            }
        }
        return sb.toString();
    }

    public String dec(String str){
        String [] strArr = str.split("/");
        Integer [] strInt = new Integer[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strInt[i] = Integer.parseInt(strArr[i]);
        }

        char [] strChar = new char[strInt.length];
        for (int i = 0; i < strInt.length; i++) {
            strChar[i] = Base64.BASE64_ALPHABET[Base64.BASE64_DEALPHABET[strInt[i]]];
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strChar.length; i++) {
            sb.append(strChar[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Base64Fun base64Fun = new Base64Fun();
        String enc = base64Fun.enc("org.itzxs.book");
        String dec = base64Fun.dec(enc);
        System.out.println(enc);
        System.out.println(dec);
    }

}
