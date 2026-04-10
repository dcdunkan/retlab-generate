package in.etuwa.app.data.preference;

import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import androidx.preference.PreferenceManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.etuwa.app.EtlabApp;
import in.etuwa.app.utils.AppConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedPrefManager.kt */
/* loaded from: classes3.dex */
public final class SharedPrefManager implements SharedPrefManagerHelper {
    private final String DUE_NEW;
    private final String FEE_ENGNR_STATUS;
    private final String PREF_ATT_PERCENT;
    private final String PREF_BASE_URL;
    private final String PREF_COLLEGE;
    private final String PREF_COLLEGE_ID;
    private final String PREF_END_YEAR;
    private final String PREF_FEE_STATUS;
    private final String PREF_LOGIN;
    private final String PREF_LOGIN_STATUS;
    private final String PREF_NEW_LOGIN;
    private final String PREF_NOTICE_ONE;
    private final String PREF_NOTICE_THREE;
    private final String PREF_NOTICE_TWO;
    private final String PREF_PUSH_TOKEN_SERVER_STATUS;
    private final String PREF_REG_URL;
    private final String PREF_START_YEAR;
    private final String PREF_SURVEY_STATUS;
    private final String PREF_TOKEN;
    private final String PREF_USER_BATCH_ID;
    private final String PREF_USER_COURSE;
    private final String PREF_USER_HOSTEL;
    private final String PREF_USER_HOSTEL_STATUS;
    private final String PREF_USER_IMG;
    private final String PREF_USER_NAME;
    private final String PREF_USER_PASSWORD;
    private final String PREF_USER_PRO_NAME;
    private final String PREF_USER_PUSH_TOKEN;
    private final String PREF_USER_PUSH_TOKEN_STATUS;
    private final String PREF_USER_SEM;
    private final String PREF_USER_SEM_ID;
    private final String PREF_USER_TYPE;
    private final String PREF_USER_TYPE_NEW;
    private final String PREF_USER_UNIV;
    private final String PREF_USER_YEAR;
    private final String PREF_VERSION_CODE;
    private SharedPreferences prefernce;

    public SharedPrefManager(EtlabApp app) {
        Intrinsics.checkNotNullParameter(app, "app");
        this.PREF_TOKEN = "token";
        this.PREF_LOGIN_STATUS = "loginStatus";
        this.PREF_LOGIN = FirebaseAnalytics.Event.LOGIN;
        this.PREF_USER_TYPE = "user_type";
        this.PREF_USER_NAME = "user_name";
        this.PREF_USER_PASSWORD = "user_password";
        this.PREF_USER_HOSTEL = "user_hostel";
        this.PREF_USER_HOSTEL_STATUS = "user_hostel_status";
        this.PREF_USER_PRO_NAME = "userpro_name";
        this.PREF_USER_SEM = "user_sem";
        this.PREF_USER_SEM_ID = "user_sem_id";
        this.PREF_USER_BATCH_ID = "user_batch_id";
        this.PREF_USER_YEAR = "user_year";
        this.PREF_USER_UNIV = "user_univ";
        this.PREF_USER_IMG = "user_img";
        this.PREF_USER_COURSE = "user_course";
        this.PREF_USER_PUSH_TOKEN = "push_token";
        this.PREF_USER_PUSH_TOKEN_STATUS = "push_token_status";
        this.PREF_PUSH_TOKEN_SERVER_STATUS = "push_token_server_status";
        this.PREF_COLLEGE = "clg";
        this.PREF_COLLEGE_ID = "clg_id";
        this.PREF_BASE_URL = "base_url";
        this.PREF_REG_URL = "reg_url";
        this.PREF_START_YEAR = "start_year";
        this.PREF_END_YEAR = "end_year";
        this.PREF_FEE_STATUS = "fee_status";
        this.DUE_NEW = "due_new";
        this.FEE_ENGNR_STATUS = "fee_engnr_status";
        this.PREF_NEW_LOGIN = "new_login";
        this.PREF_ATT_PERCENT = "att";
        this.PREF_NOTICE_ONE = "one";
        this.PREF_NOTICE_TWO = "two";
        this.PREF_NOTICE_THREE = "three";
        this.PREF_SURVEY_STATUS = "survey";
        this.PREF_VERSION_CODE = "version_code";
        this.PREF_USER_TYPE_NEW = "user_type_new";
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(app);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(app)");
        this.prefernce = defaultSharedPreferences;
    }

