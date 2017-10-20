package com.menu.wgf.service.impl;

import com.github.pagehelper.PageHelper;
import com.menu.wgf.config.jwt.JwtUtil;
import com.menu.wgf.dto.*;
import com.menu.wgf.mapper.*;
import com.menu.wgf.model.*;
import com.menu.wgf.query.MenuQuery;
import com.menu.wgf.service.MenuService;
import com.menu.wgf.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author guofei_wu
 *         email guofei_wu@163.com
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

        String zao = "早";String zhong = "中";String wan = "晚"; String yeXiao = "夜";
        int pageNo = menuConditionDataObject.pageNo;
        Integer type = menuConditionDataObject.pType;
        Integer sunType = menuConditionDataObject.sunType;
        String keyword = menuConditionDataObject.keyword;


        Integer userPkId = jwtUtil.getLoginPkid();

        Map map = new HashMap(4);

        if (type != null) {
            map.put("pType", String.valueOf(type));
        } else {
            map.put("pType", type);
        }

        if (sunType != null) {
            map.put("sunType", String.valueOf(sunType));
        } else {
            map.put("sunType", sunType);
        }
        if (keyword != null) {
            if (keyword.contains(zao)) {
                map.put("sunType", 0);
            } else if (keyword.contains(zhong)) {
                map.put("sunType", 1);
            } else if (keyword.contains(wan)) {
                map.put("sunType", 2);
            } else if (keyword.contains(yeXiao)) {
                map.put("sunType", 3);
            }
        }
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
                //是当前用户，-1表示不是当前用户
                menuDataObject.currentUser = 0;
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
                //not current user
                menuDataObject.currentUser = -1;
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
                    if (currentUserPkId != null && Objects.equals(uPkId, currentUserPkId)) {
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
                    if (currentUserPkId != null && currentUserPkId == collectUserPkId) {
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
                    //是当前用户
                    commentDataObject.currentUser = 0;
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
        if (result == 1) {
            Map map = new HashMap();
            map.put("pkId", collect.gettCollectPkid());
            return ResultMsg.success().addContent("content", map);
        } else {
            Map map = new HashMap();
            map.put("pkId", -1);
            return ResultMsg.failed().addContent("content", map);
        }
    }

    @Override
    public ResultMsg notCollectMenu(int collectPkId) {
        Collect collect = new Collect();
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
    public ResultMsg commentMenu(CommentDataObject commentDataObject) {
        int userPkId = jwtUtil.getLoginPkid();
        int menuPkId = commentDataObject.menuPkId;
        String content = commentDataObject.content;
        Comment comment = new Comment();
        comment.settCommentUserPkid(userPkId);
        comment.settCommentMenuPkid(menuPkId);
        comment.settCommentContent(content);
        Date date = new Date();
        comment.settCommentCdt(date);
        comment.settCommentUdt(date);
        int result = commentMapper.insertSelective(comment);
        if (result == 1) {
            //返回一个评论对象
            User user = userMapper.selectByPrimaryKey(userPkId);
            String userIconUrl = user.gettUserIcon();
            String username = user.gettUserName();
            CommentDataObject commentDataObject1 = new CommentDataObject();
            commentDataObject1.userIconUrl = userIconUrl;
            commentDataObject1.username = username;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            commentDataObject1.commentTime = sdf.format(comment.gettCommentCdt());
            commentDataObject1.content = comment.gettCommentContent();
            commentDataObject1.commentPkId = comment.gettCommentPkid();
            //是当前用户
            commentDataObject1.currentUser = 0;
            return ResultMsg.success().addContent("content", commentDataObject1);
        }
        return ResultMsg.failed().addContent("content", "评论失败");
    }

    @Override
    public ResultMsg getBannerMenu() {
        List<Map> maps = menuQuery.getBanners();
        if (maps.size() > 0) {
            List<BannerDataObject> bannerDataObjects = new ArrayList<>();
            for (Map map : maps) {
                BannerDataObject bannerDataObject = new BannerDataObject();
                bannerDataObject.menuPkId = (int) map.get("menuPkId");
                bannerDataObject.menuDesc = (String) map.get("menuDesc");
                bannerDataObject.mainIcon = (String) map.get("mainIcon");
                bannerDataObjects.add(bannerDataObject);
            }
            return ResultMsg.success().addContent("content", bannerDataObjects);
        }
        return ResultMsg.failed().addContent("content", "获取banner失败");
    }

    @Override
    public ResultMsg uploadMenuCover(String menuName, String menuDesc, Integer menuType, Integer menuTypeSun, MultipartFile cover) {
        int lastPkId = menuQuery.getMenuLast();
        int menuPkId = IOUtils.uploadMenuCover(lastPkId, cover);
        int userPkId = jwtUtil.getLoginPkid();
        String menuName1 = menuName;
        String menuDesc1 = menuDesc;
        String menuIconPath;
        //父类型
        int menuType1 = menuType;
        //子类型
        int menuTypeSun1 = menuTypeSun;
        if (menuPkId != 0) {
            menuIconPath = "menu" + menuPkId;
        } else {
            return ResultMsg.failed().addContent("content", "上传失败");
        }
        Menu menu = new Menu();
        menu.settMenuName(menuName1);
        menu.settMenuDescription(menuDesc1);
        menu.settMenuMainIcon(menuIconPath);
        menu.settMenuUserPkid(userPkId);
        //表示还未全部完成
        menu.settMenuDelete(-1);
        menu.settMenuType(menuType1);
        menu.settMenuTypeSun(menuTypeSun1);
        Date date = new Date();
        menu.settMenuCdt(date);
        menu.settMenuUdt(date);
        //int result = menuMapper.insertSelective(menu);
        int result = 1;
        if (result == 1) {
            Map<String, Object> map = new HashMap<>();
            map.put("menuPkId", menuPkId);
            return ResultMsg.success().addContent("content", map);
        }
        return ResultMsg.failed().addContent("content", "上传失败");
    }


    @Override
    public ResultMsg uploadMenuCover(MultipartFile cover) {
        String coverName = IOUtils.uploadMenuCover(cover);
        if (coverName != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("mainIcon", coverName);
            return ResultMsg.success().addContent("content", map);
        }
        return ResultMsg.failed().addContent("content", "上传失败");
    }


    @Override
    public ResultMsg upStepPicture(List<MultipartFile> stepPicture) {
        List<Map<String, Object>> urls = IOUtils.uploadMenuStepPicture(stepPicture);
        if (urls != null) {
            return ResultMsg.success().addContent("content", urls);
        }
        return ResultMsg.failed().addContent("content", "上传失败");
    }

    @Override
    public ResultMsg upMenuContent(MenuContentDataObject menuContentDataObject) {
        System.out.println("menuContentDataObject:" + menuContentDataObject.toString());

        int userPkId = jwtUtil.getLoginPkid();

        //菜谱信息
        Map<String, Object> menuInfo = menuContentDataObject.menuInfo;

        String mainIcon = (String) menuInfo.get("mainIcon");
        String menuName = (String) menuInfo.get("menuName");
        String menuDesc = (String) menuInfo.get("menuDesc");
        Integer menuType = (Integer) menuInfo.get("menuType");
        Integer menuTypeSun = (Integer) menuInfo.get("menuTypeSun");
        Menu menu = new Menu();
        menu.settMenuUserPkid(userPkId);
        menu.settMenuMainIcon(mainIcon);
        menu.settMenuName(menuName);
        menu.settMenuDescription(menuDesc);
        menu.settMenuType(menuType);
        menu.settMenuTypeSun(menuTypeSun);
        Date dateMenu = new Date();
        menu.settMenuCdt(dateMenu);
        menu.settMenuUdt(dateMenu);

        int result = menuMapper.insertSelective(menu);
        if (result == 1) {
            int menuPkId = menu.gettMenuPkid();
            //材料信息
            List<Map<String, Object>> materialses = menuContentDataObject.materialses;
            List<Material> materials = new ArrayList<>();
            for (Map<String, Object> map : materialses) {
                String materialsName = (String) map.get("materialsName");
                String materialsDose = (String) map.get("materialsDose");
                Material material = new Material();
                material.settMaterialMenuPkid(menuPkId);
                material.settMaterialName(materialsName + "     " + materialsDose);
                Date date = new Date();
                material.settMaterialCdt(date);
                material.settMaterialUdt(date);
                materials.add(material);
            }
            menuQuery.insertMenuMaterials(materials);
            //步骤信息
            List<Map<String, Object>> steps = menuContentDataObject.steps;
            List<Step> stepList = new ArrayList<>();
            for (Map<String, Object> map : steps) {
                String desc = (String) map.get("desc");
                String url = (String) map.get("url");
                Step step = new Step();
                step.settStepMenuPkid(menuPkId);
                step.settStepDescription(desc);
                step.settStepPicAddress(url);
                Date date = new Date();
                step.settStepCdt(date);
                step.settStepUdt(date);
                stepList.add(step);
            }
            menuQuery.insertMenuSteps(stepList);
            User user = userMapper.selectByPrimaryKey(userPkId);
            Integer point = user.gettUserPoint();
            int p = (int) ((Math.random() * 20) + 1);
            int lastPoint = p + point;

            int level1 = 31, level2 = 101, level3 = 201, level4 = 501, level5 = 1001, level6 = 3001;
            //一级
            if (lastPoint >= 0 && lastPoint < level1) {
                user.settUserLevel("1级");
                //两级
            } else if (lastPoint >= level1 && lastPoint < level2) {
                user.settUserLevel("2级");
                //三级
            } else if (lastPoint > level2 && lastPoint < level3) {
                user.settUserLevel("3级");
            } else if (lastPoint > level3 && lastPoint < level4) {
                user.settUserLevel("4级");
            } else if (lastPoint > level4 && lastPoint < level5) {
                user.settUserLevel("5级");
            } else if (lastPoint > level5 && lastPoint < level6) {
                user.settUserLevel("6级");
            } else {
                //七级
                user.settUserLevel("7级");
            }
            user.settUserPoint(lastPoint);
            user.settUserUdt(new Date());
            int pointResult = userMapper.insertSelective(user);
            if (pointResult == 1) {
                return ResultMsg.success().addContent("content", "上传菜谱成功");
            }
        }

        return ResultMsg.failed().addContent("content", "上传菜谱失败");
    }



    @Override
    public ResultMsg getUserCollectMenuList(int pageNo) {

        Integer userPkId = jwtUtil.getLoginPkid();
        PageHelper.startPage(pageNo, 6);
        //获取用户收藏菜谱的列表
        List<Map> maps = menuQuery.getUserCollectList(userPkId);
        if (maps.size()>0) {
            List<MenuDataObject> menuDataObjects = new ArrayList<>();
            for (Map m : maps) {
                MenuDataObject menuDataObject = new MenuDataObject();
                menuDataObject.collectPkId = (int) m.get("collectPkId");
                menuDataObject.menuPkId = (int) m.get("menuPkId");
                menuDataObject.menuName = (String) m.get("menuName");
                menuDataObject.introduce = (String) m.get("descr");
                menuDataObject.mainIcon = (String) m.get("mainIcon");
                User user = userMapper.selectByPrimaryKey(userPkId);
                menuDataObject.userIconUrl = user.gettUserIcon();
                menuDataObject.userName = user.gettUserName();
                //是当前用户
                menuDataObject.currentUser = 0;
                menuDataObjects.add(menuDataObject);
            }
            return ResultMsg.success().addContent("content", menuDataObjects);
        }
        return ResultMsg.failed().addContent("content", "获取用户收藏菜谱失败");
    }



    @Override
    public ResultMsg getUserMenuList(int pageNo) {
        Integer userPkId = jwtUtil.getLoginPkid();
        PageHelper.startPage(pageNo, 6);
        List<Map> maps = menuQuery.getUserMenuList(userPkId);
        if (maps.size()>0) {
            List<MenuDataObject> menuDataObjects =getMenus(userPkId,maps);
            return ResultMsg.success().addContent("content", menuDataObjects);
        }
        return ResultMsg.failed().addContent("content", "获取用户发布的菜谱失败");
    }

    @Override
    public ResultMsg getUserCommentMenuList(int pageNo) {
        Integer userPkId = jwtUtil.getLoginPkid();
        PageHelper.startPage(pageNo, 6);
        List<Map> maps = menuQuery.getUserCommentMenuList(userPkId);
        if (maps.size()>0) {
            List<MenuDataObject> menuDataObjects =getMenus(userPkId,maps);
            return ResultMsg.success().addContent("content", menuDataObjects);
        }
        return ResultMsg.failed().addContent("content", "获取用户发布的菜谱失败");
    }

    /**
     * 获取菜谱
     * @param userPkId
     * @param maps
     * @return
     */
    private List<MenuDataObject> getMenus(Integer userPkId,List<Map> maps){
        List<MenuDataObject> menuDataObjects = new ArrayList<>();
        if (maps.size()>0) {
            for (Map m : maps) {
                MenuDataObject menuDataObject = new MenuDataObject();
                menuDataObject.menuPkId = (int) m.get("menuPkId");
                menuDataObject.menuName = (String) m.get("menuName");
                menuDataObject.introduce = (String) m.get("descr");
                menuDataObject.mainIcon = (String) m.get("mainIcon");
                User user = userMapper.selectByPrimaryKey(userPkId);
                menuDataObject.userIconUrl = user.gettUserIcon();
                menuDataObject.userName = user.gettUserName();
                //是当前用户
                menuDataObject.currentUser = 0;
                menuDataObjects.add(menuDataObject);
            }
            return menuDataObjects;
        }
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
