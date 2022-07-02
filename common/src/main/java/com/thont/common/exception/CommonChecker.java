package com.thont.common.exception;

import java.time.LocalDateTime;

public class CommonChecker {
    public static void throwIfNull(Object object, String message){// throw if null
        if(object == null){
            throw new com.thont.common.exception.HandleFailedWithKnownException(message);
        }
    }

    public static void checkTimeInPast(LocalDateTime time, String message){// throw if time in past
        if(time.isBefore(LocalDateTime.now())){
            throw new com.thont.common.exception.HandleFailedWithKnownException(message);
        }
    }
    public static void throwIfTrue(Boolean invalid, String message){// throw if invalid is true
        if(invalid){
            throw new com.thont.common.exception.HandleFailedWithKnownException(message);
        }
    }

    public static void throwIfFalse(Boolean valid, String message){// throw if invalid is true
        if(!valid){
            throw new com.thont.common.exception.HandleFailedWithKnownException(message);
        }
    }
}
