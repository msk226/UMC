package spring.umc.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import spring.umc.apiPayload.code.BaseErrorCode;
import spring.umc.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason(){
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }


}
