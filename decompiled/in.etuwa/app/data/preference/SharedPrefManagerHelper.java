package in.etuwa.app.data.preference;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* compiled from: SharedPrefManagerHelper.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\bJ\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\nH&J\b\u0010\u0010\u001a\u00020\nH&J\b\u0010\u0011\u001a\u00020\fH&J\b\u0010\u0012\u001a\u00020\u0005H&J\b\u0010\u0013\u001a\u00020\nH&J\b\u0010\u0014\u001a\u00020\nH&J\b\u0010\u0015\u001a\u00020\nH&J\b\u0010\u0016\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\u0005H&J\b\u0010\u0018\u001a\u00020\u0005H&J\b\u0010\u0019\u001a\u00020\u0005H&J\b\u0010\u001a\u001a\u00020\u0005H&J\b\u0010\u001b\u001a\u00020\nH&J\b\u0010\u001c\u001a\u00020\nH&J\b\u0010\u001d\u001a\u00020\u0005H&J\b\u0010\u001e\u001a\u00020\fH&J\b\u0010\u001f\u001a\u00020\nH&J\b\u0010 \u001a\u00020\u0005H&J\b\u0010!\u001a\u00020\u0005H&J\b\u0010\"\u001a\u00020\u0005H&J\b\u0010#\u001a\u00020\u0005H&J\b\u0010$\u001a\u00020\u0005H&J\b\u0010%\u001a\u00020\u0005H&J\b\u0010&\u001a\u00020\u0005H&J\b\u0010'\u001a\u00020\u0005H&J\b\u0010(\u001a\u00020\u0005H&J\b\u0010)\u001a\u00020\u0005H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0005H&J(\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H&J\u0010\u00101\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0005H&J\u0010\u00102\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\nH&J\u0010\u00103\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\nH&J\u0018\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\u0005H&J\u0088\u0001\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\u0005H&J\u0010\u0010H\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\nH&J\u0010\u0010I\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0005H&J\u0010\u0010J\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0005H&J\u0010\u0010K\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0005H&J\u0012\u0010L\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010M\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\nH&J\u0010\u0010N\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0005H&J\u0010\u0010O\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\nH&J@\u0010P\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\f2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005H&J\u0010\u0010T\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0005H&J\u0010\u0010U\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0005H&¨\u0006V"}, d2 = {"Lin/etuwa/app/data/preference/SharedPrefManagerHelper;", "", "clearData", "", "getAcademicYear", "", "getAttendancePercentage", "getBaseUrl", "getBatchId", "getClg", "", "getClgId", "", "getDueNew", "getEndYear", "getFeeEngnrNew", "getFeeStatus", "getHostel", "getHostelStatus", "getLogin", "getLoginStatus", "getNewLogin", "getNoticeOne", "getNoticeThree", "getNoticeTwo", "getPassword", "getPushToken", "getPushTokenServerStatus", "getPushTokenStatus", "getRegUrl", "getStartYear", "getSurveyStatus", "getToken", "getUserCourse", "getUserImg", "getUserName", "getUserProName", "getUserSem", "getUserSemId", "getUserType", "getUserTypeNew", "getVersionCode", "setAttendancePercentage", NotificationCompat.CATEGORY_STATUS, "setClg", "clg", "id", "url", "regUrl", "setDueNew", "setFeeEngnrNew", "setFeeStatus", "setHostelStatus", "user_hostel", "user_hostel_status", "setLogin", "token", "userType", "userHostel", "userHostelStatus", "userProName", "userYear", "userUniv", "userImg", "semName", "semId", "course", "uName", "passkey", "startYear", "endYear", "batchId", "setNewLogin", "setNoticeOne", "setNoticeThree", "setNoticeTwo", "setPushToken", "setPushTokenServerStatus", "setRefreshToken", "setSurveyStatus", "setUpdateUserData", "hostelStatus", "hostel", "img", "setUserTypeNew", "setVersionCode", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SharedPrefManagerHelper {
    void clearData();

    String getAcademicYear();

    String getAttendancePercentage();

    String getBaseUrl();

    String getBatchId();

    boolean getClg();

    int getClgId();

    String getDueNew();

    int getEndYear();

    boolean getFeeEngnrNew();

    boolean getFeeStatus();

    int getHostel();

    String getHostelStatus();

    boolean getLogin();

    boolean getLoginStatus();

    boolean getNewLogin();

    String getNoticeOne();

    String getNoticeThree();

    String getNoticeTwo();

    String getPassword();

    String getPushToken();

    boolean getPushTokenServerStatus();

    boolean getPushTokenStatus();

    String getRegUrl();

    int getStartYear();

    boolean getSurveyStatus();

    String getToken();

    String getUserCourse();

    String getUserImg();

    String getUserName();

    String getUserProName();

    String getUserSem();

    String getUserSemId();

    String getUserType();

    String getUserTypeNew();

    String getVersionCode();

    void setAttendancePercentage(String status);

    void setClg(boolean clg, int id, String url, String regUrl);

    void setDueNew(String status);

    void setFeeEngnrNew(boolean status);

    void setFeeStatus(boolean status);

    void setHostelStatus(int user_hostel, String user_hostel_status);

    void setLogin(String token, String userType, int userHostel, String userHostelStatus, String userProName, String userYear, String userUniv, String userImg, String semName, String semId, String course, String uName, String passkey, int startYear, int endYear, String batchId);

    void setNewLogin(boolean status);

    void setNoticeOne(String status);

    void setNoticeThree(String status);

    void setNoticeTwo(String status);

    void setPushToken(String token);

    void setPushTokenServerStatus(boolean status);

    void setRefreshToken(String token);

    void setSurveyStatus(boolean status);

    void setUpdateUserData(String batchId, String semId, String semName, String hostelStatus, int hostel, String course, String img);

    void setUserTypeNew(String status);

    void setVersionCode(String status);
}