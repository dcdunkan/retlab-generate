package in.etuwa.app.data.model.mess;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OrderHistory.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMenu() {
        return this.menu;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getQuantity() {
        return this.quantity;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBooking_date() {
        return this.booking_date;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
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