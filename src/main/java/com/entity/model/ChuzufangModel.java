package com.entity.model;

import com.entity.ChuzufangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 出租房
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChuzufangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


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
     * 出租房详细介绍
     */
    private String chuzufangContent;


    /**
     * 逻辑删除
     */
    private Integer chuzufangDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：出租房名称
	 */
    public String getChuzufangName() {
        return chuzufangName;
    }


    /**
	 * 设置：出租房名称
	 */
    public void setChuzufangName(String chuzufangName) {
        this.chuzufangName = chuzufangName;
    }
    /**
	 * 获取：面积(平米)
	 */
    public Double getMianji() {
        return mianji;
    }


    /**
	 * 设置：面积(平米)
	 */
    public void setMianji(Double mianji) {
        this.mianji = mianji;
    }
    /**
	 * 获取：出租房照片
	 */
    public String getChuzufangPhoto() {
        return chuzufangPhoto;
    }


    /**
	 * 设置：出租房照片
	 */
    public void setChuzufangPhoto(String chuzufangPhoto) {
        this.chuzufangPhoto = chuzufangPhoto;
    }
    /**
	 * 获取：出租房类型
	 */
    public Integer getChuzufangTypes() {
        return chuzufangTypes;
    }


    /**
	 * 设置：出租房类型
	 */
    public void setChuzufangTypes(Integer chuzufangTypes) {
        this.chuzufangTypes = chuzufangTypes;
    }
    /**
	 * 获取：出租房原价/月
	 */
    public Double getChuzufangOldMoney() {
        return chuzufangOldMoney;
    }


    /**
	 * 设置：出租房原价/月
	 */
    public void setChuzufangOldMoney(Double chuzufangOldMoney) {
        this.chuzufangOldMoney = chuzufangOldMoney;
    }
    /**
	 * 获取：现价/月
	 */
    public Double getChuzufangNewMoney() {
        return chuzufangNewMoney;
    }


    /**
	 * 设置：现价/月
	 */
    public void setChuzufangNewMoney(Double chuzufangNewMoney) {
        this.chuzufangNewMoney = chuzufangNewMoney;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getChuzufangClicknum() {
        return chuzufangClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setChuzufangClicknum(Integer chuzufangClicknum) {
        this.chuzufangClicknum = chuzufangClicknum;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：出租房详细介绍
	 */
    public String getChuzufangContent() {
        return chuzufangContent;
    }


    /**
	 * 设置：出租房详细介绍
	 */
    public void setChuzufangContent(String chuzufangContent) {
        this.chuzufangContent = chuzufangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChuzufangDelete() {
        return chuzufangDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setChuzufangDelete(Integer chuzufangDelete) {
        this.chuzufangDelete = chuzufangDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
