package com.longbow.gateway.main.web;

import com.alibaba.fastjson.JSON;
import com.longbow.gateway.main.GatedLaunchHelper;
import com.longbow.gateway.main.bo.GatedLaunchData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhangbin on 2018/8/31.
 */
@Slf4j
@RestController
@RequestMapping(value = "/admin")
public class GatedLaunchController {
    @Autowired
    private GatedLaunchHelper helper;
    @Autowired
    private RouteLocator routeLocator;

    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public List<Route> listAllRoute() {
        return routeLocator.getRoutes();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List listAllGate() {
        return helper.getList();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addGate(@RequestBody GatedLaunchData data) {
        log.info("{}", JSON.toJSONString(data));
        helper.addData(data);
    }

    @RequestMapping(value = "/edit/{uuid}", method = RequestMethod.POST)
    public void editGate(@PathVariable("uuid") String uuid, @RequestBody GatedLaunchData data) {
        helper.editData(uuid, data);
    }

    @RequestMapping(value = "/del/{uuid}", method = RequestMethod.DELETE)
    public void delGate(@PathVariable("uuid") String uuid) {
        helper.delData(uuid);
    }
}
