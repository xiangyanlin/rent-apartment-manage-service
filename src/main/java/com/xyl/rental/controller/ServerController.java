package com.xyl.rental.controller;


import com.xyl.rental.entity.Server;
import com.xyl.rental.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xyl
 * @create 2020/4/29 9:42
 */
@Api(description = "服务监控操作接口")
@RestController
@RequestMapping("/monitor/server")
public class ServerController {

    /**
     * 获取运行服务器监控信息
     * @return
     */
    @ApiOperation(value = "获取运行服务器监控信息")
    @GetMapping()
    public R<Server> getInfo(){
        Server server = new Server();
        try {
            server.copyTo();
        }catch (Exception e){
            R.failed("获取信息异常");
        }
        return R.success(server);
    }
}
