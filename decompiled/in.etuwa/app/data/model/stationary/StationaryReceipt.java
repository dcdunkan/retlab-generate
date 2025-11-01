package in.etuwa.app.data.model.stationary;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StationaryReceipt.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006*"}, d2 = {"Lin/etuwa/app/data/model/stationary/StationaryReceipt;", "", "id", "", "receipt_no", "total_amount", FirebaseAnalytics.Param.METHOD, "receipt_date", NotificationCompat.CATEGORY_STATUS, "created_user", "view_url", "print_url", "create_time", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreate_time", "()Ljava/lang/String;", "getCreated_user", "getId", "getMethod", "getPrint_url", "getReceipt_date", "getReceipt_no", "getStatus", "getTotal_amount", "getView_url", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class StationaryReceipt {
    private final String create_time;
    private final String created_user;
    private final String id;
    private final String method;
    private final String print_url;
    private final String receipt_date;
    private final String receipt_no;
    private final String status;
    private final String total_amount;
    private final String view_url;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getCreate_time() {
        return this.create_time;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReceipt_no() {
        return this.receipt_no;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTotal_amount() {
        return this.total_amount;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component5, reason: from getter */
    public final String getReceipt_date() {
        return this.receipt_date;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCreated_user() {
        return this.created_user;
    }

    /* renamed from: component8, reason: from getter */
    public final String getView_url() {
        return this.view_url;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPrint_url() {
        return this.print_url;
    }

    public final StationaryReceipt copy(String id, String receipt_no, String total_amount, String method, String receipt_date, String status, String created_user, String view_url, String print_url, String create_time) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(receipt_no, "receipt_no");
        Intrinsics.checkNotNullParameter(total_amount, "total_amount");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(receipt_date, "receipt_date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(created_user, "created_user");
        Intrinsics.checkNotNullParameter(view_url, "view_url");
        Intrinsics.checkNotNullParameter(print_url, "print_url");
        Intrinsics.checkNotNullParameter(create_time, "create_time");
        return new StationaryReceipt(id, receipt_no, total_amount, method, receipt_date, status, created_user, view_url, print_url, create_time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StationaryReceipt)) {
            return false;
        }
        StationaryReceipt stationaryReceipt = (StationaryReceipt) other;
        return Intrinsics.areEqual(this.id, stationaryReceipt.id) && Intrinsics.areEqual(this.receipt_no, stationaryReceipt.receipt_no) && Intrinsics.areEqual(this.total_amount, stationaryReceipt.total_amount) && Intrinsics.areEqual(this.method, stationaryReceipt.method) && Intrinsics.areEqual(this.receipt_date, stationaryReceipt.receipt_date) && Intrinsics.areEqual(this.status, stationaryReceipt.status) && Intrinsics.areEqual(this.created_user, stationaryReceipt.created_user) && Intrinsics.areEqual(this.view_url, stationaryReceipt.view_url) && Intrinsics.areEqual(this.print_url, stationaryReceipt.print_url) && Intrinsics.areEqual(this.create_time, stationaryReceipt.create_time);
    }

    public int hashCode() {
        return (((((((((((((((((this.id.hashCode() * 31) + this.receipt_no.hashCode()) * 31) + this.total_amount.hashCode()) * 31) + this.method.hashCode()) * 31) + this.receipt_date.hashCode()) * 31) + this.status.hashCode()) * 31) + this.created_user.hashCode()) * 31) + this.view_url.hashCode()) * 31) + this.print_url.hashCode()) * 31) + this.create_time.hashCode();
    }

    public String toString() {
        return "StationaryReceipt(id=" + this.id + ", receipt_no=" + this.receipt_no + ", total_amount=" + this.total_amount + ", method=" + this.method + ", receipt_date=" + this.receipt_date + ", status=" + this.status + ", created_user=" + this.created_user + ", view_url=" + this.view_url + ", print_url=" + this.print_url + ", create_time=" + this.create_time + ")";
    }

    public StationaryReceipt(String id, String receipt_no, String total_amount, String method, String receipt_date, String status, String created_user, String view_url, String print_url, String create_time) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(receipt_no, "receipt_no");
        Intrinsics.checkNotNullParameter(total_amount, "total_amount");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(receipt_date, "receipt_date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(created_user, "created_user");
        Intrinsics.checkNotNullParameter(view_url, "view_url");
        Intrinsics.checkNotNullParameter(print_url, "print_url");
        Intrinsics.checkNotNullParameter(create_time, "create_time");
        this.id = id;
        this.receipt_no = receipt_no;
        this.total_amount = total_amount;
        this.method = method;
        this.receipt_date = receipt_date;
        this.status = status;
        this.created_user = created_user;
        this.view_url = view_url;
        this.print_url = print_url;
        this.create_time = create_time;
    }

    public final String getId() {
        return this.id;
    }

    public final String getReceipt_no() {
        return this.receipt_no;
    }

    public final String getTotal_amount() {
        return this.total_amount;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getReceipt_date() {
        return this.receipt_date;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getCreated_user() {
        return this.created_user;
    }

    public final String getView_url() {
        return this.view_url;
    }

    public final String getPrint_url() {
        return this.print_url;
    }

    public final String getCreate_time() {
        return this.create_time;
    }
}