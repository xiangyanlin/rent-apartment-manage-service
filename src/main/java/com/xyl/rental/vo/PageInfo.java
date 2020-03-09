package com.xyl.rental.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Collections;
import java.util.List;


/**
 * @author xyl
 * @version 1.0
 * @date 2020/3/9 11:06
 */
@Data

public class PageInfo<T> implements java.io.Serializable {
    /*** 总条数 */
    private Integer total;
    /*** 当前页 */
    private Integer pageNum;
    /*** 一页显示的大小 */
    private Integer pageSize;
    /*** 数据列表 */
    private List<T> records = Collections.emptyList();

}
