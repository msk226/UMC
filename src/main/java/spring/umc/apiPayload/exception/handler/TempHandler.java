package spring.umc.apiPayload.exception.handler;

import spring.umc.apiPayload.code.BaseErrorCode;
import spring.umc.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException{

    public TempHandler(BaseErrorCode errorCode){
        super(errorCode);
    }

}
