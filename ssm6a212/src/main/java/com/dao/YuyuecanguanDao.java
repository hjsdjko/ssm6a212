package com.dao;

import com.entity.YuyuecanguanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuyuecanguanVO;
import com.entity.view.YuyuecanguanView;


/**
 * 预约参观
 * 
 * @author 
 * @email 
 * @date 2021-05-25 17:18:32
 */
public interface YuyuecanguanDao extends BaseMapper<YuyuecanguanEntity> {
	
	List<YuyuecanguanVO> selectListVO(@Param("ew") Wrapper<YuyuecanguanEntity> wrapper);
	
	YuyuecanguanVO selectVO(@Param("ew") Wrapper<YuyuecanguanEntity> wrapper);
	
	List<YuyuecanguanView> selectListView(@Param("ew") Wrapper<YuyuecanguanEntity> wrapper);

	List<YuyuecanguanView> selectListView(Pagination page,@Param("ew") Wrapper<YuyuecanguanEntity> wrapper);
	
	YuyuecanguanView selectView(@Param("ew") Wrapper<YuyuecanguanEntity> wrapper);
	
}
