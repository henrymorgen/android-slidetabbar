/*
 * 官网地站:http://www.mob.com
 * 技术支持QQ: 4006852216
 * 官方微信:ShareSDK   （如果发布新版本的话，我们将会第一时间通过微信将版本更新内容推送给您。如果使用过程中有任何问题，也可以通过微信与我们取得联系，我们将会在24小时内给予回复）
 *
 * Copyright (c) 2014年 mob.com. All rights reserved.
 */
package com.example.liuwangshu.myslidetabbar;

import android.content.Context;


public class SizeHelper {
    public static float designedDensity = 1.5f;
    public static int designedScreenWidth = 540;
    private static Context context = null;

    protected static SizeHelper helper;

    private SizeHelper() {
    }

    public static void prepare(Context c) {
        if (context == null || context != c.getApplicationContext()) {
            context = c;
        }
    }

    /**
     * px转dp
     *
     * @param context
     * @param px
     * @return
     */
    public static float px2dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (px / scale);
    }

    /**
     * dp转px
     *
     * @param context
     * @param dp
     * @return
     */
    public static float dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (dp * scale);
    }

}
