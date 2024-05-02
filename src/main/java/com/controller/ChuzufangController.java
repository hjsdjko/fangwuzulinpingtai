
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 出租房
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chuzufang")
public class ChuzufangController {
    private static final Logger logger = LoggerFactory.getLogger(ChuzufangController.class);

    @Autowired
    private ChuzufangService chuzufangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("chuzufangDeleteStart",1);params.put("chuzufangDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = chuzufangService.queryPage(params);

        //字典表数据转换
        List<ChuzufangView> list =(List<ChuzufangView>)page.getList();
        for(ChuzufangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChuzufangEntity chuzufang = chuzufangService.selectById(id);
        if(chuzufang !=null){
            //entity转view
            ChuzufangView view = new ChuzufangView();
            BeanUtils.copyProperties( chuzufang , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(chuzufang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChuzufangEntity chuzufang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chuzufang:{}",this.getClass().getName(),chuzufang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            chuzufang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ChuzufangEntity> queryWrapper = new EntityWrapper<ChuzufangEntity>()
            .eq("yonghu_id", chuzufang.getYonghuId())
            .eq("chuzufang_name", chuzufang.getChuzufangName())
            .eq("chuzufang_types", chuzufang.getChuzufangTypes())
            .eq("chuzufang_clicknum", chuzufang.getChuzufangClicknum())
            .eq("shangxia_types", chuzufang.getShangxiaTypes())
            .eq("chuzufang_delete", chuzufang.getChuzufangDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuzufangEntity chuzufangEntity = chuzufangService.selectOne(queryWrapper);
        if(chuzufangEntity==null){
            chuzufang.setChuzufangClicknum(1);
            chuzufang.setShangxiaTypes(1);
            chuzufang.setChuzufangDelete(1);
            chuzufang.setCreateTime(new Date());
            chuzufangService.insert(chuzufang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChuzufangEntity chuzufang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chuzufang:{}",this.getClass().getName(),chuzufang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            chuzufang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ChuzufangEntity> queryWrapper = new EntityWrapper<ChuzufangEntity>()
            .notIn("id",chuzufang.getId())
            .andNew()
            .eq("yonghu_id", chuzufang.getYonghuId())
            .eq("chuzufang_name", chuzufang.getChuzufangName())
            .eq("chuzufang_types", chuzufang.getChuzufangTypes())
            .eq("chuzufang_clicknum", chuzufang.getChuzufangClicknum())
            .eq("shangxia_types", chuzufang.getShangxiaTypes())
            .eq("chuzufang_delete", chuzufang.getChuzufangDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuzufangEntity chuzufangEntity = chuzufangService.selectOne(queryWrapper);
        if("".equals(chuzufang.getChuzufangPhoto()) || "null".equals(chuzufang.getChuzufangPhoto())){
                chuzufang.setChuzufangPhoto(null);
        }
        if(chuzufangEntity==null){
            chuzufangService.updateById(chuzufang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ChuzufangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ChuzufangEntity chuzufangEntity = new ChuzufangEntity();
            chuzufangEntity.setId(id);
            chuzufangEntity.setChuzufangDelete(2);
            list.add(chuzufangEntity);
        }
        if(list != null && list.size() >0){
            chuzufangService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ChuzufangEntity> chuzufangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChuzufangEntity chuzufangEntity = new ChuzufangEntity();
//                            chuzufangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            chuzufangEntity.setChuzufangName(data.get(0));                    //出租房名称 要改的
//                            chuzufangEntity.setMianji(data.get(0));                    //面积(平米) 要改的
//                            chuzufangEntity.setChuzufangPhoto("");//照片
//                            chuzufangEntity.setChuzufangTypes(Integer.valueOf(data.get(0)));   //出租房类型 要改的
//                            chuzufangEntity.setChuzufangOldMoney(data.get(0));                    //出租房原价/月 要改的
//                            chuzufangEntity.setChuzufangNewMoney(data.get(0));                    //现价/月 要改的
//                            chuzufangEntity.setChuzufangClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            chuzufangEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            chuzufangEntity.setChuzufangContent("");//照片
//                            chuzufangEntity.setChuzufangDelete(1);//逻辑删除字段
//                            chuzufangEntity.setCreateTime(date);//时间
                            chuzufangList.add(chuzufangEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        chuzufangService.insertBatch(chuzufangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = chuzufangService.queryPage(params);

        //字典表数据转换
        List<ChuzufangView> list =(List<ChuzufangView>)page.getList();
        for(ChuzufangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChuzufangEntity chuzufang = chuzufangService.selectById(id);
            if(chuzufang !=null){

                //点击数量加1
                chuzufang.setChuzufangClicknum(chuzufang.getChuzufangClicknum()+1);
                chuzufangService.updateById(chuzufang);

                //entity转view
                ChuzufangView view = new ChuzufangView();
                BeanUtils.copyProperties( chuzufang , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chuzufang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChuzufangEntity chuzufang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chuzufang:{}",this.getClass().getName(),chuzufang.toString());
        Wrapper<ChuzufangEntity> queryWrapper = new EntityWrapper<ChuzufangEntity>()
            .eq("yonghu_id", chuzufang.getYonghuId())
            .eq("chuzufang_name", chuzufang.getChuzufangName())
            .eq("chuzufang_types", chuzufang.getChuzufangTypes())
            .eq("chuzufang_clicknum", chuzufang.getChuzufangClicknum())
            .eq("shangxia_types", chuzufang.getShangxiaTypes())
            .eq("chuzufang_delete", chuzufang.getChuzufangDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuzufangEntity chuzufangEntity = chuzufangService.selectOne(queryWrapper);
        if(chuzufangEntity==null){
            chuzufang.setChuzufangDelete(1);
            chuzufang.setCreateTime(new Date());
        chuzufangService.insert(chuzufang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
