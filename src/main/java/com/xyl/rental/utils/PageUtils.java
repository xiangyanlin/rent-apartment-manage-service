package com.xyl.rental.utils;

import com.xyl.rental.vo.Pagination;
import com.xyl.rental.vo.TableResult;

import java.util.List;

/**
 * @author xyl
 * @version 1.0
 * @date 2020/4/30 11:30
 */
public class PageUtils {



    public static <T> TableResult page (int start, int total, List<T> list, int currentPage, int pageSize){
         TableResult tr=new TableResult();
         Pagination pagination=new Pagination();
        pagination.setCurrent(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setTotal(total);
        tr.setList(list);
        tr.setPagination(pagination);
        return tr;
    }


}
