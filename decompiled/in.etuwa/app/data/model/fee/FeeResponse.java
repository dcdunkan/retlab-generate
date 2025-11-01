package in.etuwa.app.data.model.fee;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeeResponse.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u007f\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\nHÖ\u0001R\u0016\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0010\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u0006/"}, d2 = {"Lin/etuwa/app/data/model/fee/FeeResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "success", "feeGroups", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/fee/FeeGroups;", "Lkotlin/collections/ArrayList;", FeeConfirmDialogKt.ARG_TOTAL, "", "paid", "balance", "date", "studentId", "url", "message", "(ZZLjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBalance", "()Ljava/lang/String;", "getDate", "getFeeGroups", "()Ljava/util/ArrayList;", "getLogin", "()Z", "getMessage", "getPaid", "getStudentId", "getSuccess", "getTotal", "getUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FeeResponse {

    @SerializedName("balance")
    @Expose
    private final String balance;

    @SerializedName("date")
    @Expose
    private final String date;

    @SerializedName("fee_groups")
    @Expose
    private final ArrayList<FeeGroups> feeGroups;

    @SerializedName(FirebaseAnalytics.Event.LOGIN)
    @Expose
    private final boolean login;

    @SerializedName("message")
    @Expose
    private final String message;

    @SerializedName("paid")
    @Expose
    private final String paid;

    @SerializedName("student_id")
    private final String studentId;

    @SerializedName("success")
    @Expose
    private final boolean success;

    @SerializedName(FeeConfirmDialogKt.ARG_TOTAL)
    @Expose
    private final String total;

    @SerializedName("url")
    private final String url;

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component10, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<FeeGroups> component3() {
        return this.feeGroups;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTotal() {
        return this.total;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPaid() {
        return this.paid;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component8, reason: from getter */
    public final String getStudentId() {
        return this.studentId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final FeeResponse copy(boolean login, boolean success, ArrayList<FeeGroups> feeGroups, String total, String paid, String balance, String date, String studentId, String url, String message) {
        Intrinsics.checkNotNullParameter(feeGroups, "feeGroups");
        Intrinsics.checkNotNullParameter(total, "total");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(message, "message");
        return new FeeResponse(login, success, feeGroups, total, paid, balance, date, studentId, url, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeeResponse)) {
            return false;
        }
        FeeResponse feeResponse = (FeeResponse) other;
        return this.login == feeResponse.login && this.success == feeResponse.success && Intrinsics.areEqual(this.feeGroups, feeResponse.feeGroups) && Intrinsics.areEqual(this.total, feeResponse.total) && Intrinsics.areEqual(this.paid, feeResponse.paid) && Intrinsics.areEqual(this.balance, feeResponse.balance) && Intrinsics.areEqual(this.date, feeResponse.date) && Intrinsics.areEqual(this.studentId, feeResponse.studentId) && Intrinsics.areEqual(this.url, feeResponse.url) && Intrinsics.areEqual(this.message, feeResponse.message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.success;
        int hashCode = (((((((((((((i + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.feeGroups.hashCode()) * 31) + this.total.hashCode()) * 31) + this.paid.hashCode()) * 31) + this.balance.hashCode()) * 31) + this.date.hashCode()) * 31) + this.studentId.hashCode()) * 31;
        String str = this.url;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "FeeResponse(login=" + this.login + ", success=" + this.success + ", feeGroups=" + this.feeGroups + ", total=" + this.total + ", paid=" + this.paid + ", balance=" + this.balance + ", date=" + this.date + ", studentId=" + this.studentId + ", url=" + this.url + ", message=" + this.message + ")";
    }

    public FeeResponse(boolean z, boolean z2, ArrayList<FeeGroups> feeGroups, String total, String paid, String balance, String date, String studentId, String str, String message) {
        Intrinsics.checkNotNullParameter(feeGroups, "feeGroups");
        Intrinsics.checkNotNullParameter(total, "total");
        Intrinsics.checkNotNullParameter(paid, "paid");
        Intrinsics.checkNotNullParameter(balance, "balance");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(message, "message");
        this.login = z;
        this.success = z2;
        this.feeGroups = feeGroups;
        this.total = total;
        this.paid = paid;
        this.balance = balance;
        this.date = date;
        this.studentId = studentId;
        this.url = str;
        this.message = message;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final ArrayList<FeeGroups> getFeeGroups() {
        return this.feeGroups;
    }

    public final String getTotal() {
        return this.total;
    }

    public final String getPaid() {
        return this.paid;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getStudentId() {
        return this.studentId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getMessage() {
        return this.message;
    }
}