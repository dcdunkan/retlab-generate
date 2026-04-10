package in.etuwa.app.data.preference;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: SharedPrefManagerHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    void setUserSemId(String status);

    void setUserTypeNew(String status);

    void setVersionCode(String status);
}