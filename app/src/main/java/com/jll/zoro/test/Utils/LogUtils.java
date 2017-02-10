package com.jll.zoro.test.Utils;

import android.text.TextUtils;
import android.util.Log;

import java.util.logging.Logger;


/**
 * 创建： on 2016/2/24 11:29
 * 备注： 打印Log的工具类
 */
public class LogUtils {

    private static boolean isLog = true;
    private static final String TAG = "Longjuanfeng";

    public static void setLog(boolean isLog) {
        LogUtils.isLog = isLog;
    }

    public static boolean getIsLog() {
        return isLog;
    }

    public static void d(String tag, String msg) {
        if (isLog) {
            Log.d(tag, msg);
        }
    }

    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    /**
     * Send a  log message and log the exception.
     *
     * @param tag Used to identify the source of a log message. It usually
     *            identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static void d(String tag, String msg, Throwable tr) {
        if (isLog) {
            Log.d(tag, msg, tr);
        }
    }

    public static void e(Throwable tr) {
        if (isLog) {
            Log.e(TAG, "", tr);
        }
    }

    public static void i(String msg) {
        if (isLog) {
            Log.i(TAG, "--------" + msg);
        }
    }

    public static void i(String tag, String msg) {
        if (isLog) {
            Log.i(tag, "------------" + msg);
        }
    }

    /**
     * Send a {@link #INFO} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message. It usually
     *            identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static void i(String tag, String msg, Throwable tr) {
        if (isLog) {
            Log.i(tag, msg, tr);
        }

    }

    /**
     * Send an  log message.
     *
     * @param tag Used to identify the source of a log message. It usually
     *            identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static void e(String tag, String msg) {
        if (isLog) {
            Log.e(tag, msg);
        }
    }

    public static void e(String msg) {
        if (isLog) {
            Log.e(TAG, "--错误信息:--" + msg);
        }
    }

    /**
     * Send a  log message and log the exception.
     *
     * @param tag Used to identify the source of a log message. It usually
     *            identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static void e(String tag, String msg, Throwable tr) {
        if (isLog) {
            Log.e(tag, msg, tr);
        }
    }

    public static void e(String msg, Throwable tr) {
        if (isLog) {
            Log.e(TAG, msg, tr);
        }
    }

    public static void systemErr(String msg) {
        if (isLog) {
            if (msg != null) {
                Log.e(TAG, msg);
            }

        }
    }

    private static String getLocation() {
        final String className = Logger.class.getName();
        final StackTraceElement[] traces = Thread.currentThread()
                .getStackTrace();
        boolean found = false;

        for (StackTraceElement trace : traces) {
            try {
                if (found) {
                    if (!trace.getClassName().startsWith(className)) {
                        Class<?> clazz = Class.forName(trace.getClassName());
                        return "[" + getClassName(clazz) + ":"
                                + trace.getMethodName() + ":"
                                + trace.getLineNumber() + "]: ";
                    }
                } else if (trace.getClassName().startsWith(className)) {
                    found = true;
                }
            } catch (ClassNotFoundException ignored) {
            }
        }

        return "[]: ";
    }

    private static String getClassName(Class<?> clazz) {
        if (clazz != null) {
            if (!TextUtils.isEmpty(clazz.getSimpleName())) {
                return clazz.getSimpleName();
            }

            return getClassName(clazz.getEnclosingClass());
        }

        return "";
    }
}

