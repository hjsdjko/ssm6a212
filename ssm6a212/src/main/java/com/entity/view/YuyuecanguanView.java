package com.entity.view;

import com.entity.YuyuecanguanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 预约参观
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-05-25 17:18:32
 */
@TableName("yuyuecanguan")
public class YuyuecanguanView  extends YuyuecanguanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuyuecanguanView(){
	}
 
 	public YuyuecanguanView(YuyuecanguanEntity yuyuecanguanEntity){
 	try {
			BeanUtils.copyProperties(this, yuyuecanguanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
