package synchack.financial.market.error.enums;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    USER_001();

    public String getErrorCode(){
        return name();
    }
}
