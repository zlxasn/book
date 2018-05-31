package org.itzxs.util.filter;


import org.itzxs.entity.UserInformation;
import org.itzxs.util.PropertiesUtil;
import org.itzxs.util.StringUtil;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Itzxs on 2018/5/25.
 */
@SessionAttributes(types = {UserInformation.class, String.class}, value = {"userInformation"})
public class LoginValidataFilter implements Filter{

    private static final String loginUrl = PropertiesUtil.getPropertyValue("system", "loginUrl");
    private static final String[] ignore = PropertiesUtil.getPropertyValue("system", "ignore").split(",");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        String url = httpServletRequest.getRequestURI();
        HttpSession httpSession = httpServletRequest.getSession();
        for (String str :ignore){
            if(url.contains(str)){
                chain.doFilter(httpServletRequest, httpServletResponse);
                return;
            }
        }
        UserInformation userInformation  = (UserInformation) httpSession.getAttribute("userInformation");
        if (url.contains(loginUrl) || userInformation != null && !StringUtil.isEmpty(userInformation.getUserName())) {
            chain.doFilter(httpServletRequest,httpServletResponse);
        }else{
            //如果是ajax请求响应头会有，x-requested-with；
            if (isAjaxRequest(httpServletRequest) || isFormRequest(httpServletRequest)) {
                //在响应头设置session状态
                httpServletResponse.setHeader("sessionStatus", "timeout");
                httpServletResponse.setStatus(403);
            } else {
                httpServletResponse.sendRedirect("/user/index.html");
            }
        }
    }

    @Override
    public void destroy() {}

    private boolean isAjaxRequest(HttpServletRequest request){
        return request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest");
    }

    private boolean isFormRequest(HttpServletRequest request){
        return request.getHeader("Content-Type") != null && request.getHeader("Content-Type").equalsIgnoreCase("application/x-www-form-urlencoded");
    }
}
