package com.github.ichenkaihua.utils;

import org.springframework.web.util.UriTemplate;
import org.springframework.web.util.UriUtils;

import java.net.URI;
import java.util.Objects;

/**
 * Created by chenkaihua on 15-9-16.
 */
public class URIUtils {

    public static URI createURI(String url, Object... uriVariableValues) {
        return new UriTemplate(url).expand(uriVariableValues);
    }

}
