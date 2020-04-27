package com.xyl.rental.service.impl;

import com.xyl.rental.entity.Questions;
import com.xyl.rental.dao.QuestionsDao;
import com.xyl.rental.service.QuestionsService;
import com.xyl.rental.vo.Pagination;
import com.xyl.rental.vo.TableResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Questions)表服务实现类
 *
 * @author xyl
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

    /**
     * 分页条件关键字
     * @param currentPage
     * @param pageSize
     * @param condition
     * @param keyWord
     * @return
     */
    @Override
    public TableResult queryByPage(int currentPage, int pageSize, Questions condition, String keyWord) {
        TableResult tr=new TableResult();
        Pagination pagination=new Pagination();
        int start=(currentPage-1)*pageSize;
        int total=questionsDao.countTotal(condition,keyWord);
        List<Questions> list = questionsDao.queryPage(
                start, pageSize,condition,keyWord);
        pagination.setCurrent(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setTotal(total);
        tr.setList(list);
        tr.setPagination(pagination);
        return tr;
    }


    /**
     *
     * @param currentPage
     * @param pageSize
     * @param condition
     * @param keyWord
     * @return
     */
    @Override
    public TableResult queryPageAndUser(int currentPage, int pageSize, Questions condition, String keyWord) {
        TableResult tr=new TableResult();
        Pagination pagination=new Pagination();
        int start=(currentPage-1)*pageSize;
        int total=questionsDao.countTotal(condition,keyWord);
        List<Map<String, Object>> maps = questionsDao.queryPageAndUser(
                start, pageSize, condition, keyWord);
        pagination.setCurrent(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setTotal(total);
        tr.setList(maps);
        tr.setPagination(pagination);
        return tr;
    }
}