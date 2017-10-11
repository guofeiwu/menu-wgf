package com.menu.wgf.service.impl;

import com.github.pagehelper.PageHelper;
import com.menu.wgf.config.jwt.JwtUtil;
import com.menu.wgf.dto.CommentDataObject;
import com.menu.wgf.dto.MenuConditionDataObject;
import com.menu.wgf.dto.MenuDataObject;
import com.menu.wgf.dto.StepDataObject;
import com.menu.wgf.mapper.*;
import com.menu.wgf.model.*;
import com.menu.wgf.query.MenuQuery;
import com.menu.wgf.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuQuery menuQuery;

    @Autowired
    private StepMapper stepMapper;

    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private CollectMapper collectMapper;


    @Override
    public ResultMsg getMenuList(MenuConditionDataObject menuConditionDataObject) {

        int pageNo = menuConditionDataObject.pageNo;
        int type = menuConditionDataObject.type;
        int sunType = menuConditionDataObject.sunType;
        String keyword = menuConditionDataObject.keyword;


        Integer userPkId = jwtUtil.getLoginPkid();

        Map map = new HashMap();
        map.put("pType", String.valueOf(type));
        map.put("sunType", String.valueOf(sunType));
        map.put("keyword", keyword);
        PageHelper.startPage(pageNo, 6);
        List<Map> maps = menuQuery.getMenuList(map);
        List<MenuDataObject> menuDataObjects = new ArrayList<>();
        for (Map m : maps) {
            MenuDataObject menuDataObject = new MenuDataObject();
            menuDataObject.menuPkId = (int) m.get("menuPkId");
            menuDataObject.menuName = (String) m.get("menuName");
            menuDataObject.introduce = (String) m.get("descr");
            menuDataObject.mainIcon = (String) m.get("mainIcon");
            int userPkId1 = (int) m.get("userPkId");
            User user = userMapper.selectByPrimaryKey(userPkId1);
            menuDataObject.userIconUrl = user.gettUserIcon();
            menuDataObject.userName = user.gettUserName();

            if (userPkId != null && userPkId == userPkId1) {
                menuDataObject.currentUser = 0;//是当前用户，-1表示不是当前用户
            } else {
                menuDataObject.currentUser = -1;
            }
            menuDataObjects.add(menuDataObject);
        }
        return ResultMsg.success().addContent("content", menuDataObjects);
    }

    @Override
    public ResultMsg getMenuDetail(int menuPkId) {
        try {
            MenuDataObject menuDataObject = new MenuDataObject();

            Menu menu = menuMapper.selectByPrimaryKey(menuPkId);
            menuDataObject.menuPkId = menu.gettMenuPkid();
            menuDataObject.menuName = menu.gettMenuName();
            menuDataObject.mainIcon = menu.gettMenuMainIcon();
            menuDataObject.introduce = menu.gettMenuDescription();
            int userPkId = menu.gettMenuUserPkid();
            User user = userMapper.selectByPrimaryKey(userPkId);
            menuDataObject.userIconUrl = user.gettUserIcon();
            menuDataObject.userName = user.gettUserName();

            Integer currentUserPkId = jwtUtil.getLoginPkid();
            if (currentUserPkId != null && userPkId == currentUserPkId) {
                menuDataObject.currentUser = 0;
            } else {
                menuDataObject.currentUser = -1;//not current user
            }

            // step
            StepCriteria criteria = new StepCriteria();
            criteria.createCriteria()
                    .andTStepDeleteEqualTo(0)
                    .andTStepMenuPkidEqualTo(menuPkId);
            List<Step> steps = stepMapper.selectByExample(criteria);
            List<StepDataObject> stepList = new ArrayList<>();
            for (Step step : steps) {
                StepDataObject stepDataObject = new StepDataObject();
                stepDataObject.stepDesc = step.gettStepDescription();
                stepDataObject.stepIcon = step.gettStepPicAddress();
                stepList.add(stepDataObject);
            }
            menuDataObject.steps = stepList;

            //materials
            MaterialCriteria criteria1 = new MaterialCriteria();
            criteria1.createCriteria()
                    .andTMaterialDeleteEqualTo(0)
                    .andTMaterialMenuPkidEqualTo(menuPkId);

            List<Material> materials = materialMapper.selectByExample(criteria1);
            List<Map<String, Object>> maps = new ArrayList<>();
            for (Material material : materials) {
                Map map = new HashMap();
                map.put("materialName", material.gettMaterialName());
                maps.add(map);
            }
            menuDataObject.materials = maps;

            //点赞总数  判断是否的当前用户点赞
            LikeCriteria likeCriteria = new LikeCriteria();
            likeCriteria.createCriteria()
                    .andTLikeDeleteEqualTo(0)
                    .andTLikeMenuPkidEqualTo(menuPkId);
            List<Like> likes = likeMapper.selectByExample(likeCriteria);
            int likeTotal = likes.size();
            menuDataObject.likeTotal = likeTotal;
            if (likeTotal > 0) {
                for (Like like : likes) {
                    Integer uPkId = like.gettLikeUserPkid();
                    if (uPkId == currentUserPkId && currentUserPkId != null) {
                        menuDataObject.currentLike = 0;
                        menuDataObject.likePkId = like.gettLikePkid();
                        break;
                    } else {
                        menuDataObject.currentLike = -1;
                        menuDataObject.likePkId = -1;
                    }
                }
            } else {
                menuDataObject.currentLike = -1;
                menuDataObject.likePkId = -1;
            }
            //评论总数
            CommentCriteria commentCriteria = new CommentCriteria();
            commentCriteria.createCriteria()
                    .andTCommentMenuPkidEqualTo(menuPkId)
                    .andTCommentDeleteEqualTo(0);
            int commentTotal = (int) commentMapper.countByExample(commentCriteria);
            menuDataObject.commentTotal = commentTotal;

            //收藏总数 判断是否的当前用户收藏
            CollectCriteria collectCriteria = new CollectCriteria();
            collectCriteria.createCriteria()
                    .andTCollectCancelEqualTo(0)
                    .andTCollectMenuPkidEqualTo(menuPkId);
            List<Collect> collects = collectMapper.selectByExample(collectCriteria);
            int collectTotal = collects.size();
            menuDataObject.collectTotal = collectTotal;
            if (collectTotal > 0) {
                for (Collect collect : collects) {
                    int collectUserPkId = collect.gettCollectUserPkid();
                    if (currentUserPkId == collectUserPkId && currentUserPkId != null) {
                        menuDataObject.currentCollect = 0;
                        menuDataObject.collectPkId = collect.gettCollectPkid();
                        break;
                    } else {
                        menuDataObject.currentCollect = -1;
                        menuDataObject.collectPkId = -1;
                    }
                }
            } else {
                menuDataObject.currentCollect = -1;
                menuDataObject.collectPkId = -1;
            }
            return ResultMsg.success().addContent("content", menuDataObject);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.failed().addContent("content", "出现异常！！！");
        }
    }

    @Override
    public ResultMsg getMenuCommentList(int menuPkId, int pageNO) {
        CommentCriteria commentCriteria = new CommentCriteria();
        commentCriteria.createCriteria()
                .andTCommentDeleteEqualTo(0)
                .andTCommentMenuPkidEqualTo(menuPkId);
        PageHelper.startPage(pageNO, 6);
        PageHelper.orderBy("t_comment_cdt desc");
        List<Comment> comments = commentMapper.selectByExample(commentCriteria);
        List<CommentDataObject> commentDataObjects;
        if (comments.size() > 0) {
            commentDataObjects = new ArrayList<>();
            for (Comment comment : comments) {
                int userPkId = comment.gettCommentUserPkid();
                User user = userMapper.selectByPrimaryKey(userPkId);
                String userIconUrl = user.gettUserIcon();
                String username = user.gettUserName();
                CommentDataObject commentDataObject = new CommentDataObject();

                commentDataObject.userIconUrl = userIconUrl;
                commentDataObject.username = username;

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                commentDataObject.commentTime = sdf.format(comment.gettCommentCdt());
                commentDataObject.content = comment.gettCommentContent();
                commentDataObject.commentPkId = comment.gettCommentPkid();
                Integer currentUserPkId = jwtUtil.getLoginPkid();
                if (currentUserPkId != null && currentUserPkId == userPkId) {
                    commentDataObject.currentUser = 0;//是当前用户
                } else {
                    commentDataObject.currentUser = -1;
                }
                commentDataObjects.add(commentDataObject);
            }
            return ResultMsg.success().addContent("content", commentDataObjects);
        } else if (comments.size() == 0) {
            Map map = new HashMap();
            map.put("comment", 0);
            return ResultMsg.failed().addContent("content", map);
        }
        Map map = new HashMap();
        map.put("comment", -1);
        return ResultMsg.failed().addContent("content", map);
    }


    @Override
    public ResultMsg deleteCommentMenu(int commentPkId) {
        Comment comment = new Comment();
        comment.settCommentPkid(commentPkId);
        comment.settCommentDelete(-1);
        comment.settCommentUdt(new Date());
        int result = commentMapper.updateByPrimaryKeySelective(comment);
        if (result == 1) {
            return ResultMsg.success().addContent("content", "删除成功");
        } else {
            return ResultMsg.failed().addContent("content", "删除失败");
        }
    }


    @Override
    public ResultMsg likeMenu(int menuPkId) {
        int userPkId = jwtUtil.getLoginPkid();
        Like like = new Like();
        Date date = new Date();
        like.settLikeCdt(date);
        like.settLikeUdt(date);
        like.settLikeMenuPkid(menuPkId);
        like.settLikeUserPkid(userPkId);
        like.settLikeDelete(0);
        int result = likeMapper.insertSelective(like);
        if (result == 1) {
            Map map = new HashMap();
            map.put("pkId", like.gettLikePkid());
            return ResultMsg.success().addContent("content", map);
        } else {
            Map map = new HashMap();
            map.put("pkId", -1);
            return ResultMsg.failed().addContent("content", map);
        }

    }

    @Override
    public ResultMsg dislikeMenu(int likePkId) {
        Like like = new Like();
        like.settLikePkid(likePkId);
        like.settLikeUdt(new Date());
        like.settLikeDelete(-1);
        int result = likeMapper.updateByPrimaryKeySelective(like);
        Map map = new HashMap();
        map.put("pkId", -1);
        if (result == 1) {
            return ResultMsg.success().addContent("content", map);
        }
        return ResultMsg.failed().addContent("content", map);
    }


    @Override
    public ResultMsg collectMenu(int menuPkId) {
        int userPkId = jwtUtil.getLoginPkid();
        Collect collect = new Collect();
        collect.settCollectMenuPkid(menuPkId);
        collect.settCollectUserPkid(userPkId);
        Date date = new Date();
        collect.settCollectCdt(date);
        collect.settCollectUdt(date);
        collect.settCollectCancel(0);
        int result = collectMapper.insertSelective(collect);
        if(result == 1){
            Map map = new HashMap();
            map.put("pkId",collect.gettCollectPkid());
            return ResultMsg.success().addContent("content",map);
        }else{
            Map map = new HashMap();
            map.put("pkId", -1);
            return ResultMsg.failed().addContent("content", map);
        }
    }

    @Override
    public ResultMsg notCollectMenu(int collectPkId) {
        Collect collect= new Collect();
        collect.settCollectCancel(-1);
        collect.settCollectUdt(new Date());
        collect.settCollectPkid(collectPkId);
        int result = collectMapper.updateByPrimaryKeySelective(collect);
        Map map = new HashMap();
        map.put("pkId", -1);
        if (result == 1) {
            return ResultMsg.success().addContent("content", map);
        }
        return ResultMsg.failed().addContent("content", map);
    }

    @Override
    public ResultMsg commentMenu(int userPkId, int menuPkId, String commentContent) {
        return null;
    }


    @Override
    public ResultMsg getUserCommentMenuList(int userPkId, int pageSize, int pageNo) {
        return null;
    }


    @Override
    public ResultMsg deleteCollectMenu(int collectPkId) {
        return null;
    }

    @Override
    public ResultMsg getUserCollectMenuList(int userPkId, int pageSize, int pageNo) {
        return null;
    }

    @Override
    public ResultMsg searchMenu(String keyword) {
        return null;
    }

    @Override
    public ResultMsg shareMenu(int userPkId, int menuPkId) {
        return null;
    }

    @Override
    public ResultMsg recordMenu(int userPkId, int menuPkId) {
        return null;
    }

    @Override
    public ResultMsg getMenuRank(int type) {
        return null;
    }


}
