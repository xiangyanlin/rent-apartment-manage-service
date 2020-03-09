package com.xyl.rental.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class Pagination {

    private Integer current;
    private Integer pageSize;
    private Integer total;

}