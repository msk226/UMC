package spring.umc.apiPayload.exception.handler;

import spring.umc.apiPayload.code.BaseErrorCode;
import spring.umc.apiPayload.exception.GeneralException;

public class UserMissionHandler extends GeneralException {

    public UserMissionHandler(BaseErrorCode errorCode) {super(errorCode);}
}
