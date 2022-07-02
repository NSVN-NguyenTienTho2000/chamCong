package com.thont.user.zother.validation.user;

//import com.thont.user.business.CacheBusiness;
import com.thont.user.zother.enumeration.EmailEnum;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnregisteredPhoneImpl implements ConstraintValidator<UnregisteredPhone, String> {
//    @Autowired
//    private CacheBusiness cacheBusiness;

    private static Pattern mailPattern = Pattern.compile(EmailEnum.REGEX.getValue(), Pattern.CASE_INSENSITIVE);


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        Matcher matcher = mailPattern.matcher(s);
//            return !cacheBusiness.isRegisteredPhone(s);
        return false;
    }
}
