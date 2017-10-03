package com.menu.wgf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.menu.wgf.mapper.ShaiMapper;
import com.menu.wgf.model.ResultMsg;
import com.menu.wgf.model.Shai;
import com.menu.wgf.query.ShaiQuery;
import com.menu.wgf.service.ShaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 */
@Service
public class ShaiServiceImpl implements ShaiService {

    @Autowired
    private ShaiMapper shaiMapper;

    @Autowired
    private ShaiQuery shaiQuery;

    @Override
    public ResultMsg commentShai(int userPkId, int shaiPkId, String commentContent) {
        return null;
    }

    @Override
    public ResultMsg deleteCommentShai(int commentPkId) {
        return null;
    }

    @Override
    public ResultMsg getCommentShaiList(int shaiPkId) {
        return null;
    }

    @Override
    public ResultMsg uploadShaiIcon(Integer userPkId, Integer type, MultipartFile shaiPicture) {
        return null;
    }

    @Override
    public ResultMsg deleteShai(int shaiPkId) {
        return null;
    }

    @Override
    public ResultMsg getShai(int userPkId) {
        return null;
    }

    @Override
    public ResultMsg getShaiList(int pageNo) {

        PageHelper.startPage(pageNo,6);
        //List<Shai> shais =  shaiMapper.selectByExample(null);
        List<Map> maps = shaiQuery.getAllShaiList();

        //PageInfo<Shai> pageInfo = new PageInfo<>(shais);
        if(maps.size()>0){
            return ResultMsg.success().addContent("content",maps);
        }
        return ResultMsg.failed().addContent("content","获取失败");
    }
}
