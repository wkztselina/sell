package com.wkzt.sell.utils;

import com.wkzt.sell.vo.ResultVO;

/**
 * @Author hanchao
 * @Data 2017/10/30 16:47
 */
public class ResultVOUtil {

    public static ResultVO success(Object o){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(o);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static  ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
