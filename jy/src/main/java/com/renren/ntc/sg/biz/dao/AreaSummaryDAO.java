package com.renren.ntc.sg.biz.dao;

import com.renren.ntc.sg.bean.AreaSummary;
import com.renren.ntc.sg.bean.Boss;
import com.renren.ntc.sg.bean.Query;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import java.util.List;

@DAO(catalog = "ABC")
public interface AreaSummaryDAO {
    static final String TABLE_NAME = "area_summary";

    //
    static final String FIELDS = "id,area,wx_order_count,wx_order_sum,cash_order_count,cash_order_sum,date,create_time";
    static final String INSERT_FIELDS = "area,wx_order_count,wx_order_sum,cash_order_count,cash_order_sum,date";

    @SQL("insert into " +TABLE_NAME +"(" + INSERT_FIELDS + ") values (:1.area,:1.wx_order_count,:1.wx_order_sum,:1.cash_order_count," +
            ":1.cash_order_sum,:1.date)" )
    public int insert(AreaSummary area);

    @SQL("delete from " + TABLE_NAME + " where area =:1 and date=:2")
    public int delete (String area , String date);


}
