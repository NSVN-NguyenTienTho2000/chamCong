package com.thont.common.zother.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ListItemNotDuplicateImpl implements ConstraintValidator<ListItemNotDuplicate, List> {
    @Override
    public boolean isValid(List data, ConstraintValidatorContext constraintValidatorContext) {
        if(data != null && data.size() > 1){
            for(int i = 0; i < data.size(); i++){
                for(int j = i + 1; j < data.size(); j++){
                    if(data.get(i) == null && data.get(j) == null
                            || data.get(i) != null && data.get(i).equals(data.get(j))){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
