package com.dao;

import com.entity.ChuzufangOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuzufangOrderView;

/**
 * 预约看房订单 Dao 接口
 *
 * @author 
 */
public interface ChuzufangOrderDao extends BaseMapper<ChuzufangOrderEntity> {

   List<ChuzufangOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
