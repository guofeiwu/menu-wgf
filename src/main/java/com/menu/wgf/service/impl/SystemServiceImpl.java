package com.menu.wgf.service.impl;

import com.menu.wgf.config.jwt.JwtUtil;
import com.menu.wgf.mapper.FeedbackMapper;
import com.menu.wgf.model.Feedback;
import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.service.SystemService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * @author guofei_wu
 * email guofei_wu@163.com
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SystemServiceImpl implements SystemService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResultMsg feedback(Map map) {

        Integer userPkId = jwtUtil.getLoginPkid();

        String content = (String) map.get("feedback");

        Feedback feedback = new Feedback();

        feedback.settFeedbackContent(content);
        if(userPkId!=null){
            feedback.settFeedbackUserPkid(userPkId);
        }
        Date date = new Date();
        feedback.settFeedbackCdt(date);
        feedback.settFeedbackUdt(date);
        int result = feedbackMapper.insertSelective(feedback);
        if(result == 1){
            return ResultMsg.success().addContent("content","提交成功");
        }
        return ResultMsg.failed().addContent("content","提交失败");
    }

    @Override
    public ResultMsg getAboutUs() {
        return null;
    }

    @Override
    public ResultMsg updateVersion(int oldVer) {
        return null;
    }
}
