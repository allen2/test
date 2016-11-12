package com.renren.ntc.sg.constant;

/**
 * Created by ZhaoXiuFei on 2015/4/22 17:19.
 */
public class CatStaffType {
    /**
     * BD 人员
     */
    public static int TYPE_BD = 0;
    /**
     * 待定
     */
    public static int TYPE_XX = 1;
    /**
     * 客服人员
     */
    public static int TYPE_KF = 2;
    /**
     * 编辑人员
     */
    public static int TYPE_BJ = 3;
    /**
     * 财务人员
     */
    public static int TYPE_CW = 4;
    /**
     * 管理员
     */
    public static int TYPE_ADMIN = 99;

    public static int[] getAllType() {
        return new int[]{TYPE_BD, TYPE_XX, TYPE_KF, TYPE_BJ, TYPE_CW, TYPE_ADMIN};
    }
}
