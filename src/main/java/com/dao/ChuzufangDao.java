package com.dao;

import com.entity.ChuzufangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuzufangView;

/**
 * 出租房 Dao 接口
 *
 * @author 
 */
public interface ChuzufangDao extends BaseMapper<ChuzufangEntity> {

   List<ChuzufangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
