package com.atguigu.common.exception;

import com.atguigu.common.result.R;
import com.atguigu.common.result.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ：FYQ
 * @description： 统一异常处理类
 * @date ：2022/7/11 10:43
 */
@Slf4j
@Component
@RestControllerAdvice //在controller层添加通知。如果使用@ControllerAdvice，则方法上需要添加@ResponseBody
public class UnifiedExceptionHandler {
    /**
     * @param e:
     * @return R
     * @description 未定义异常
     * @date
     */
    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e) { //当controller中抛出Exception，则捕获
        log.error(e.getMessage(), e);
        return R.error();
    }

    /**
     * @param e:
     * @return R
     * @description SQL异常
     * @date
     */
    @ExceptionHandler(value = BadSqlGrammarException.class)
    public R handleBadSqlGrammarException(BadSqlGrammarException e) {
        log.error(e.getMessage(), e);
        return R.setResult(ResponseEnum.BAD_SQL_GRAMMAR_ERROR);
    }
}
