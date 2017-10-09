package com.menu.wgf.service.impl;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.menu.wgf.config.jwt.JwtUtil;
import com.menu.wgf.dto.CommentDataObject;
import com.menu.wgf.dto.ShaiDataObject;
import com.menu.wgf.mapper.CommentMapper;
import com.menu.wgf.mapper.LikeMapper;
import com.menu.wgf.mapper.ShaiMapper;
import com.menu.wgf.mapper.UserMapper;
import com.menu.wgf.model.*;
import com.menu.wgf.query.ShaiQuery;
import com.menu.wgf.service.ShaiService;
import com.menu.wgf.util.IOUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.menu.wgf.Constants.FILE_TYPE_SHAI;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 */
@Service
@Transactional(rollbackFor = Exception.class)
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
        Comment comment = new Comment();
        comment.settCommentPkid(commentPkId);
        comment.settCommentDelete(-1);
        comment.settCommentUdt(new Date());
        int result = commentMapper.updateByPrimaryKeySelective(comment);
        if(result == 1){
            return ResultMsg.success().addContent("content","删除成功");
        }
        return ResultMsg.failed().addContent("content","删除失败");
    }

    @Override
    public ResultMsg getCommentShaiList(JwtUtil jwtUtil,int shaiPkId,int pageNo) {
        CommentCriteria commentCriteria = new CommentCriteria();
        commentCriteria.createCriteria()
                .andTCommentDeleteEqualTo(0)
                .andTCommentShaiPkidEqualTo(shaiPkId);


        PageHelper.startPage(pageNo,6);
        PageHelper.orderBy("t_comment_cdt desc");
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
                commentDataObject.commentPkId = comment.gettCommentPkid();
                Integer currentUserPkId = null;
                try{
                    currentUserPkId = jwtUtil.getLoginPkid();
                }catch (Exception e){
                    //e.printStackTrace();
                    currentUserPkId = null;
                }
                if(currentUserPkId!=null){
                    if(currentUserPkId == userPkId){
                        commentDataObject.currentUser = 0;//是当前用户
                    }else{
                        commentDataObject.currentUser = -1;
                    }
                }else{
                    commentDataObject.currentUser = -1;
                }
                commentDataObjects.add(commentDataObject);
            }
            return ResultMsg.success().addContent("content",commentDataObjects);
        }else if(comments.size() == 0){
            Map map = new HashMap();
            map.put("comment",0);
            return ResultMsg.failed().addContent("content",map);
        }
        Map map = new HashMap();
        map.put("comment",-1);
        return ResultMsg.failed().addContent("content",map);
    }

    @Override
    public ResultMsg uploadShai(Integer userPkId, String desc, MultipartFile shaiPicture) {
        int count = (int) shaiMapper.countByExample(null);//返回晒晒数量
        String urlAddress = IOUtils.uploadShai( (count+1), shaiPicture);

        Shai shai = new Shai();
        shai.settShaiUserPkid(userPkId);
        Date date = new Date();
        shai.settShaiCdt(date);
        shai.settShaiUdt(date);
        shai.settShaiPictureAddress(urlAddress);
        shai.settShaiDesc(desc);

        int result = shaiMapper.insertSelective(shai);
        if(result == 1){
            return ResultMsg.success().addContent("content","上传成功");
        }
        return ResultMsg.success().addContent("content","上传失败");
    }

    @Override
    public ResultMsg deleteShai(int shaiPkId) {
        Shai shai= new Shai();
        shai.settShaiPkid(shaiPkId);
        shai.settShaiDelete(-1);
        shai.settShaiUdt(new Date());
        int result = shaiMapper.updateByPrimaryKeySelective(shai);
        if(result == 1){
            return ResultMsg.success().addContent("content","删除成功");
        }
        return ResultMsg.failed().addContent("content","删除失败");
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
                shaiDataObject.lookTotal = (int) map.get("look");


                //点赞总数
                LikeCriteria criteria = new LikeCriteria();
                criteria.createCriteria()
                        .andTLikeDeleteEqualTo(0)
                        .andTLikeShaiPkidEqualTo(pkid);
                int count = (int) likeMapper.countByExample(criteria);

                shaiDataObject.shaiLike = count;

                //评论总数
                CommentCriteria commentCriteria = new CommentCriteria();
                commentCriteria.createCriteria()
                        .andTCommentDeleteEqualTo(0)
                        .andTCommentShaiPkidEqualTo(pkid);
                int commentTotal = (int) commentMapper.countByExample(commentCriteria);
                shaiDataObject.commentTotal = commentTotal;

                shais.add(shaiDataObject);
            }
            return ResultMsg.success().addContent("content",shais);
        }
        return ResultMsg.failed().addContent("content","获取失败");
    }

    @Override
    public ResultMsg getShaiDetail(JwtUtil jwtUtil, int shaiPkId) {
        Map map = shaiQuery.getShaiDetail(shaiPkId);
        if(map == null){
            return ResultMsg.failed().addContent("content","获取详情失败");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ShaiDataObject shaiDataObject = new ShaiDataObject();
        int pkid = (int) map.get("pkid");
        shaiDataObject.pkid = pkid;
        shaiDataObject.address = (String) map.get("address");
        shaiDataObject.userName = (String) map.get("userName");
        shaiDataObject.icon = (String) map.get("icon");
        shaiDataObject.descr = (String) map.get("descr");
        String date = sdf.format(map.get("cTime"));
        shaiDataObject.cTime = date;
        shaiDataObject.lookTotal = (int) map.get("look");

        //点赞总数
        LikeCriteria criteria = new LikeCriteria();
        criteria.createCriteria()
                .andTLikeDeleteEqualTo(0)
                .andTLikeShaiPkidEqualTo(pkid);
        int count = (int) likeMapper.countByExample(criteria);

        shaiDataObject.shaiLike = count;

        //评论总数
        CommentCriteria commentCriteria = new CommentCriteria();
        commentCriteria.createCriteria()
                .andTCommentDeleteEqualTo(0)
                .andTCommentShaiPkidEqualTo(pkid);
        int commentTotal = (int) commentMapper.countByExample(commentCriteria);
        shaiDataObject.commentTotal = commentTotal;
        Integer userPkId = null;
        try{
            userPkId = jwtUtil.getLoginPkid();
        }catch (Exception e){
            //e.printStackTrace();
            userPkId = null;
        }
        if(userPkId!=null){
            ShaiCriteria criteria1 = new ShaiCriteria();
            criteria1.createCriteria()
                    .andTShaiPkidEqualTo(shaiPkId)
                    .andTShaiUserPkidEqualTo(userPkId)
                    .andTShaiDeleteEqualTo(0);
            List<Shai> shais = shaiMapper.selectByExample(criteria1);
            if(shais.size()>0){
                shaiDataObject.currentUser = 0;
            }else {
                shaiDataObject.currentUser = -1;
            }
        }else{
            shaiDataObject.currentUser = -1;
        }
        return ResultMsg.success().addContent("content",shaiDataObject);
    }

    @Override
    public ResultMsg updateShaiLook(int lookTotal,int shaiPkId) {
        Shai shai = new Shai();
        Date date = new Date();
        shai.settShaiUdt(date);
        shai.settShaiPkid(shaiPkId);
        shai.settShaiLook(lookTotal);
        int reslut = shaiMapper.updateByPrimaryKeySelective(shai);
        if(reslut == 1){
            return ResultMsg.success().addContent("content","更新成功");
        }
        return ResultMsg.failed().addContent("content","更新失败");
    }
}
