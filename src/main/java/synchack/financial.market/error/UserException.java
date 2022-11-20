package synchack.financial.market.error;

import synchack.financial.market.error.enums.ErrorCode;

public class UserException extends RuntimeException{

    public UserException(ErrorCode errorCode){
        super(String.valueOf(errorCode));
    }
}
