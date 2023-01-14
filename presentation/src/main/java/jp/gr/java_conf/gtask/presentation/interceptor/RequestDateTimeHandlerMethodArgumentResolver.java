package jp.gr.java_conf.gtask.presentation.interceptor;

import java.time.Clock;
import jp.gr.java_conf.gtask.domain.datetime.RequestDateTime;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class RequestDateTimeHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private final Clock clock;

    public RequestDateTimeHandlerMethodArgumentResolver(Clock clock) {
        this.clock = clock;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(RequestDateTime.class);
    }

    @Override
    public RequestDateTime resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) {
        return RequestDateTime.nowWith(clock);
    }
}
