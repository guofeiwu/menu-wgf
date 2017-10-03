package com.menu.wgf;

import com.menu.wgf.service.ShaiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author guofei_wu
 * email guofei_wu@163.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShaiServiceImplTest {

    @Autowired
    ShaiService shaiService;

    @Test
    public void test(){
        shaiService.getShaiList(2);
    }

}
