package com.xyl.rental.vo;

import lombok.*;

import java.util.List;

@Data
public class TableResult<T> {

    private List<T> list;
    private Pagination pagination;

}