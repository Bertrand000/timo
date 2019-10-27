package com.linln.admin.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：chenmm
 * @date ：Created in 2019/10/27 23:24
 * @description：资讯后台管理
 * @modified By：
 * @version:
 */
@Controller
@RequestMapping("/system/news_manage/")
public class newsManageController {

    /**
     * create by: chenmm
     * description: 列表页面
     * create time: 2019/10/27 23:43
     * @Param: null
     * @return
     */
    @GetMapping("/index")
    @RequiresPermissions("system:news_manage:index")
    public String index(Model model){

        return "";
    }
}
