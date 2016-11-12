package com.renren.ntc.sg.controllers.console;

import com.alibaba.fastjson.JSONObject;
import com.renren.ntc.sg.annotations.AuthorizeCheck;
import com.renren.ntc.sg.bean.*;
import com.renren.ntc.sg.biz.dao.*;
import com.renren.ntc.sg.constant.GoodsCategory;
import com.renren.ntc.sg.interceptors.access.RegistHostHolder;
import com.renren.ntc.sg.service.LoggerUtils;
import com.renren.ntc.sg.util.Constants;
import com.renren.ntc.sg.util.MimeTypeUtils;
import com.renren.ntc.sg.util.SUtils;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.velocity.tools.generic.DateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

/**
 * 地推人员工具
 *
 * @author zhaoxiufei
 */
@AuthorizeCheck
@Path("/")
public class ToolsController {


    @Autowired
    private BossDAO bossDAO;



    /**
     * 首次上传扫码文件
     *
     * @param inv
     * @param shop_id
     * @param file
     * @return
     */
    @Get("uploadFile")
    @Post("uploadFile")
    public String uploadFile(Invocation inv, @Param("shop_id") long shop_id, @Param("file") MultipartFile file) {
        if (null == file) {
            return "@ 文件不能为空!";
        }
        if (!MimeTypeUtils.TEXT_PLAIN.equals(file.getContentType())) {
            return "@文件类型有误! 只支持.txt类型文件!";
        }



        LoggerUtils.getInstance().log(" OK!");
        return "r:/console/tools/shopInfo?shop_id=" + shop_id;
    }



}

