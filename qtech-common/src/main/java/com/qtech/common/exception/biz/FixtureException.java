package com.qtech.common.exception.biz;

/**
 * author :  gaozhilin
 * email  :  gaoolin@gmail.com
 * date   :  2023/12/05 09:32:38
 * desc   :  TODO
 */


public class FixtureException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected final String message;

    public FixtureException() {
        this.message = null;
    }

    public FixtureException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
