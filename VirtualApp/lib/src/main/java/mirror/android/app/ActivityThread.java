package mirror.android.app;


import android.app.*;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

import mirror.RefClass;
import mirror.RefConstructor;
import mirror.RefObject;
import mirror.RefMethod;
import mirror.MethodParams;
import mirror.MethodReflectParams;
import mirror.RefStaticObject;
import mirror.RefStaticInt;
import mirror.RefStaticMethod;

public class ActivityThread {
    public static Class<?> TYPE = RefClass.load(ActivityThread.class, "android.app.ActivityThread");
    public static RefStaticMethod currentActivityThread;
    public static RefMethod<String> getProcessName;
    public static RefMethod<Handler> getHandler;
    public static RefMethod<Object> installProvider;
    public static RefObject<Object> mBoundApplication;
    public static RefObject<Handler> mH;
    public static RefObject<Application> mInitialApplication;
    public static RefObject<Instrumentation> mInstrumentation;
    public static RefObject<Map<String, WeakReference<?>>> mPackages;
    public static RefObject<Map> mProviderMap;
    @MethodParams({IBinder.class, List.class})
    public static RefMethod<Void> performNewIntents;
    public static RefStaticObject<IInterface> sPackageManager;
    @MethodParams({IBinder.class, String.class, int.class, int.class, Intent.class})
    public static RefMethod<Void> sendActivityResult;
    public static RefMethod<IBinder> getApplicationThread;

    public static class ActivityClientRecord {
        public static Class<?> TYPE = RefClass.load(ActivityClientRecord.class, "android.app.ActivityThread$ActivityClientRecord");
        public static RefObject<Activity> activity;
        public static RefObject<ActivityInfo> activityInfo;
        public static RefObject<Intent> intent;
        public static RefObject<IBinder> token;
    }

    public static class ProviderClientRecord {
        public static Class<?> TYPE = RefClass.load(ProviderClientRecord.class, "android.app.ActivityThread$ProviderClientRecord");
        @MethodReflectParams({"android.app.ActivityThread", "java.lang.String", "android.content.IContentProvider", "android.content.ContentProvider"})
        public static RefConstructor<?> ctor;
        public static RefObject<String> mName;
        public static RefObject<IInterface> mProvider;
    }


    public static class AppBindData {
        public static Class<?> TYPE = RefClass.load(AppBindData.class, "android.app.ActivityThread$AppBindData");
        public static RefObject<ApplicationInfo> appInfo;
        public static RefObject<Object> info;
        public static RefObject<String> processName;
        public static RefObject<ComponentName> instrumentationName;
    }

    public static class H {
        public static Class<?> TYPE = RefClass.load(H.class, "android.app.ActivityThread$H");
        public static RefStaticInt LAUNCH_ACTIVITY;
        public static RefStaticInt CREATE_SERVICE;
    }


    public static Object installProvider(Object mainThread, Context context, ProviderInfo providerInfo) {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            return installProvider.call(mainThread, context, null, providerInfo, false, true);
        }
        return installProvider.call(mainThread, context, null, providerInfo, false, true, true);
    }
}