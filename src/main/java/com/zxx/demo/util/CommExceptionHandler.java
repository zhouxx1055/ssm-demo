package com.zxx.demo.util;

import com.zxx.demo.module.common.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhouxx
 * @Description:
 * @date 2022/3/3  20:16
 */
@Slf4j
public class CommExceptionHandler  implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        ModelAndView mv = new ModelAndView();
        /*	使用response返回	*/
        response.setStatus(HttpStatus.OK.value()); //设置状态码500
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");

        log.error(ex.getMessage());
        BaseResult baseResult=new BaseResult(BaseResultError.API_UNKNOWN_ERROR);

        try {
            response.getWriter().write(baseResult.toString());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return mv;
    }
}
