package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YuyuecanguanDao;
import com.entity.YuyuecanguanEntity;
import com.service.YuyuecanguanService;
import com.entity.vo.YuyuecanguanVO;
import com.entity.view.YuyuecanguanView;

@Service("yuyuecanguanService")
public class YuyuecanguanServiceImpl extends ServiceImpl<YuyuecanguanDao, YuyuecanguanEntity> implements YuyuecanguanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyuecanguanEntity> page = this.selectPage(
                new Query<YuyuecanguanEntity>(params).getPage(),
                new EntityWrapper<YuyuecanguanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyuecanguanEntity> wrapper) {
		  Page<YuyuecanguanView> page =new Query<YuyuecanguanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuyuecanguanVO> selectListVO(Wrapper<YuyuecanguanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuyuecanguanVO selectVO(Wrapper<YuyuecanguanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuyuecanguanView> selectListView(Wrapper<YuyuecanguanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyuecanguanView selectView(Wrapper<YuyuecanguanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
