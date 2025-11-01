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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bI\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\bJ\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020\u0006H\u0016J\b\u0010T\u001a\u00020\u0006H\u0016J\b\u0010U\u001a\u00020\u0006H\u0016J\b\u0010V\u001a\u00020\u0006H\u0016J\b\u0010W\u001a\u00020XH\u0016J\b\u0010Y\u001a\u00020ZH\u0016J\b\u0010[\u001a\u00020\u0006H\u0016J\b\u0010\\\u001a\u00020ZH\u0016J\b\u0010]\u001a\u00020XH\u0016J\b\u0010^\u001a\u00020XH\u0016J\b\u0010_\u001a\u00020ZH\u0016J\b\u0010`\u001a\u00020\u0006H\u0016J\b\u0010a\u001a\u00020XH\u0016J\b\u0010b\u001a\u00020XH\u0016J\b\u0010c\u001a\u00020XH\u0016J\b\u0010d\u001a\u00020\u0006H\u0016J\b\u0010e\u001a\u00020\u0006H\u0016J\b\u0010f\u001a\u00020\u0006H\u0016J\b\u0010g\u001a\u00020\u0006H\u0016J\b\u0010h\u001a\u00020\u0006H\u0016J\b\u0010i\u001a\u00020XH\u0016J\b\u0010j\u001a\u00020XH\u0016J\b\u0010k\u001a\u00020\u0006H\u0016J\b\u0010l\u001a\u00020ZH\u0016J\b\u0010m\u001a\u00020XH\u0016J\b\u0010n\u001a\u00020\u0006H\u0016J\b\u0010o\u001a\u00020\u0006H\u0016J\b\u0010p\u001a\u00020\u0006H\u0016J\b\u0010q\u001a\u00020\u0006H\u0016J\b\u0010r\u001a\u00020\u0006H\u0016J\b\u0010s\u001a\u00020\u0006H\u0016J\b\u0010t\u001a\u00020\u0006H\u0016J\b\u0010u\u001a\u00020\u0006H\u0016J\b\u0010v\u001a\u00020\u0006H\u0016J\b\u0010w\u001a\u00020\u0006H\u0016J\u0010\u0010x\u001a\u00020R2\u0006\u0010y\u001a\u00020\u0006H\u0016J(\u0010z\u001a\u00020R2\u0006\u0010{\u001a\u00020X2\u0006\u0010|\u001a\u00020Z2\u0006\u0010}\u001a\u00020\u00062\u0006\u0010~\u001a\u00020\u0006H\u0016J\u0010\u0010\u007f\u001a\u00020R2\u0006\u0010y\u001a\u00020\u0006H\u0016J\u0011\u0010\u0080\u0001\u001a\u00020R2\u0006\u0010y\u001a\u00020XH\u0016J\u0011\u0010\u0081\u0001\u001a\u00020R2\u0006\u0010y\u001a\u00020XH\u0016J\u001b\u0010\u0082\u0001\u001a\u00020R2\u0007\u0010\u0083\u0001\u001a\u00020Z2\u0007\u0010\u0084\u0001\u001a\u00020\u0006H\u0016J\u0099\u0001\u0010\u0085\u0001\u001a\u00020R2\u0007\u0010\u0086\u0001\u001a\u00020\u00062\u0007\u0010\u0087\u0001\u001a\u00020\u00062\u0007\u0010\u0088\u0001\u001a\u00020Z2\u0007\u0010\u0089\u0001\u001a\u00020\u00062\u0007\u0010\u008a\u0001\u001a\u00020\u00062\u0007\u0010\u008b\u0001\u001a\u00020\u00062\u0007\u0010\u008c\u0001\u001a\u00020\u00062\u0007\u0010\u008d\u0001\u001a\u00020\u00062\u0007\u0010\u008e\u0001\u001a\u00020\u00062\u0007\u0010\u008f\u0001\u001a\u00020\u00062\u0007\u0010\u0090\u0001\u001a\u00020\u00062\u0007\u0010\u0091\u0001\u001a\u00020\u00062\u0007\u0010\u0092\u0001\u001a\u00020\u00062\u0007\u0010\u0093\u0001\u001a\u00020Z2\u0007\u0010\u0094\u0001\u001a\u00020Z2\u0007\u0010\u0095\u0001\u001a\u00020\u0006H\u0016J\u0011\u0010\u0096\u0001\u001a\u00020R2\u0006\u0010y\u001a\u00020XH\u0016J\u0011\u0010\u0097\u0001\u001a\u00020R2\u0006\u0010y\u001a\u00020\u0006H\u0016J\u0011\u0010\u0098\u0001\u001a\u00020R2\u0006\u0010y\u001a\u00020\u0006H\u0016J\u0011\u0010\u0099\u0001\u001a\u00020R2\u0006\u0010y\u001a\u00020\u0006H\u0016J\u0014\u0010\u009a\u0001\u001a\u00020R2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0011\u0010\u009b\u0001\u001a\u00020R2\u0006\u0010y\u001a\u00020XH\u0016J\u0012\u0010\u009c\u0001\u001a\u00020R2\u0007\u0010\u0086\u0001\u001a\u00020\u0006H\u0016J\u0011\u0010\u009d\u0001\u001a\u00020R2\u0006\u0010y\u001a\u00020XH\u0016JH\u0010\u009e\u0001\u001a\u00020R2\u0007\u0010\u0095\u0001\u001a\u00020\u00062\u0007\u0010\u008f\u0001\u001a\u00020\u00062\u0007\u0010\u008e\u0001\u001a\u00020\u00062\u0007\u0010\u009f\u0001\u001a\u00020\u00062\u0007\u0010 \u0001\u001a\u00020Z2\u0007\u0010\u0090\u0001\u001a\u00020\u00062\u0007\u0010¡\u0001\u001a\u00020\u0006H\u0016J\u0011\u0010¢\u0001\u001a\u00020R2\u0006\u0010y\u001a\u00020\u0006H\u0016J\u0011\u0010£\u0001\u001a\u00020R2\u0006\u0010y\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0014\u0010\u001b\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR\u0014\u0010\u001d\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u0014\u0010\u001f\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\bR\u0014\u0010!\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\bR\u0014\u0010#\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\bR\u0014\u0010%\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u0014\u0010'\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\bR\u0014\u0010)\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\bR\u0014\u0010+\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\bR\u0014\u0010-\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\bR\u0014\u0010/\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\bR\u0014\u00101\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\bR\u0014\u00103\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\bR\u0014\u00105\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\bR\u0014\u00107\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\bR\u0014\u00109\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\bR\u0014\u0010;\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\bR\u0014\u0010=\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\bR\u0014\u0010?\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\bR\u0014\u0010A\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\bR\u0014\u0010C\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\bR\u0014\u0010E\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\bR\u0014\u0010G\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\bR\u0014\u0010I\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\bR\u0014\u0010K\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\bR\u0014\u0010M\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\bR\u000e\u0010O\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¤\u0001"}, d2 = {"Lin/etuwa/app/data/preference/SharedPrefManager;", "Lin/etuwa/app/data/preference/SharedPrefManagerHelper;", "app", "Lin/etuwa/app/EtlabApp;", "(Lin/etuwa/app/EtlabApp;)V", "DUE_NEW", "", "getDUE_NEW", "()Ljava/lang/String;", "FEE_ENGNR_STATUS", "getFEE_ENGNR_STATUS", "PREF_ATT_PERCENT", "getPREF_ATT_PERCENT", "PREF_BASE_URL", "getPREF_BASE_URL", "PREF_COLLEGE", "getPREF_COLLEGE", "PREF_COLLEGE_ID", "getPREF_COLLEGE_ID", "PREF_END_YEAR", "getPREF_END_YEAR", "PREF_FEE_STATUS", "getPREF_FEE_STATUS", "PREF_LOGIN", "getPREF_LOGIN", "PREF_LOGIN_STATUS", "getPREF_LOGIN_STATUS", "PREF_NEW_LOGIN", "getPREF_NEW_LOGIN", "PREF_NOTICE_ONE", "getPREF_NOTICE_ONE", "PREF_NOTICE_THREE", "getPREF_NOTICE_THREE", "PREF_NOTICE_TWO", "getPREF_NOTICE_TWO", "PREF_PUSH_TOKEN_SERVER_STATUS", "getPREF_PUSH_TOKEN_SERVER_STATUS", "PREF_REG_URL", "getPREF_REG_URL", "PREF_START_YEAR", "getPREF_START_YEAR", "PREF_SURVEY_STATUS", "getPREF_SURVEY_STATUS", "PREF_TOKEN", "getPREF_TOKEN", "PREF_USER_BATCH_ID", "getPREF_USER_BATCH_ID", "PREF_USER_COURSE", "getPREF_USER_COURSE", "PREF_USER_HOSTEL", "getPREF_USER_HOSTEL", "PREF_USER_HOSTEL_STATUS", "getPREF_USER_HOSTEL_STATUS", "PREF_USER_IMG", "getPREF_USER_IMG", "PREF_USER_NAME", "getPREF_USER_NAME", "PREF_USER_PASSWORD", "getPREF_USER_PASSWORD", "PREF_USER_PRO_NAME", "getPREF_USER_PRO_NAME", "PREF_USER_PUSH_TOKEN", "getPREF_USER_PUSH_TOKEN", "PREF_USER_PUSH_TOKEN_STATUS", "getPREF_USER_PUSH_TOKEN_STATUS", "PREF_USER_SEM", "getPREF_USER_SEM", "PREF_USER_SEM_ID", "getPREF_USER_SEM_ID", "PREF_USER_TYPE", "getPREF_USER_TYPE", "PREF_USER_TYPE_NEW", "getPREF_USER_TYPE_NEW", "PREF_USER_UNIV", "getPREF_USER_UNIV", "PREF_USER_YEAR", "getPREF_USER_YEAR", "PREF_VERSION_CODE", "getPREF_VERSION_CODE", "prefernce", "Landroid/content/SharedPreferences;", "clearData", "", "getAcademicYear", "getAttendancePercentage", "getBaseUrl", "getBatchId", "getClg", "", "getClgId", "", "getDueNew", "getEndYear", "getFeeEngnrNew", "getFeeStatus", "getHostel", "getHostelStatus", "getLogin", "getLoginStatus", "getNewLogin", "getNoticeOne", "getNoticeThree", "getNoticeTwo", "getPassword", "getPushToken", "getPushTokenServerStatus", "getPushTokenStatus", "getRegUrl", "getStartYear", "getSurveyStatus", "getToken", "getUserCourse", "getUserImg", "getUserName", "getUserProName", "getUserSem", "getUserSemId", "getUserType", "getUserTypeNew", "getVersionCode", "setAttendancePercentage", NotificationCompat.CATEGORY_STATUS, "setClg", "clg", "id", "url", "regUrl", "setDueNew", "setFeeEngnrNew", "setFeeStatus", "setHostelStatus", "user_hostel", "user_hostel_status", "setLogin", "token", "userType", "userHostel", "userHostelStatus", "userProName", "userYear", "userUniv", "userImg", "semName", "semId", "course", "uName", "passkey", "startYear", "endYear", "batchId", "setNewLogin", "setNoticeOne", "setNoticeThree", "setNoticeTwo", "setPushToken", "setPushTokenServerStatus", "setRefreshToken", "setSurveyStatus", "setUpdateUserData", "hostelStatus", "hostel", "img", "setUserTypeNew", "setVersionCode", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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