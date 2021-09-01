package org.zerock.board00.common.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {
    //코드문제 -> 500 / 서버(URL) -> 404 : web.xml(=webConfig) 확인

    @ExceptionHandler(Exception.class) //괄호안에 어떤 종류의 예외가 발생하면 얘를 실행한다고 알려줌
    public String exception(Exception ex, Model model) {

        log.error(ex.getClass().getName());
        log.error(ex.getMessage());

        model.addAttribute("exception", ex);

        return  "error_page";

    }
    //ArithmeticException

    @ExceptionHandler(ArithmeticException.class)
    public String exceptArithmetic(ArithmeticException ex, Model model){

        log.info("exceptArithmetic");
        log.error(ex.getClass().getName());
        log.error(ex.getMessage());

        model.addAttribute("exception", ex);

        return "error_arithmetic_page";
    }

}
