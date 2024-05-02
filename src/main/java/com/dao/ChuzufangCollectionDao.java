package com.dao;

import com.entity.ChuzufangCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuzufangCollectionView;

/**
 * 出租房收藏 Dao 接口
 *
 * @author 
 */
public interface ChuzufangCollectionDao extends BaseMapper<ChuzufangCollectionEntity> {

   List<ChuzufangCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
