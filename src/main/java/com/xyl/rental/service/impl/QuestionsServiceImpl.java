package com.xyl.rental.service.impl;

import com.xyl.rental.entity.Questions;
import com.xyl.rental.dao.QuestionsDao;
import com.xyl.rental.service.QuestionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Questions)表服务实现类
 *
 * @author makejava
 * @since 2020-03-23 22:32:24
 */
@Service("questionsService")
public class QuestionsServiceImpl implements QuestionsService {
    @Resource
    private QuestionsDao questionsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Questions queryById(Integer id) {
        return this.questionsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Questions> queryAllByLimit(int offset, int limit) {
        return this.questionsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param questions 实例对象
     * @return 实例对象
     */
    @Override
    public Questions insert(Questions questions) {
        this.questionsDao.insert(questions);
        return questions;
    }

    /**
     * 修改数据
     *
     * @param questions 实例对象
     * @return 实例对象
     */
    @Override
    public Questions update(Questions questions) {
        this.questionsDao.update(questions);
        return this.queryById(questions.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.questionsDao.deleteById(id) > 0;
    }
}