    public final String getPREF_TOKEN() {
        return this.PREF_TOKEN;
    }

    public final String getPREF_LOGIN_STATUS() {
        return this.PREF_LOGIN_STATUS;
    }

    public final String getPREF_LOGIN() {
        return this.PREF_LOGIN;
    }

    public final String getPREF_USER_TYPE() {
        return this.PREF_USER_TYPE;
    }

    public final String getPREF_USER_NAME() {
        return this.PREF_USER_NAME;
    }

    public final String getPREF_USER_PASSWORD() {
        return this.PREF_USER_PASSWORD;
    }

    public final String getPREF_USER_HOSTEL() {
        return this.PREF_USER_HOSTEL;
    }

    public final String getPREF_USER_HOSTEL_STATUS() {
        return this.PREF_USER_HOSTEL_STATUS;
    }

    public final String getPREF_USER_PRO_NAME() {
        return this.PREF_USER_PRO_NAME;
    }

    public final String getPREF_USER_SEM() {
        return this.PREF_USER_SEM;
    }

    public final String getPREF_USER_SEM_ID() {
        return this.PREF_USER_SEM_ID;
    }

    public final String getPREF_USER_BATCH_ID() {
        return this.PREF_USER_BATCH_ID;
    }

    public final String getPREF_USER_YEAR() {
        return this.PREF_USER_YEAR;
    }

    public final String getPREF_USER_UNIV() {
        return this.PREF_USER_UNIV;
    }

    public final String getPREF_USER_IMG() {
        return this.PREF_USER_IMG;
    }

    public final String getPREF_USER_COURSE() {
        return this.PREF_USER_COURSE;
    }

    public final String getPREF_USER_PUSH_TOKEN() {
        return this.PREF_USER_PUSH_TOKEN;
    }

    public final String getPREF_USER_PUSH_TOKEN_STATUS() {
        return this.PREF_USER_PUSH_TOKEN_STATUS;
    }

    public final String getPREF_PUSH_TOKEN_SERVER_STATUS() {
        return this.PREF_PUSH_TOKEN_SERVER_STATUS;
    }

    public final String getPREF_COLLEGE() {
        return this.PREF_COLLEGE;
    }

    public final String getPREF_COLLEGE_ID() {
        return this.PREF_COLLEGE_ID;
    }

    public final String getPREF_BASE_URL() {
        return this.PREF_BASE_URL;
    }

    public final String getPREF_REG_URL() {
        return this.PREF_REG_URL;
    }

    public final String getPREF_START_YEAR() {
        return this.PREF_START_YEAR;
    }

    public final String getPREF_END_YEAR() {
        return this.PREF_END_YEAR;
    }

    public final String getPREF_FEE_STATUS() {
        return this.PREF_FEE_STATUS;
    }

    public final String getDUE_NEW() {
        return this.DUE_NEW;
    }

    public final String getFEE_ENGNR_STATUS() {
        return this.FEE_ENGNR_STATUS;
    }

    public final String getPREF_NEW_LOGIN() {
        return this.PREF_NEW_LOGIN;
    }

    public final String getPREF_ATT_PERCENT() {
        return this.PREF_ATT_PERCENT;
    }

    public final String getPREF_NOTICE_ONE() {
        return this.PREF_NOTICE_ONE;
    }

    public final String getPREF_NOTICE_TWO() {
        return this.PREF_NOTICE_TWO;
    }

    public final String getPREF_NOTICE_THREE() {
        return this.PREF_NOTICE_THREE;
    }

    public final String getPREF_SURVEY_STATUS() {
        return this.PREF_SURVEY_STATUS;
    }

    public final String getPREF_VERSION_CODE() {
        return this.PREF_VERSION_CODE;
    }

