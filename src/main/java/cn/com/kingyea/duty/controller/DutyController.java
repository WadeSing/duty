package cn.com.kingyea.duty.controller;

import cn.com.kingyea.duty.bean.DutyInfo;
import cn.com.kingyea.duty.service.DutyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/duty")
public class DutyController {
    @Autowired
    private DutyInfoService dutyInfoService;


    @RequestMapping("/queryBytime")
    @ResponseBody
    public List<DutyInfo> list() {
        return dutyInfoService.queryBytime();
    }
}
