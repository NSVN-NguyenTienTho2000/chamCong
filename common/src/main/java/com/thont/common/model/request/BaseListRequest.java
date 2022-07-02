package com.thont.common.model.request;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Accessors(chain = true)
public class BaseListRequest {

    @Min(value = 1, message = "page.invalid")
    private int page = 1;
    @Min(value = 1, message = "limit.invalid")
    @Max(value = 200, message = "limit.invalid")
    private int limit = 40;

    public int getPage(){
        return page - 1;
    }

    public PageRequest getPaging() {
        return PageRequest.of(getPage(), limit);
    }

    public PageRequest getPaging(Sort sort) {
        return PageRequest.of(getPage(), limit, sort);
    }

    public PageRequest getPagingCreatedDesc() {
        return PageRequest.of(getPage(), limit, Sort.by("createdAt").descending());
    }
}
