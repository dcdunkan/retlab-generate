package in.etuwa.app.data.model.mess;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessMenu.kt */
/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType_name() {
        return this.type_name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMenu() {
        return this.menu;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
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