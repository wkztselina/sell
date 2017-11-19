package com.wkzt.sell.controller;

import com.wkzt.sell.enums.ResultEnum;
import com.wkzt.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

/**
 * @Author hanchao
 * @Data 2017/11/6 15:54
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {
    //1、配置
    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl){
        //2、调用方法
        String url="http://smyjew.natappfree.cc/sell/wechat/userInfo";
        String result=wxMpService.oauth2buildAuthorizationUrl(url,WxConsts.OAUTH2_SCOPE_USER_INFO, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权】获取code，result=｛｝",result);
        return "redirect:"+result;
    }

    @GetMapping("/userInfo")
    public String  userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl){
        System.out.println(code);
        System.out.println(returnUrl);
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken= new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken= wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】｛｝",e);
            throw  new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(),e.getError().getErrorMsg());
        }
        String openId=wxMpOAuth2AccessToken.getOpenId();

        return "redirect:"+returnUrl+"?openid="+openId;

    }




}
