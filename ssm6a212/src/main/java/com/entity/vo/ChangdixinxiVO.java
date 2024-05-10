package com.entity.vo;

import com.entity.ChangdixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 场地信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-05-25 17:18:32
 */
public class ChangdixinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 场地类型
	 */
	
	private String changdileixing;
		
	/**
	 * 场地图片
	 */
	
	private String changditupian;
		
	/**
	 * 场地状态
	 */
	
	private String changdizhuangtai;
		
	/**
	 * 场地区域
	 */
	
	private String changdiquyu;
		
	/**
	 * 容纳人数
	 */
	
	private String rongnarenshu;
		
	/**
	 * 场地费用
	 */
	
	private Integer changdifeiyong;
		
	/**
	 * 可约时间
	 */
	
	private String keyueshijian;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 场地详情
	 */
	
	private String changdixiangqing;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
	/**
	 * 设置：场地类型
	 */
	 
	public void setChangdileixing(String changdileixing) {
		this.changdileixing = changdileixing;
	}
	
	/**
	 * 获取：场地类型
	 */
	public String getChangdileixing() {
		return changdileixing;
	}
				
	
	/**
	 * 设置：场地图片
	 */
	 
	public void setChangditupian(String changditupian) {
		this.changditupian = changditupian;
	}
	
	/**
	 * 获取：场地图片
	 */
	public String getChangditupian() {
		return changditupian;
	}
				
	
	/**
	 * 设置：场地状态
	 */
	 
	public void setChangdizhuangtai(String changdizhuangtai) {
		this.changdizhuangtai = changdizhuangtai;
	}
	
	/**
	 * 获取：场地状态
	 */
	public String getChangdizhuangtai() {
		return changdizhuangtai;
	}
				
	
	/**
	 * 设置：场地区域
	 */
	 
	public void setChangdiquyu(String changdiquyu) {
		this.changdiquyu = changdiquyu;
	}
	
	/**
	 * 获取：场地区域
	 */
	public String getChangdiquyu() {
		return changdiquyu;
	}
				
	
	/**
	 * 设置：容纳人数
	 */
	 
	public void setRongnarenshu(String rongnarenshu) {
		this.rongnarenshu = rongnarenshu;
	}
	
	/**
	 * 获取：容纳人数
	 */
	public String getRongnarenshu() {
		return rongnarenshu;
	}
				
	
	/**
	 * 设置：场地费用
	 */
	 
	public void setChangdifeiyong(Integer changdifeiyong) {
		this.changdifeiyong = changdifeiyong;
	}
	
	/**
	 * 获取：场地费用
	 */
	public Integer getChangdifeiyong() {
		return changdifeiyong;
	}
				
	
	/**
	 * 设置：可约时间
	 */
	 
	public void setKeyueshijian(String keyueshijian) {
		this.keyueshijian = keyueshijian;
	}
	
	/**
	 * 获取：可约时间
	 */
	public String getKeyueshijian() {
		return keyueshijian;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
				
	
	/**
	 * 设置：场地详情
	 */
	 
	public void setChangdixiangqing(String changdixiangqing) {
		this.changdixiangqing = changdixiangqing;
	}
	
	/**
	 * 获取：场地详情
	 */
	public String getChangdixiangqing() {
		return changdixiangqing;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
