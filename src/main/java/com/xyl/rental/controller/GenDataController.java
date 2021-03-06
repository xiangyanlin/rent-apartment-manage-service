package com.xyl.rental.controller;

import com.xyl.rental.dao.UserDao;
import com.xyl.rental.entity.User;
import com.xyl.rental.service.UserService;
import com.xyl.rental.utils.RandomDataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xyl
 * @version 1.0
 * @date 2020/5/18 20:12
 */
@Api(tags  = "数据生成操作接口")
@RestController
@RequestMapping("gen")
public class GenDataController {
    private static final Logger logger = LoggerFactory.getLogger(GenDataController.class);

    @Resource
    private UserService userService;

    @Resource
    private UserDao userDao;

    /**
     * 随机生成用户列表
     */
    @ApiOperation(value = "随机生成用户列表")
    @RequestMapping("user")
    @ResponseBody
    public void randomGenUserData() {
        List<User> users = new ArrayList<User>();


        for (int i = 0; i < 1000; i++) {
            User user = new User();
            int len = RandomDataUtil.getRandomNum(4, 10);
            user.setUserName(RandomDataUtil.getStringRandom(len));
            user.setPassword("123456");
            user.setAvatar("/images/2020/04/29/2020042908412034305944.png");
            user.setProfession(RandomDataUtil.getProfession());
            user.setRealName(RandomDataUtil.getChineseFamilyName() + RandomDataUtil.getRandomName());
            user.setIdCard(RandomDataUtil.getRandomIdCard());
            user.setEmail(RandomDataUtil.getRandomEmail());
            user.setEducation(String.valueOf(RandomDataUtil.getRandomNum(1, 5)));
            user.setRoleId(1);
            user.setCreateTime(RandomDataUtil.getRandomDate("2018-01-01", "2020-07-01"));
            user.setSex(String.valueOf(RandomDataUtil.getRandomNum(0, 2)));
            user.setIdentify("1");
            user.setMobile(RandomDataUtil.getRandomTel());
            users.add(user);
        }
        userDao.insertBatch(users);
        return;
    }

}
