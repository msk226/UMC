package spring.umc.apiPayload.exception.handler;

import spring.umc.apiPayload.code.BaseErrorCode;
import spring.umc.apiPayload.exception.GeneralException;

public class ReviewHandler extends GeneralException {

    public ReviewHandler(BaseErrorCode errorCode) { super(errorCode);}
}
