package com.github.bjlhx15.mybatis.springmvc.base.controller;

import com.github.bjlhx15.mybatis.springmvc.base.model.AccountBalanceVo;
import com.github.bjlhx15.mybatis.springmvc.base.model.auto.AccountBalance;
import com.github.bjlhx15.mybatis.springmvc.base.service.IAccountBalanceService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags="用户控制")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountBalanceService service;

    @ApiOperation(value = "用户列表q", httpMethod = "GET",
            notes = "用户列表-分页")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<PageInfo<List<AccountBalance>>> test() {
        System.out.println(1);
        PageInfo<List<AccountBalance>> listPageInfo = service.selectByExample(null);
        return ResponseEntity.ok(listPageInfo);
    }

    @ApiOperation(value = "用户列表Vo",notes = "用户列表Vo-分页")
    @RequestMapping(value = "listvo", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<PageInfo<List<AccountBalanceVo>>> testvo(AccountBalanceVo record) {
        PageInfo<List<AccountBalanceVo>> listPageInfo = service.select(record);
        return ResponseEntity.ok(listPageInfo);
    }
}
