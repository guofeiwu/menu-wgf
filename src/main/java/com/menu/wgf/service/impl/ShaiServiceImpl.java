package com.menu.wgf.service.impl;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.menu.wgf.dto.CommentDataObject;
import com.menu.wgf.dto.ShaiDataObject;
import com.menu.wgf.mapper.CommentMapper;
import com.menu.wgf.mapper.LikeMapper;
import com.menu.wgf.mapper.ShaiMapper;
import com.menu.wgf.mapper.UserMapper;
import com.menu.wgf.model.*;
import com.menu.wgf.query.ShaiQuery;
import com.menu.wgf.service.ShaiService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultMsg likeShai(int userPkId, int shaiPkId) {
        Like like = new Like();
        Date date = new Date();
        like.settLikeCdt(date);
        like.settLikeUdt(date);
        like.settLikeUserPkid(userPkId);
        like.settLikeShaiPkid(shaiPkId);
        int result = likeMapper.insertSelective(like);
        if(result == 1){
            int likePkid = like.gettLikePkid();
            Map<String,Integer> map = new HashMap<>();
            map.put("likePkId",likePkid);
            return ResultMsg.success().addContent("content",map);
        }else {
            return ResultMsg.failed().addContent("content","操作失败");
        }
    }

    @Override
    public ResultMsg disLikeShai(int likePkId) {
        Like like = new Like();
        like.settLikePkid(likePkId);
        like.settLikeDelete(-1);
        Date date = new Date();
        like.settLikeUdt(date);
        int result = likeMapper.updateByPrimaryKeySelective(like);
        if(result == 1){
            return ResultMsg.success().addContent("content","操作成功");
        }else{
            return ResultMsg.failed().addContent("content","操作失败");
        }
    }

    @Override
    public ResultMsg commentShai(int userPkId,CommentDataObject commentDataObject) {
        int shaiPkId = commentDataObject.shaiPkId;
        String content = commentDataObject.content;
        Comment comment = new Comment();
        comment.settCommentUserPkid(userPkId);
        comment.settCommentShaiPkid(shaiPkId);
        comment.settCommentContent(content);
        Date date = new Date();
        comment.settCommentCdt(date);
        comment.settCommentUdt(date);

        int result = commentMapper.insertSelective(comment);
        if(result == 1){
            return ResultMsg.success().addContent("content","评论成功");
        }
        return ResultMsg.failed().addContent("content","评论失败");
    }

    @Override
    public ResultMsg deleteCommentShai(int commentPkId) {
        return null;
    }

    @Override
    public ResultMsg getCommentShaiList(int shaiPkId,int pageNo) {
        CommentCriteria commentCriteria = new CommentCriteria();
        commentCriteria.createCriteria()
                .andTCommentDeleteEqualTo(0)
                .andTCommentShaiPkidEqualTo(shaiPkId);

        PageHelper.startPage(pageNo,6);
        List<Comment> comments = commentMapper.selectByExample(commentCriteria);
        List<CommentDataObject> commentDataObjects;
        if(comments.size()>0){
            commentDataObjects = new ArrayList<>();
            for (Comment comment:comments){
                int userPkId = comment.gettCommentUserPkid();
                User user = userMapper.selectByPrimaryKey(userPkId);
                String userIconUrl =user.gettUserIcon();
                String username = user.gettUserName();
                CommentDataObject commentDataObject = new CommentDataObject();

                commentDataObject.userIconUrl = userIconUrl;
                commentDataObject.username = username;

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                commentDataObject.commentTime = sdf.format(comment.gettCommentCdt());
                commentDataObject.content = comment.gettCommentContent();
                commentDataObjects.add(commentDataObject);
            }
            return ResultMsg.success().addContent("content",commentDataObjects);
        }else if(comments.size() == 0){
            return ResultMsg.failed().addContent("content","此晒一晒暂无评论");
        }
        return ResultMsg.failed().addContent("content","获取评论失败");
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
    public ResultMsg getLikeShai(int userPkId) {
        LikeCriteria criteria = new LikeCriteria();
        criteria.createCriteria()
                .andTLikeUserPkidEqualTo(userPkId)
                .andTLikeDeleteEqualTo(0);
        List<Like> likes = likeMapper.selectByExample(criteria);
        if(likes.size()>0){
            Map<String,Integer> maps = new HashMap<>();
            for (Like like:likes){
                maps.put(String.valueOf(like.gettLikeShaiPkid()),like.gettLikePkid());
            }
            return ResultMsg.success().addContent("content",maps);
        }
        return ResultMsg.failed().addContent("content","用户暂无点赞");
    }

    @Override
    public ResultMsg getShaiList(int pageNo) {

        PageHelper.startPage(pageNo,6);
        //List<Shai> shais =  shaiMapper.selectByExample(null);
        List<Map> maps = shaiQuery.getAllShaiList();
        List<ShaiDataObject> shais = new ArrayList<>();
        //PageInfo<Shai> pageInfo = new PageInfo<>(shais);
        if(maps.size()>0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(Map map:maps){
                ShaiDataObject shaiDataObject = new ShaiDataObject();
                int pkid = (int) map.get("pkid");
                shaiDataObject.pkid = pkid;
                shaiDataObject.address = (String) map.get("address");
                shaiDataObject.userName = (String) map.get("userName");
                shaiDataObject.icon = (String) map.get("icon");
                shaiDataObject.descr = (String) map.get("descr");
                String date = sdf.format(map.get("cTime"));
                shaiDataObject.cTime = date;

                LikeCriteria criteria = new LikeCriteria();
                criteria.createCriteria()
                        .andTLikeDeleteEqualTo(0)
                        .andTLikeShaiPkidEqualTo(pkid);
                int count = (int) likeMapper.countByExample(criteria);

                shaiDataObject.shaiLike = count;
                shais.add(shaiDataObject);
            }
            return ResultMsg.success().addContent("content",shais);
        }
        return ResultMsg.failed().addContent("content","获取失败");
    }
}
