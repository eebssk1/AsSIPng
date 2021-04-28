package me.ebk21.assipng

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge.log
import de.robv.android.xposed.XposedHelpers.findAndHookMethod
import de.robv.android.xposed.callbacks.XC_LoadPackage


class Main : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam?) {
        if (lpparam?.packageName.equals("com.asus.stitchimage")) {
            findAndHookMethod("com.asus.stitchimage.j.g", lpparam?.classLoader, "b", "android.content.ContentResolver", object :
                    XC_MethodHook() {
                override fun beforeHookedMethod(param: MethodHookParam?) {
                    log("AsSIPng: We are in the func!")
                    param?.result = 1
                }
            })
        } else {
            return
        }
    }
}