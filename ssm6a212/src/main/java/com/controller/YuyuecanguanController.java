package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YuyuecanguanEntity;
import com.entity.view.YuyuecanguanView;

import com.service.YuyuecanguanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 预约参观
 * 后端接口
 * @author 
 * @email 
 * @date 2021-05-25 17:18:32
 */
@RestController
@RequestMapping("/yuyuecanguan")
public class YuyuecanguanController {
    @Autowired
    private YuyuecanguanService yuyuecanguanService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyuecanguanEntity yuyuecanguan, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			yuyuecanguan.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyuecanguanEntity> ew = new EntityWrapper<YuyuecanguanEntity>();
		PageUtils page = yuyuecanguanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuecanguan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyuecanguanEntity yuyuecanguan, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			yuyuecanguan.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyuecanguanEntity> ew = new EntityWrapper<YuyuecanguanEntity>();
		PageUtils page = yuyuecanguanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuecanguan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyuecanguanEntity yuyuecanguan){
       	EntityWrapper<YuyuecanguanEntity> ew = new EntityWrapper<YuyuecanguanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyuecanguan, "yuyuecanguan")); 
        return R.ok().put("data", yuyuecanguanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyuecanguanEntity yuyuecanguan){
        EntityWrapper< YuyuecanguanEntity> ew = new EntityWrapper< YuyuecanguanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyuecanguan, "yuyuecanguan")); 
		YuyuecanguanView yuyuecanguanView =  yuyuecanguanService.selectView(ew);
		return R.ok("查询预约参观成功").put("data", yuyuecanguanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyuecanguanEntity yuyuecanguan = yuyuecanguanService.selectById(id);
        return R.ok().put("data", yuyuecanguan);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyuecanguanEntity yuyuecanguan = yuyuecanguanService.selectById(id);
        return R.ok().put("data", yuyuecanguan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuecanguanEntity yuyuecanguan, HttpServletRequest request){
    	yuyuecanguan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuecanguan);

        yuyuecanguanService.insert(yuyuecanguan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyuecanguanEntity yuyuecanguan, HttpServletRequest request){
    	yuyuecanguan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuecanguan);
    	yuyuecanguan.setUserid((Long)request.getSession().getAttribute("userId"));

        yuyuecanguanService.insert(yuyuecanguan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YuyuecanguanEntity yuyuecanguan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuecanguan);
        yuyuecanguanService.updateById(yuyuecanguan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyuecanguanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YuyuecanguanEntity> wrapper = new EntityWrapper<YuyuecanguanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			wrapper.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = yuyuecanguanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
