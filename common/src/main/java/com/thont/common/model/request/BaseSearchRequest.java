package com.thont.common.model.request;

import lombok.Data;

@Data
public class BaseSearchRequest extends BaseListRequest{
    private String keyword;

    public String getKeyword(){
        if(this.keyword == null || this.keyword.equals("")){
            return null;
        }
        return "%" + keyword + "%";
    }
}
