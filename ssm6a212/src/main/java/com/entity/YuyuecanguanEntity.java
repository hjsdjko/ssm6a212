package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 预约参观
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-05-25 17:18:32
 */
@TableName("yuyuecanguan")
public class YuyuecanguanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YuyuecanguanEntity() {
		
	}
	
	public YuyuecanguanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 企业账号
	 */
					
	private String qiyezhanghao;
	
	/**
	 * 编号
	 */
					
	private String bianhao;
	
	/**
	 * 场地名称
	 */
					
	private String changdimingcheng;
	
	/**
	 * 场地图片
	 */
					
	private String changditupian;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 代表身份
	 */
					
	private String daibiaoshenfen;
	
	/**
	 * 公司名称
	 */
					
	private String gongsimingcheng;
	
	/**
	 * 职务
	 */
					
	private String zhiwu;
	
	/**
	 * 参观目的
	 */
					
	private String canguanmude;
	
	/**
	 * 参观时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date canguanshijian;
	
	/**
	 * 公司现有员工数
	 */
					
	private String gongsixianyouyuangongshu;
	
	/**
	 * 所需工位数
	 */
					
	private String suoxugongweishu;
	
	/**
	 * 车辆信息
	 */
					
	private String cheliangxinxi;
	
	/**
	 * 其他人员
	 */
					
	private String qitarenyuan;
	
	/**
	 * 手机号
	 */
					
	private String shoujihao;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：企业账号
	 */
	public void setQiyezhanghao(String qiyezhanghao) {
		this.qiyezhanghao = qiyezhanghao;
	}
	/**
	 * 获取：企业账号
	 */
	public String getQiyezhanghao() {
		return qiyezhanghao;
	}
	/**
	 * 设置：编号
	 */
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	/**
	 * 获取：编号
	 */
	public String getBianhao() {
		return bianhao;
	}
	/**
	 * 设置：场地名称
	 */
	public void setChangdimingcheng(String changdimingcheng) {
		this.changdimingcheng = changdimingcheng;
	}
	/**
	 * 获取：场地名称
	 */
	public String getChangdimingcheng() {
		return changdimingcheng;
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
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：代表身份
	 */
	public void setDaibiaoshenfen(String daibiaoshenfen) {
		this.daibiaoshenfen = daibiaoshenfen;
	}
	/**
	 * 获取：代表身份
	 */
	public String getDaibiaoshenfen() {
		return daibiaoshenfen;
	}
	/**
	 * 设置：公司名称
	 */
	public void setGongsimingcheng(String gongsimingcheng) {
		this.gongsimingcheng = gongsimingcheng;
	}
	/**
	 * 获取：公司名称
	 */
	public String getGongsimingcheng() {
		return gongsimingcheng;
	}
	/**
	 * 设置：职务
	 */
	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}
	/**
	 * 获取：职务
	 */
	public String getZhiwu() {
		return zhiwu;
	}
	/**
	 * 设置：参观目的
	 */
	public void setCanguanmude(String canguanmude) {
		this.canguanmude = canguanmude;
	}
	/**
	 * 获取：参观目的
	 */
	public String getCanguanmude() {
		return canguanmude;
	}
	/**
	 * 设置：参观时间
	 */
	public void setCanguanshijian(Date canguanshijian) {
		this.canguanshijian = canguanshijian;
	}
	/**
	 * 获取：参观时间
	 */
	public Date getCanguanshijian() {
		return canguanshijian;
	}
	/**
	 * 设置：公司现有员工数
	 */
	public void setGongsixianyouyuangongshu(String gongsixianyouyuangongshu) {
		this.gongsixianyouyuangongshu = gongsixianyouyuangongshu;
	}
	/**
	 * 获取：公司现有员工数
	 */
	public String getGongsixianyouyuangongshu() {
		return gongsixianyouyuangongshu;
	}
	/**
	 * 设置：所需工位数
	 */
	public void setSuoxugongweishu(String suoxugongweishu) {
		this.suoxugongweishu = suoxugongweishu;
	}
	/**
	 * 获取：所需工位数
	 */
	public String getSuoxugongweishu() {
		return suoxugongweishu;
	}
	/**
	 * 设置：车辆信息
	 */
	public void setCheliangxinxi(String cheliangxinxi) {
		this.cheliangxinxi = cheliangxinxi;
	}
	/**
	 * 获取：车辆信息
	 */
	public String getCheliangxinxi() {
		return cheliangxinxi;
	}
	/**
	 * 设置：其他人员
	 */
	public void setQitarenyuan(String qitarenyuan) {
		this.qitarenyuan = qitarenyuan;
	}
	/**
	 * 获取：其他人员
	 */
	public String getQitarenyuan() {
		return qitarenyuan;
	}
	/**
	 * 设置：手机号
	 */
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	/**
	 * 获取：手机号
	 */
	public String getShoujihao() {
		return shoujihao;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
