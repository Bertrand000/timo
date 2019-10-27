package com.linln.admin.system.controller.gateway;

import com.linln.modules.system.domain.GatewayMemu;
import com.linln.modules.system.service.GatewayMemuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：chenmm
 * @date ：Created in 2019/10/27 17:31
 * @description：门户页面控制器
 * @modified By：
 * @version: 1.0
 */
@Controller
@RequestMapping("/gateway/index/")
public class indexController {

    @Autowired
    GatewayMemuManageService memuManageService;

    /**
      * IndexView
     * @params [model]
     * @Description 首页视图<br/>
     * @return java.lang.String
     * @author 陈某某
     * @createTime 2019/9/10 16:04
       */
    @RequestMapping("view")
    public String IndexView(Model model){
        List<GatewayMemu> oneLevel = memuManageService.listAllOneLevel();
        List<GatewayMemu> twoLevel = memuManageService.listAllTwoLevel();
        List<List> handledMemu = memuHandle(twoLevel);
        model.addAttribute("oneLevel",oneLevel);
        model.addAttribute("twoLevel",twoLevel);
        model.addAttribute("newSee",handledMemu.get(0));
        model.addAttribute("other",handledMemu.get(1));
        model.addAttribute("oneStyle",handledMemu.get(2));
        return "/gateway/index";
    }


    /**
      *
     * @params
     * @Description 菜单分类处理  <br/>
     * @return
     * @author chenmoumou
     * @createTime 2019/10/23 14:41
     */
    public List<List> memuHandle(List<GatewayMemu> mList){
        List<GatewayMemu> seeList = new ArrayList<>();
        List<GatewayMemu> otherList = new ArrayList<>();
        List<GatewayMemu> oneStyleList = new ArrayList<>();
        List<List> newsList = new ArrayList<>();
        for (GatewayMemu m: mList ) {
            if(m.getAttribute()==1 && m.getStyle() == 2)
                seeList.add(m);
            if(m.getAttribute()==2 && m.getStyle() == 2)
                otherList.add(m);
            if(m.getStyle() == 1)
                oneStyleList.add(m);
        }

        newsList.add(seeList);
        newsList.add(otherList);
        newsList.add(oneStyleList);

        return newsList;
    }
}
