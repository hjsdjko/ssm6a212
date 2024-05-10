package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuyuecanguanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuyuecanguanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyuecanguanView;


/**
 * 预约参观
 *
 * @author 
 * @email 
 * @date 2021-05-25 17:18:32
 */
public interface YuyuecanguanService extends IService<YuyuecanguanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyuecanguanVO> selectListVO(Wrapper<YuyuecanguanEntity> wrapper);
   	
   	YuyuecanguanVO selectVO(@Param("ew") Wrapper<YuyuecanguanEntity> wrapper);
   	
   	List<YuyuecanguanView> selectListView(Wrapper<YuyuecanguanEntity> wrapper);
   	
   	YuyuecanguanView selectView(@Param("ew") Wrapper<YuyuecanguanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyuecanguanEntity> wrapper);
   	
}

