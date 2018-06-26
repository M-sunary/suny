package com.suny.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 【全局异常处理】模块
 *
 * @author yu.sun
 * @content 处理全局异常
 * @date 2018/4/8 16:27
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e) throws Exception{
        ModelAndView mav = new ModelAndView();
        logger.error("## current request url : {}",request.getRequestURL().toString());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        mav.addObject("url",request.getRequestURI());
        mav.addObject("exception",e.getMessage());
        return mav;
    }

    /*
    通过@ControllerAdvice统一定义不同Exception映射到不同错误处理页面。而当我们要实现RESTful API时，返回的错误是JSON格式的数据，而不是HTML页面，这时候我们也能轻松支持。
        本质上，只需在@ExceptionHandler之后加入@ResponseBody，就能让处理函数return的内容转换为JSON格式。
        下面以一个具体示例来实现返回JSON格式的异常处理。
        创建统一的JSON返回对象，code：消息类型，message：消息内容，url：请求的url，data：请求返回的数据
        public class ErrorInfo<T> {
            public static final Integer OK = 0;
            public static final Integer ERROR = 100;
            private Integer code;
            private String message;
            private String url;
            private T data;
            // 省略getter和setter
        }
        创建一个自定义异常，用来实验捕获该异常，并返回json
        public class MyException extends Exception {
            public MyException(String message) {
                super(message);
            }

        }
        Controller中增加json映射，抛出MyException异常
        @Controller
        public class HelloController {
            @RequestMapping("/json")
            public String json() throws MyException {
                throw new MyException("发生错误2");
            }
        }
        为MyException异常创建对应的处理
        @ControllerAdvice
        public class GlobalExceptionHandler {
            @ExceptionHandler(value = MyException.class)
            @ResponseBody
            public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
                ErrorInfo<String> r = new ErrorInfo<>();
                r.setMessage(e.getMessage());
                r.setCode(ErrorInfo.ERROR);
                r.setData("Some Data");
                r.setUrl(req.getRequestURL().toString());
                return r;
            }
        }
             */

}
