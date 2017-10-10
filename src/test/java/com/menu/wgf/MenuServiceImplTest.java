package com.menu.wgf;

import com.menu.wgf.mapper.MenuMapper;
import com.menu.wgf.model.Menu;
import com.menu.wgf.model.MenuCriteria;
import com.menu.wgf.query.MenuQuery;
import com.menu.wgf.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceImplTest {

    @Autowired
    MenuQuery menuQuery;


    @Autowired
    MenuMapper menuMapper;

    @Test
    public void test(){

        Map map = new HashMap();
        map.put("type",1);
        map.put("sunType",null);

        List<Map> maps = menuQuery.getMenuList(map);

        System.out.println("maps:"+maps.size());



    }
}
