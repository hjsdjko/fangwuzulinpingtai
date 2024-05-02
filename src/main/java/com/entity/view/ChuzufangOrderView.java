package com.entity.view;

import com.entity.ChuzufangOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 预约看房订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chuzufang_order")
public class ChuzufangOrderView extends ChuzufangOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 时间段的值
		*/
		private String shijianduanValue;
		/**
		* 审核状态的值
		*/
		private String chuzufangOrderYesnoValue;



		//级联表 chuzufang
			/**
			* 出租房 的 用户
			*/
			private Integer chuzufangYonghuId;
			/**
			* 出租房名称
			*/
			private String chuzufangName;
			/**
			* 面积(平米)
			*/
			private Double mianji;
			/**
			* 出租房照片
			*/
			private String chuzufangPhoto;
			/**
			* 出租房类型
			*/
			private Integer chuzufangTypes;
				/**
				* 出租房类型的值
				*/
				private String chuzufangValue;
			/**
			* 出租房原价/月
			*/
			private Double chuzufangOldMoney;
			/**
			* 现价/月
			*/
			private Double chuzufangNewMoney;
			/**
			* 点击次数
			*/
			private Integer chuzufangClicknum;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 出租房详细介绍
			*/
			private String chuzufangContent;
			/**
			* 逻辑删除
			*/
			private Integer chuzufangDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public ChuzufangOrderView() {

	}

	public ChuzufangOrderView(ChuzufangOrderEntity chuzufangOrderEntity) {
		try {
			BeanUtils.copyProperties(this, chuzufangOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 时间段的值
			*/
			public String getShijianduanValue() {
				return shijianduanValue;
			}
			/**
			* 设置： 时间段的值
			*/
			public void setShijianduanValue(String shijianduanValue) {
				this.shijianduanValue = shijianduanValue;
			}
			/**
			* 获取： 审核状态的值
			*/
			public String getChuzufangOrderYesnoValue() {
				return chuzufangOrderYesnoValue;
			}
			/**
			* 设置： 审核状态的值
			*/
			public void setChuzufangOrderYesnoValue(String chuzufangOrderYesnoValue) {
				this.chuzufangOrderYesnoValue = chuzufangOrderYesnoValue;
			}




				//级联表的get和set chuzufang
					/**
					* 获取：出租房 的 用户
					*/
					public Integer getChuzufangYonghuId() {
						return chuzufangYonghuId;
					}
					/**
					* 设置：出租房 的 用户
					*/
					public void setChuzufangYonghuId(Integer chuzufangYonghuId) {
						this.chuzufangYonghuId = chuzufangYonghuId;
					}

					/**
					* 获取： 出租房名称
					*/
					public String getChuzufangName() {
						return chuzufangName;
					}
					/**
					* 设置： 出租房名称
					*/
					public void setChuzufangName(String chuzufangName) {
						this.chuzufangName = chuzufangName;
					}
					/**
					* 获取： 面积(平米)
					*/
					public Double getMianji() {
						return mianji;
					}
					/**
					* 设置： 面积(平米)
					*/
					public void setMianji(Double mianji) {
						this.mianji = mianji;
					}
					/**
					* 获取： 出租房照片
					*/
					public String getChuzufangPhoto() {
						return chuzufangPhoto;
					}
					/**
					* 设置： 出租房照片
					*/
					public void setChuzufangPhoto(String chuzufangPhoto) {
						this.chuzufangPhoto = chuzufangPhoto;
					}
					/**
					* 获取： 出租房类型
					*/
					public Integer getChuzufangTypes() {
						return chuzufangTypes;
					}
					/**
					* 设置： 出租房类型
					*/
					public void setChuzufangTypes(Integer chuzufangTypes) {
						this.chuzufangTypes = chuzufangTypes;
					}


						/**
						* 获取： 出租房类型的值
						*/
						public String getChuzufangValue() {
							return chuzufangValue;
						}
						/**
						* 设置： 出租房类型的值
						*/
						public void setChuzufangValue(String chuzufangValue) {
							this.chuzufangValue = chuzufangValue;
						}
					/**
					* 获取： 出租房原价/月
					*/
					public Double getChuzufangOldMoney() {
						return chuzufangOldMoney;
					}
					/**
					* 设置： 出租房原价/月
					*/
					public void setChuzufangOldMoney(Double chuzufangOldMoney) {
						this.chuzufangOldMoney = chuzufangOldMoney;
					}
					/**
					* 获取： 现价/月
					*/
					public Double getChuzufangNewMoney() {
						return chuzufangNewMoney;
					}
					/**
					* 设置： 现价/月
					*/
					public void setChuzufangNewMoney(Double chuzufangNewMoney) {
						this.chuzufangNewMoney = chuzufangNewMoney;
					}
					/**
					* 获取： 点击次数
					*/
					public Integer getChuzufangClicknum() {
						return chuzufangClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setChuzufangClicknum(Integer chuzufangClicknum) {
						this.chuzufangClicknum = chuzufangClicknum;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 出租房详细介绍
					*/
					public String getChuzufangContent() {
						return chuzufangContent;
					}
					/**
					* 设置： 出租房详细介绍
					*/
					public void setChuzufangContent(String chuzufangContent) {
						this.chuzufangContent = chuzufangContent;
					}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getChuzufangDelete() {
						return chuzufangDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setChuzufangDelete(Integer chuzufangDelete) {
						this.chuzufangDelete = chuzufangDelete;
					}
















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}



}
