package spring.umc.apiPayload.exception.handler;

import spring.umc.apiPayload.code.BaseErrorCode;
import spring.umc.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode){ super(errorCode);}
}
