package in.etuwa.app.data.model.mess;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessMenu.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/data/model/mess/MessMenu;", "", "type", "", "type_name", "", CommonCssConstants.MENU, "max_qty", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMax_qty", "()Ljava/lang/String;", "getMenu", "getType", "()I", "getType_name", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MessMenu {
    private final String max_qty;
    private final String menu;
    private final int type;
    private final String type_name;

    public static /* synthetic */ MessMenu copy$default(MessMenu messMenu, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = messMenu.type;
        }
        if ((i2 & 2) != 0) {
            str = messMenu.type_name;
        }
        if ((i2 & 4) != 0) {
            str2 = messMenu.menu;
        }
        if ((i2 & 8) != 0) {
            str3 = messMenu.max_qty;
        }
        return messMenu.copy(i, str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType_name() {
        return this.type_name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMenu() {
        return this.menu;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMax_qty() {
        return this.max_qty;
    }

    public final MessMenu copy(int type, String type_name, String menu, String max_qty) {
        Intrinsics.checkNotNullParameter(type_name, "type_name");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(max_qty, "max_qty");
        return new MessMenu(type, type_name, menu, max_qty);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessMenu)) {
            return false;
        }
        MessMenu messMenu = (MessMenu) other;
        return this.type == messMenu.type && Intrinsics.areEqual(this.type_name, messMenu.type_name) && Intrinsics.areEqual(this.menu, messMenu.menu) && Intrinsics.areEqual(this.max_qty, messMenu.max_qty);
    }

    public int hashCode() {
        return (((((this.type * 31) + this.type_name.hashCode()) * 31) + this.menu.hashCode()) * 31) + this.max_qty.hashCode();
    }

    public String toString() {
        return "MessMenu(type=" + this.type + ", type_name=" + this.type_name + ", menu=" + this.menu + ", max_qty=" + this.max_qty + ")";
    }

    public MessMenu(int i, String type_name, String menu, String max_qty) {
        Intrinsics.checkNotNullParameter(type_name, "type_name");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(max_qty, "max_qty");
        this.type = i;
        this.type_name = type_name;
        this.menu = menu;
        this.max_qty = max_qty;
    }

    public final int getType() {
        return this.type;
    }

    public final String getType_name() {
        return this.type_name;
    }

    public final String getMenu() {
        return this.menu;
    }

    public final String getMax_qty() {
        return this.max_qty;
    }
}