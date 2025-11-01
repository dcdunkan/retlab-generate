package in.etuwa.app.data.model.transportpalai;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BusPass.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b8\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J³\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0005HÆ\u0001J\u0013\u0010;\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017¨\u0006@"}, d2 = {"Lin/etuwa/app/data/model/transportpalai/BusPass;", "", FirebaseAnalytics.Event.LOGIN, "", "photo_url", "", "qr_code", "full_name", "batch", "admission_no", "program", TypedValues.TransitionType.S_DURATION, AttendanceDayDialogKt.ARG_SEM, "gender", "route", "boarding", "category", "validity", "pass_code", "url", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdmission_no", "()Ljava/lang/String;", "getBatch", "getBoarding", "getCategory", "getDuration", "getError", "getFull_name", "getGender", "getLogin", "()Z", "getPass_code", "getPhoto_url", "getProgram", "getQr_code", "getRoute", "getSemester", "getUrl", "getValidity", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BusPass {
    private final String admission_no;
    private final String batch;
    private final String boarding;
    private final String category;
    private final String duration;
    private final String error;
    private final String full_name;
    private final String gender;
    private final boolean login;
    private final String pass_code;
    private final String photo_url;
    private final String program;
    private final String qr_code;
    private final String route;
    private final String semester;
    private final String url;
    private final String validity;

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component10, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    /* renamed from: component11, reason: from getter */
    public final String getRoute() {
        return this.route;
    }

    /* renamed from: component12, reason: from getter */
    public final String getBoarding() {
        return this.boarding;
    }

    /* renamed from: component13, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component14, reason: from getter */
    public final String getValidity() {
        return this.validity;
    }

    /* renamed from: component15, reason: from getter */
    public final String getPass_code() {
        return this.pass_code;
    }

    /* renamed from: component16, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component17, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPhoto_url() {
        return this.photo_url;
    }

    /* renamed from: component3, reason: from getter */
    public final String getQr_code() {
        return this.qr_code;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFull_name() {
        return this.full_name;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBatch() {
        return this.batch;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAdmission_no() {
        return this.admission_no;
    }

    /* renamed from: component7, reason: from getter */
    public final String getProgram() {
        return this.program;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* renamed from: component9, reason: from getter */
    public final String getSemester() {
        return this.semester;
    }

    public final BusPass copy(boolean login, String photo_url, String qr_code, String full_name, String batch, String admission_no, String program, String duration, String semester, String gender, String route, String boarding, String category, String validity, String pass_code, String url, String error) {
        Intrinsics.checkNotNullParameter(photo_url, "photo_url");
        Intrinsics.checkNotNullParameter(qr_code, "qr_code");
        Intrinsics.checkNotNullParameter(full_name, "full_name");
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(program, "program");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(boarding, "boarding");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(validity, "validity");
        Intrinsics.checkNotNullParameter(pass_code, "pass_code");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(error, "error");
        return new BusPass(login, photo_url, qr_code, full_name, batch, admission_no, program, duration, semester, gender, route, boarding, category, validity, pass_code, url, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BusPass)) {
            return false;
        }
        BusPass busPass = (BusPass) other;
        return this.login == busPass.login && Intrinsics.areEqual(this.photo_url, busPass.photo_url) && Intrinsics.areEqual(this.qr_code, busPass.qr_code) && Intrinsics.areEqual(this.full_name, busPass.full_name) && Intrinsics.areEqual(this.batch, busPass.batch) && Intrinsics.areEqual(this.admission_no, busPass.admission_no) && Intrinsics.areEqual(this.program, busPass.program) && Intrinsics.areEqual(this.duration, busPass.duration) && Intrinsics.areEqual(this.semester, busPass.semester) && Intrinsics.areEqual(this.gender, busPass.gender) && Intrinsics.areEqual(this.route, busPass.route) && Intrinsics.areEqual(this.boarding, busPass.boarding) && Intrinsics.areEqual(this.category, busPass.category) && Intrinsics.areEqual(this.validity, busPass.validity) && Intrinsics.areEqual(this.pass_code, busPass.pass_code) && Intrinsics.areEqual(this.url, busPass.url) && Intrinsics.areEqual(this.error, busPass.error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((((((((((((((((((((((((r0 * 31) + this.photo_url.hashCode()) * 31) + this.qr_code.hashCode()) * 31) + this.full_name.hashCode()) * 31) + this.batch.hashCode()) * 31) + this.admission_no.hashCode()) * 31) + this.program.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.semester.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.route.hashCode()) * 31) + this.boarding.hashCode()) * 31) + this.category.hashCode()) * 31) + this.validity.hashCode()) * 31) + this.pass_code.hashCode()) * 31) + this.url.hashCode()) * 31) + this.error.hashCode();
    }

    public String toString() {
        return "BusPass(login=" + this.login + ", photo_url=" + this.photo_url + ", qr_code=" + this.qr_code + ", full_name=" + this.full_name + ", batch=" + this.batch + ", admission_no=" + this.admission_no + ", program=" + this.program + ", duration=" + this.duration + ", semester=" + this.semester + ", gender=" + this.gender + ", route=" + this.route + ", boarding=" + this.boarding + ", category=" + this.category + ", validity=" + this.validity + ", pass_code=" + this.pass_code + ", url=" + this.url + ", error=" + this.error + ")";
    }

    public BusPass(boolean z, String photo_url, String qr_code, String full_name, String batch, String admission_no, String program, String duration, String semester, String gender, String route, String boarding, String category, String validity, String pass_code, String url, String error) {
        Intrinsics.checkNotNullParameter(photo_url, "photo_url");
        Intrinsics.checkNotNullParameter(qr_code, "qr_code");
        Intrinsics.checkNotNullParameter(full_name, "full_name");
        Intrinsics.checkNotNullParameter(batch, "batch");
        Intrinsics.checkNotNullParameter(admission_no, "admission_no");
        Intrinsics.checkNotNullParameter(program, "program");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(semester, "semester");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(boarding, "boarding");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(validity, "validity");
        Intrinsics.checkNotNullParameter(pass_code, "pass_code");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(error, "error");
        this.login = z;
        this.photo_url = photo_url;
        this.qr_code = qr_code;
        this.full_name = full_name;
        this.batch = batch;
        this.admission_no = admission_no;
        this.program = program;
        this.duration = duration;
        this.semester = semester;
        this.gender = gender;
        this.route = route;
        this.boarding = boarding;
        this.category = category;
        this.validity = validity;
        this.pass_code = pass_code;
        this.url = url;
        this.error = error;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getPhoto_url() {
        return this.photo_url;
    }

    public final String getQr_code() {
        return this.qr_code;
    }

    public final String getFull_name() {
        return this.full_name;
    }

    public final String getBatch() {
        return this.batch;
    }

    public final String getAdmission_no() {
        return this.admission_no;
    }

    public final String getProgram() {
        return this.program;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getSemester() {
        return this.semester;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getRoute() {
        return this.route;
    }

    public final String getBoarding() {
        return this.boarding;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getValidity() {
        return this.validity;
    }

    public final String getPass_code() {
        return this.pass_code;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getError() {
        return this.error;
    }
}