package in.etuwa.app.data.model.login;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginResponse.kt */
/* loaded from: classes3.dex */
public final class LoginResponse {

    @SerializedName("academic_year")
    @Expose
    private final String academicYear;

    @SerializedName("access_token")
    @Expose
    private final String accessToken;

    @SerializedName("batch_id")
    @Expose
    private final String batchId;

    @SerializedName("course")
    @Expose
    private final String course;

    @SerializedName("end_year")
    @Expose
    private final int endYear;

    @SerializedName(Constants.IPC_BUNDLE_KEY_SEND_ERROR)
    @Expose
    private final String error;

    @SerializedName("hostel")
    @Expose
    private final int hostel;

    @SerializedName("hostel_status")
    @Expose
    private final String hostelStatus;

    @SerializedName("isktu")
    @Expose
    private final boolean isktu;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("logout_status")
    @Expose
    private final String logoutStatus;

    @SerializedName("password")
    @Expose
    private final String password;

    @SerializedName("url")
    @Expose
    private final String photoUrl;

    @SerializedName("profile_name")
    @Expose
    private final String profileName;

    @SerializedName("sem_id")
    @Expose
    private final String semId;

    @SerializedName("sem_name")
    @Expose
    private final String semName;

    @SerializedName("start_year")
    @Expose
    private final int startYear;

    @SerializedName("univ")
    @Expose
    private final String univ;

    @SerializedName("user_type")
    @Expose
    private final String userType;

    @SerializedName("uname")
    @Expose
    private final String username;

    public LoginResponse(boolean z, String accessToken, String userType, String logoutStatus, String univ, int i, String hostelStatus, String batchId, String semId, String semName, String profileName, String course, String academicYear, int i2, int i3, String photoUrl, String username, String password, boolean z2, String error) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(userType, "userType");
        Intrinsics.checkNotNullParameter(logoutStatus, "logoutStatus");
        Intrinsics.checkNotNullParameter(univ, "univ");
        Intrinsics.checkNotNullParameter(hostelStatus, "hostelStatus");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(semId, "semId");
        Intrinsics.checkNotNullParameter(semName, "semName");
        Intrinsics.checkNotNullParameter(profileName, "profileName");
        Intrinsics.checkNotNullParameter(course, "course");
        Intrinsics.checkNotNullParameter(academicYear, "academicYear");
        Intrinsics.checkNotNullParameter(photoUrl, "photoUrl");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.accessToken = accessToken;
        this.userType = userType;
        this.logoutStatus = logoutStatus;
        this.univ = univ;
        this.hostel = i;
        this.hostelStatus = hostelStatus;
        this.batchId = batchId;
        this.semId = semId;
        this.semName = semName;
        this.profileName = profileName;
        this.course = course;
        this.academicYear = academicYear;
        this.startYear = i2;
        this.endYear = i3;
        this.photoUrl = photoUrl;
        this.username = username;
        this.password = password;
        this.isktu = z2;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getUserType() {
        return this.userType;
    }

    public final String getLogoutStatus() {
        return this.logoutStatus;
    }

    public final String getUniv() {
        return this.univ;
    }

    public final int getHostel() {
        return this.hostel;
    }

    public final String getHostelStatus() {
        return this.hostelStatus;
    }

    public final String getBatchId() {
        return this.batchId;
    }

    public final String getSemId() {
        return this.semId;
    }

    public final String getSemName() {
        return this.semName;
    }

    public final String getProfileName() {
        return this.profileName;
    }

    public final String getCourse() {
        return this.course;
    }

    public final String getAcademicYear() {
        return this.academicYear;
    }

    public final int getStartYear() {
        return this.startYear;
    }

    public final int getEndYear() {
        return this.endYear;
    }

    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getPassword() {
        return this.password;
    }

    public final boolean getIsktu() {
        return this.isktu;
    }

    public final String getError() {
        return this.error;
    }
}