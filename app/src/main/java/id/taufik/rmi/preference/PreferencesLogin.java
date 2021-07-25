package id.taufik.rmi.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferencesLogin {

    static final String EMAIL_LOGIN = "email";
    static final String PWD_LOGIN = "pwd";

    static final String STATUS = "status";

    private static SharedPreferences getSharedPreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setSafeEmail(Context context, String email) {
        SharedPreferences.Editor editor =  getSharedPreference(context).edit();
        editor.putString(EMAIL_LOGIN, email);
        editor.apply();
    }

    public static String getSafeEmail(Context context){
        return getSharedPreference(context).getString(EMAIL_LOGIN,"");
    }

    public static void setSafePwd(Context context, String email) {
        SharedPreferences.Editor editor =  getSharedPreference(context).edit();
        editor.putString(PWD_LOGIN, email);
        editor.apply();
    }

    public static String getSafePwd(Context context){
        return getSharedPreference(context).getString(PWD_LOGIN,"");
    }

    /*
     *
     * Atur Status Login
     *
     * */

    public static void setStatusLoginAccount(Context context, boolean status){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(STATUS,status);
        editor.apply();
    }

    public static boolean getStatusLoginAccount(Context context){
        return getSharedPreference(context).getBoolean(STATUS,false);
    }
}
