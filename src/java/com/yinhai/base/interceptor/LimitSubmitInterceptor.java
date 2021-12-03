package com.yinhai.base.interceptor;

import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * 防重复提交拦截器
 */
public class LimitSubmitInterceptor extends HandlerInterceptorAdapter {

    public static final String REPEATED_SUBMISSION = "_REPEATED_SUBMISSION";
    static PathMatcher pathMatcher = new AntPathMatcher();

    private List<String> submitExtraUrls;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        this.registerSubmitUrl(request, response);
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        this.removeSubmitUrl(request);
    }

    private void removeSubmitUrl(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            ConcurrentSkipListSet<String> set = (ConcurrentSkipListSet)session.getAttribute(REPEATED_SUBMISSION);
            if (set != null) {
                StringBuffer url = request.getRequestURL();
                if (request.getQueryString() != null) {
                    url.append("?");
                    url.append(request.getQueryString());
                }
                set.remove(url.toString());
            }
        }

    }

    private void registerSubmitUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String realUrl = UrlUtils.buildRequestUrl(request);
            if (this.submitExtraUrls.contains(realUrl)) {
                return;
            }

            Iterator it = this.submitExtraUrls.iterator();

            while(it.hasNext()) {
                if (pathMatcher.match((String)it.next(), realUrl)) {
                    return;
                }
            }

            ConcurrentSkipListSet<String> set = (ConcurrentSkipListSet)session.getAttribute(REPEATED_SUBMISSION);
            if (set == null) {
                ConcurrentSkipListSet<String> requestSet = new ConcurrentSkipListSet();
                session.setAttribute(REPEATED_SUBMISSION, requestSet);
            } else {
                StringBuffer url = request.getRequestURL();
                if (request.getQueryString() != null) {
                    url.append("?");
                    url.append(request.getQueryString());
                }
                if (set.contains(url.toString())) {
                    response.sendError(418, "请求正在处理中，请勿需重复提交");
                }else{
                    set.add(url.toString());
                }
            }
        }

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public List<String> getSubmitExtraUrls() {
        return this.submitExtraUrls;
    }

    public void setSubmitExtraUrls(List<String> submitExtraUrls) {
        this.submitExtraUrls = submitExtraUrls;
    }
}

