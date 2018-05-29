package org.itzxs.util.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.TreeMap;

/**
 * Created by Itzxs on 2018/4/25.
 */
public class LoginFilter extends HandlerInterceptorAdapter {
    // 继承HandlerInterceptorAdapter类

    private String reqSign = null;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)
            throws Exception{
        TreeMap<String,Object> _param = new TreeMap<String,Object>();
        @SuppressWarnings("unchecked")
        Enumeration<String> paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements()){
            String paraKey = paramNames.nextElement();
            String paraValue = request.getParameter(paraKey);
            if("enc".equals(paraKey)){
                reqSign = paraKey;
            }
        }
        return true;
    }
}
