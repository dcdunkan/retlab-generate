package in.etuwa.app.data.model.mess;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderHistory.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/data/model/mess/OrderHistory;", "", "id", "", CommonCssConstants.MENU, FirebaseAnalytics.Param.QUANTITY, "booking_date", "type", NotificationCompat.CATEGORY_STATUS, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBooking_date", "()Ljava/lang/String;", "getId", "getMenu", "getQuantity", "getStatus", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OrderHistory {
    private final String booking_date;
    private final String id;
    private final String menu;
    private final String quantity;
    private final String status;
    private final String type;

    public static /* synthetic */ OrderHistory copy$default(OrderHistory orderHistory, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderHistory.id;
        }
        if ((i & 2) != 0) {
            str2 = orderHistory.menu;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = orderHistory.quantity;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = orderHistory.booking_date;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = orderHistory.type;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = orderHistory.status;
        }
        return orderHistory.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMenu() {
        return this.menu;
    }

    /* renamed from: component3, reason: from getter */
    public final String getQuantity() {
        return this.quantity;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBooking_date() {
        return this.booking_date;
    }

    /* renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component6, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final OrderHistory copy(String id, String menu, String quantity, String booking_date, String type, String status) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(quantity, "quantity");
        Intrinsics.checkNotNullParameter(booking_date, "booking_date");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(status, "status");
        return new OrderHistory(id, menu, quantity, booking_date, type, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderHistory)) {
            return false;
        }
        OrderHistory orderHistory = (OrderHistory) other;
        return Intrinsics.areEqual(this.id, orderHistory.id) && Intrinsics.areEqual(this.menu, orderHistory.menu) && Intrinsics.areEqual(this.quantity, orderHistory.quantity) && Intrinsics.areEqual(this.booking_date, orderHistory.booking_date) && Intrinsics.areEqual(this.type, orderHistory.type) && Intrinsics.areEqual(this.status, orderHistory.status);
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.menu.hashCode()) * 31) + this.quantity.hashCode()) * 31) + this.booking_date.hashCode()) * 31) + this.type.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "OrderHistory(id=" + this.id + ", menu=" + this.menu + ", quantity=" + this.quantity + ", booking_date=" + this.booking_date + ", type=" + this.type + ", status=" + this.status + ")";
    }

    public OrderHistory(String id, String menu, String quantity, String booking_date, String type, String status) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(quantity, "quantity");
        Intrinsics.checkNotNullParameter(booking_date, "booking_date");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(status, "status");
        this.id = id;
        this.menu = menu;
        this.quantity = quantity;
        this.booking_date = booking_date;
        this.type = type;
        this.status = status;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMenu() {
        return this.menu;
    }

    public final String getQuantity() {
        return this.quantity;
    }

    public final String getBooking_date() {
        return this.booking_date;
    }

    public final String getType() {
        return this.type;
    }

    public final String getStatus() {
        return this.status;
    }
}