    public final String getPREF_USER_TYPE_NEW() {
        return this.PREF_USER_TYPE_NEW;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setLogin(String token, String userType, int userHostel, String userHostelStatus, String userProName, String userYear, String userUniv, String userImg, String semName, String semId, String course, String uName, String passkey, int startYear, int endYear, String batchId) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(userType, "userType");
        Intrinsics.checkNotNullParameter(userHostelStatus, "userHostelStatus");
        Intrinsics.checkNotNullParameter(userProName, "userProName");
        Intrinsics.checkNotNullParameter(userYear, "userYear");
        Intrinsics.checkNotNullParameter(userUniv, "userUniv");
        Intrinsics.checkNotNullParameter(userImg, "userImg");
        Intrinsics.checkNotNullParameter(semName, "semName");
        Intrinsics.checkNotNullParameter(semId, "semId");
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(uName, "uName");
        Intrinsics.checkNotNullParameter(passkey, "passkey");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putString(this.PREF_TOKEN, token);
        edit.putBoolean(this.PREF_LOGIN_STATUS, true);
        edit.putBoolean(this.PREF_LOGIN, true);
        edit.putString(this.PREF_USER_TYPE, userType);
        edit.putInt(this.PREF_USER_HOSTEL, userHostel);
        edit.putString(this.PREF_USER_HOSTEL_STATUS, userHostelStatus);
        edit.putString(this.PREF_USER_PRO_NAME, userProName);
        edit.putString(this.PREF_USER_YEAR, userYear);
        edit.putString(this.PREF_USER_UNIV, userUniv);
        edit.putString(this.PREF_USER_IMG, userImg);
        edit.putString(this.PREF_USER_SEM_ID, semId);
        edit.putString(this.PREF_USER_SEM, semName);
        edit.putString(this.PREF_USER_COURSE, course);
        edit.putString(this.PREF_USER_NAME, uName);
        edit.putString(this.PREF_USER_PASSWORD, passkey);
        edit.putInt(this.PREF_START_YEAR, startYear);
        edit.putInt(this.PREF_END_YEAR, endYear);
        edit.putString(this.PREF_USER_BATCH_ID, batchId);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setRefreshToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putString(this.PREF_TOKEN, token);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setPushToken(String token) {
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putString(this.PREF_USER_PUSH_TOKEN, token);
        edit.putBoolean(this.PREF_USER_PUSH_TOKEN_STATUS, true);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setHostelStatus(int user_hostel, String user_hostel_status) {
        Intrinsics.checkNotNullParameter(user_hostel_status, "user_hostel_status");
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putInt(this.PREF_USER_HOSTEL, user_hostel);
        edit.putString(this.PREF_USER_HOSTEL_STATUS, user_hostel_status);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public int getHostel() {
        return this.prefernce.getInt(this.PREF_USER_HOSTEL, 0);
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getHostelStatus() {
        String string = this.prefernce.getString(this.PREF_USER_HOSTEL_STATUS, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getPushToken() {
        String string = this.prefernce.getString(this.PREF_USER_PUSH_TOKEN, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public boolean getPushTokenStatus() {
        return this.prefernce.getBoolean(this.PREF_USER_PUSH_TOKEN_STATUS, false);
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setPushTokenServerStatus(boolean status) {
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putBoolean(this.PREF_PUSH_TOKEN_SERVER_STATUS, status);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public boolean getPushTokenServerStatus() {
        return this.prefernce.getBoolean(this.PREF_PUSH_TOKEN_SERVER_STATUS, false);
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setClg(boolean clg, int id, String url, String regUrl) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(regUrl, "regUrl");
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putBoolean(this.PREF_COLLEGE, clg);
        edit.putInt(this.PREF_COLLEGE_ID, id);
        edit.putString(this.PREF_BASE_URL, url);
        edit.putString(this.PREF_REG_URL, regUrl);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getBatchId() {
        String string = this.prefernce.getString(this.PREF_USER_BATCH_ID, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public boolean getClg() {
        return this.prefernce.getBoolean(this.PREF_COLLEGE, false);
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public int getClgId() {
        return this.prefernce.getInt(this.PREF_COLLEGE_ID, -1);
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getBaseUrl() {
        String string = this.prefernce.getString(this.PREF_BASE_URL, AppConstant.COLLEGE_LIST_BASE_URL);
        return string == null ? AppConstant.COLLEGE_LIST_BASE_URL : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getRegUrl() {
        String string = this.prefernce.getString(this.PREF_REG_URL, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getUserType() {
        String string = this.prefernce.getString(this.PREF_USER_TYPE, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getUserName() {
        String string = this.prefernce.getString(this.PREF_USER_NAME, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getPassword() {
        String string = this.prefernce.getString(this.PREF_USER_PASSWORD, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getAcademicYear() {
        String string = this.prefernce.getString(this.PREF_USER_YEAR, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getUserProName() {
        String string = this.prefernce.getString(this.PREF_USER_PRO_NAME, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getUserCourse() {
        String string = this.prefernce.getString(this.PREF_USER_COURSE, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getUserSem() {
        String string = this.prefernce.getString(this.PREF_USER_SEM, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getDueNew() {
        String string = this.prefernce.getString(this.DUE_NEW, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setUpdateUserData(String batchId, String semId, String semName, String hostelStatus, int hostel, String course, String img) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(semId, "semId");
        Intrinsics.checkNotNullParameter(semName, "semName");
        Intrinsics.checkNotNullParameter(hostelStatus, "hostelStatus");
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(img, "img");
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putString(this.PREF_USER_BATCH_ID, batchId);
        edit.putString(this.PREF_USER_SEM_ID, semId);
        edit.putString(this.PREF_USER_SEM, semName);
        edit.putString(this.PREF_USER_HOSTEL_STATUS, hostelStatus);
        edit.putInt(this.PREF_USER_HOSTEL, hostel);
        edit.putString(this.PREF_USER_COURSE, course);
        edit.putString(this.PREF_USER_IMG, img);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public int getStartYear() {
        return this.prefernce.getInt(this.PREF_START_YEAR, 0);
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public int getEndYear() {
        return this.prefernce.getInt(this.PREF_END_YEAR, 0);
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getUserSemId() {
        String string = this.prefernce.getString(this.PREF_USER_SEM_ID, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getUserImg() {
        String string = this.prefernce.getString(this.PREF_USER_IMG, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public boolean getLoginStatus() {
        return this.prefernce.getBoolean(this.PREF_LOGIN_STATUS, false);
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public boolean getLogin() {
        return this.prefernce.getBoolean(this.PREF_LOGIN, false);
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getToken() {
        String string = this.prefernce.getString(this.PREF_TOKEN, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setFeeStatus(boolean status) {
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putBoolean(this.PREF_FEE_STATUS, status);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setDueNew(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putString(this.DUE_NEW, status);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public boolean getFeeEngnrNew() {
        return this.prefernce.getBoolean(this.FEE_ENGNR_STATUS, false);
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setFeeEngnrNew(boolean status) {
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putBoolean(this.FEE_ENGNR_STATUS, status);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public boolean getNewLogin() {
        return this.prefernce.getBoolean(this.PREF_NEW_LOGIN, false);
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setNewLogin(boolean status) {
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putBoolean(this.PREF_NEW_LOGIN, status);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getAttendancePercentage() {
        String string = this.prefernce.getString(this.PREF_ATT_PERCENT, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setAttendancePercentage(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putString(this.PREF_ATT_PERCENT, status);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getNoticeOne() {
        String string = this.prefernce.getString(this.PREF_NOTICE_ONE, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setNoticeOne(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putString(this.PREF_NOTICE_ONE, status);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getNoticeTwo() {
        String string = this.prefernce.getString(this.PREF_NOTICE_TWO, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setNoticeTwo(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putString(this.PREF_NOTICE_TWO, status);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getNoticeThree() {
        String string = this.prefernce.getString(this.PREF_NOTICE_THREE, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setNoticeThree(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putString(this.PREF_NOTICE_THREE, status);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public boolean getSurveyStatus() {
        return this.prefernce.getBoolean(this.PREF_SURVEY_STATUS, false);
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setSurveyStatus(boolean status) {
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putBoolean(this.PREF_SURVEY_STATUS, status);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getVersionCode() {
        String string = this.prefernce.getString(this.PREF_VERSION_CODE, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setVersionCode(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putString(this.PREF_VERSION_CODE, status);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void setUserTypeNew(String status) {
        Intrinsics.checkNotNullParameter(status, "status");
        SharedPreferences.Editor edit = this.prefernce.edit();
        edit.putString(this.PREF_USER_TYPE_NEW, status);
        edit.apply();
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public String getUserTypeNew() {
        String string = this.prefernce.getString(this.PREF_USER_TYPE_NEW, "");
        return string == null ? "" : string;
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public boolean getFeeStatus() {
        return this.prefernce.getBoolean(this.PREF_FEE_STATUS, false);
    }

    @Override // in.etuwa.app.data.preference.SharedPrefManagerHelper
    public void clearData() {
        SharedPreferences.Editor edit = this.prefernce.edit();
        String string = this.prefernce.getString(this.PREF_USER_PUSH_TOKEN, "");
        String str = string != null ? string : "";
        edit.clear();
        edit.putString(this.PREF_USER_PUSH_TOKEN, str);
        edit.putBoolean(this.PREF_USER_PUSH_TOKEN_STATUS, true);
        edit.apply();
    }
}