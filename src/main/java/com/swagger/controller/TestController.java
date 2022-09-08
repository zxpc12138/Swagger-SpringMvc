package com.swagger.controller;

import com.swagger.entiry.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:钟湘
 * @data: 17:40
 */

@Tag(name = "TestController",description = "这是一个测试类")
@Controller
public class TestController {

    /**
     * 这样@Parameter的description属性可以实现但是请求方式只能是GET,其他请求方式会让次方法没有参数
     * 除非将注解写在外面
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/Test",method = RequestMethod.GET)
    @Operation(summary = "这是一个测试方法")
//    @Parameters({
//            @Parameter(name = "name",description = "姓名",required = true),
//            @Parameter(name ="age",description = "年龄",required = true)
//    })
    @ApiResponses({
            @ApiResponse(responseCode = "200",description="成功"),
            @ApiResponse(responseCode = "500",description ="内部错误"),
            @ApiResponse(responseCode = "400",description = "参数错误"),
            @ApiResponse(responseCode = "403",description = "没权限"),
            @ApiResponse(responseCode = "404",description = "路径找不到")
    })
    @ResponseBody
    public String Test(@Parameter(description = "用户名") String name,@Parameter(description = "年龄") Integer age){
            System.out.println(name);
            System.out.println(age);
            return "aa";
    }


    /**
     * 这样@Parameter注解的description属性无法实现
     * @param name
     * @return
     */
    @ApiResponses({
            @ApiResponse(responseCode = "404",description = "请求找不到")
    })
    @Parameters({
            @Parameter(name = "name",description = "用户名")
    })
    @Operation(method = "POST",summary = "用于测试访问",description = "里面就随便打印")
    @ResponseBody
    @RequestMapping(value = "/testGet",method = RequestMethod.DELETE)
    public User testGet(String name){
        System.out.println(name);
        System.out.println("testGet");
        return new User();
    }
}
