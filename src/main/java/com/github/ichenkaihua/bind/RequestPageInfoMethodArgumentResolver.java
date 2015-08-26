package com.github.ichenkaihua.bind;

import com.github.ichenkaihua.jopo.SimplePageInfo;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by chenkaihua on 15-8-24.
 */


public class RequestPageInfoMethodArgumentResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(RequestPageInfo.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        RequestPageInfo requestPageInfo = parameter.getParameterAnnotation(RequestPageInfo.class);

        String strPage =  webRequest.getHeader("page");
        String strLimit = webRequest.getHeader("limit");
        SimplePageInfo pageInfo = new SimplePageInfo();
        if(strPage != null && strPage.matches("\\d+")){
            pageInfo.setPage(Integer.parseInt(strPage));
        }else{
            pageInfo.setPage(requestPageInfo.page());
        }
        if(strLimit != null && strLimit.matches("\\d+")){
            pageInfo.setLimit(Integer.parseInt(strLimit));
        }else {
            pageInfo.setLimit(requestPageInfo.limit());
        }
        return pageInfo;
    }
}
