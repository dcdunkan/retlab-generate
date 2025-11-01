package in.etuwa.app.data.model.hostel.attendance;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.svg.SvgConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelScanViewResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u0095\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001J\u0013\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00067"}, d2 = {"Lin/etuwa/app/data/model/hostel/attendance/HostelScanViewResponse;", "", FirebaseAnalytics.Event.LOGIN, "", "qrcode", "", "name", "hostel", "type", "from_date", NotificationCompat.CATEGORY_STATUS, "reason", "date", "room", "address", "phone_no", "url", SvgConstants.Tags.IMAGE, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getDate", "getFrom_date", "getHostel", "getImage", "getLogin", "()Z", "getName", "getPhone_no", "getQrcode", "getReason", "getRoom", "getStatus", "getType", "getUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HostelScanViewResponse {
    private final String address;
    private final String date;
    private final String from_date;
    private final String hostel;
    private final String image;
    private final boolean login;
    private final String name;
    private final String phone_no;
    private final String qrcode;
    private final String reason;
    private final String room;
    private final String status;
    private final String type;
    private final String url;

    /* renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    /* renamed from: component10, reason: from getter */
    public final String getRoom() {
        return this.room;
    }

    /* renamed from: component11, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component12, reason: from getter */
    public final String getPhone_no() {
        return this.phone_no;
    }

    /* renamed from: component13, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component14, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* renamed from: component2, reason: from getter */
    public final String getQrcode() {
        return this.qrcode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getHostel() {
        return this.hostel;
    }

    /* renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFrom_date() {
        return this.from_date;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component8, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    public final HostelScanViewResponse copy(boolean login, String qrcode, String name, String hostel, String type, String from_date, String status, String reason, String date, String room, String address, String phone_no, String url, String image) {
        Intrinsics.checkNotNullParameter(qrcode, "qrcode");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(from_date, "from_date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(room, "room");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(phone_no, "phone_no");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(image, "image");
        return new HostelScanViewResponse(login, qrcode, name, hostel, type, from_date, status, reason, date, room, address, phone_no, url, image);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostelScanViewResponse)) {
            return false;
        }
        HostelScanViewResponse hostelScanViewResponse = (HostelScanViewResponse) other;
        return this.login == hostelScanViewResponse.login && Intrinsics.areEqual(this.qrcode, hostelScanViewResponse.qrcode) && Intrinsics.areEqual(this.name, hostelScanViewResponse.name) && Intrinsics.areEqual(this.hostel, hostelScanViewResponse.hostel) && Intrinsics.areEqual(this.type, hostelScanViewResponse.type) && Intrinsics.areEqual(this.from_date, hostelScanViewResponse.from_date) && Intrinsics.areEqual(this.status, hostelScanViewResponse.status) && Intrinsics.areEqual(this.reason, hostelScanViewResponse.reason) && Intrinsics.areEqual(this.date, hostelScanViewResponse.date) && Intrinsics.areEqual(this.room, hostelScanViewResponse.room) && Intrinsics.areEqual(this.address, hostelScanViewResponse.address) && Intrinsics.areEqual(this.phone_no, hostelScanViewResponse.phone_no) && Intrinsics.areEqual(this.url, hostelScanViewResponse.url) && Intrinsics.areEqual(this.image, hostelScanViewResponse.image);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((((((((((((((((((r0 * 31) + this.qrcode.hashCode()) * 31) + this.name.hashCode()) * 31) + this.hostel.hashCode()) * 31) + this.type.hashCode()) * 31) + this.from_date.hashCode()) * 31) + this.status.hashCode()) * 31) + this.reason.hashCode()) * 31) + this.date.hashCode()) * 31) + this.room.hashCode()) * 31) + this.address.hashCode()) * 31) + this.phone_no.hashCode()) * 31) + this.url.hashCode()) * 31) + this.image.hashCode();
    }

    public String toString() {
        return "HostelScanViewResponse(login=" + this.login + ", qrcode=" + this.qrcode + ", name=" + this.name + ", hostel=" + this.hostel + ", type=" + this.type + ", from_date=" + this.from_date + ", status=" + this.status + ", reason=" + this.reason + ", date=" + this.date + ", room=" + this.room + ", address=" + this.address + ", phone_no=" + this.phone_no + ", url=" + this.url + ", image=" + this.image + ")";
    }

    public HostelScanViewResponse(boolean z, String qrcode, String name, String hostel, String type, String from_date, String status, String reason, String date, String room, String address, String phone_no, String url, String image) {
        Intrinsics.checkNotNullParameter(qrcode, "qrcode");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hostel, "hostel");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(from_date, "from_date");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(room, "room");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(phone_no, "phone_no");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(image, "image");
        this.login = z;
        this.qrcode = qrcode;
        this.name = name;
        this.hostel = hostel;
        this.type = type;
        this.from_date = from_date;
        this.status = status;
        this.reason = reason;
        this.date = date;
        this.room = room;
        this.address = address;
        this.phone_no = phone_no;
        this.url = url;
        this.image = image;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final String getQrcode() {
        return this.qrcode;
    }

    public final String getName() {
        return this.name;
    }

    public final String getHostel() {
        return this.hostel;
    }

    public final String getType() {
        return this.type;
    }

    public final String getFrom_date() {
        return this.from_date;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getRoom() {
        return this.room;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getPhone_no() {
        return this.phone_no;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getImage() {
        return this.image;
    }
}