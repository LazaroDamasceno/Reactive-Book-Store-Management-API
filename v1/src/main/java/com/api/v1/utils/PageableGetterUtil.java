package com.api.v1.utils;

import com.api.v1.dtos.requests.PaginationRequestDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageableGetterUtil {

    public static Pageable get(PaginationRequestDto pagination) {
        return PageRequest.of(pagination.page(), pagination.size());
    }

}
