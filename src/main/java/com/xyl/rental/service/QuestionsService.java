package com.xyl.rental.service;

import com.xyl.rental.entity.Questions;
import java.util.List;

/**
 * (Questions)表服务接口
 *
 * @author makejava
 * @since 2020-03-23 22:32:24
 */
public interface QuestionsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Questions queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Questions> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param questions 实例对象
     * @return 实例对象
     */
    Questions insert(Questions questions);

    /**
     * 修改数据
     *
     * @param questions 实例对象
     * @return 实例对象
     */
    Questions update(Questions questions);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}