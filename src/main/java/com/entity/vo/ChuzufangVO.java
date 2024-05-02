package com.entity.vo;

import com.entity.ChuzufangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 出租房
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chuzufang")
public class ChuzufangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 出租房名称
     */

    @TableField(value = "chuzufang_name")
    private String chuzufangName;


    /**
     * 面积(平米)
     */

    @TableField(value = "mianji")
    private Double mianji;


    /**
     * 出租房照片
     */

    @TableField(value = "chuzufang_photo")
    private String chuzufangPhoto;


    /**
     * 出租房类型
     */

    @TableField(value = "chuzufang_types")
    private Integer chuzufangTypes;


    /**
     * 出租房原价/月
     */

    @TableField(value = "chuzufang_old_money")
    private Double chuzufangOldMoney;


    /**
     * 现价/月
     */

    @TableField(value = "chuzufang_new_money")
    private Double chuzufangNewMoney;


    /**
     * 点击次数
     */

    @TableField(value = "chuzufang_clicknum")
    private Integer chuzufangClicknum;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 出租房详细介绍
     */

    @TableField(value = "chuzufang_content")
    private String chuzufangContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "chuzufang_delete")
    private Integer chuzufangDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：出租房名称
	 */
    public String getChuzufangName() {
        return chuzufangName;
    }


    /**
	 * 获取：出租房名称
	 */

    public void setChuzufangName(String chuzufangName) {
        this.chuzufangName = chuzufangName;
    }
    /**
	 * 设置：面积(平米)
	 */
    public Double getMianji() {
        return mianji;
    }


    /**
	 * 获取：面积(平米)
	 */

    public void setMianji(Double mianji) {
        this.mianji = mianji;
    }
    /**
	 * 设置：出租房照片
	 */
    public String getChuzufangPhoto() {
        return chuzufangPhoto;
    }


    /**
	 * 获取：出租房照片
	 */

    public void setChuzufangPhoto(String chuzufangPhoto) {
        this.chuzufangPhoto = chuzufangPhoto;
    }
    /**
	 * 设置：出租房类型
	 */
    public Integer getChuzufangTypes() {
        return chuzufangTypes;
    }


    /**
	 * 获取：出租房类型
	 */

    public void setChuzufangTypes(Integer chuzufangTypes) {
        this.chuzufangTypes = chuzufangTypes;
    }
    /**
	 * 设置：出租房原价/月
	 */
    public Double getChuzufangOldMoney() {
        return chuzufangOldMoney;
    }


    /**
	 * 获取：出租房原价/月
	 */

    public void setChuzufangOldMoney(Double chuzufangOldMoney) {
        this.chuzufangOldMoney = chuzufangOldMoney;
    }
    /**
	 * 设置：现价/月
	 */
    public Double getChuzufangNewMoney() {
        return chuzufangNewMoney;
    }


    /**
	 * 获取：现价/月
	 */

    public void setChuzufangNewMoney(Double chuzufangNewMoney) {
        this.chuzufangNewMoney = chuzufangNewMoney;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getChuzufangClicknum() {
        return chuzufangClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setChuzufangClicknum(Integer chuzufangClicknum) {
        this.chuzufangClicknum = chuzufangClicknum;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：出租房详细介绍
	 */
    public String getChuzufangContent() {
        return chuzufangContent;
    }


    /**
	 * 获取：出租房详细介绍
	 */

    public void setChuzufangContent(String chuzufangContent) {
        this.chuzufangContent = chuzufangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getChuzufangDelete() {
        return chuzufangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChuzufangDelete(Integer chuzufangDelete) {
        this.chuzufangDelete = chuzufangDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
