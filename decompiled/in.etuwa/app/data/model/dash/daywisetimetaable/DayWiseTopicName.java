package in.etuwa.app.data.model.dash.daywisetimetaable;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DayWiseTopicName.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Lin/etuwa/app/data/model/dash/daywisetimetaable/DayWiseTopicName;", "", "hour", "", "type", "", "topic_name", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "subject", "staff", "(ILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "getHour", "()I", "getStaff", "()Ljava/lang/String;", "getSubject", "getTopic_name", "()Ljava/util/ArrayList;", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DayWiseTopicName {
    private final int hour;
    private final String staff;
    private final String subject;
    private final ArrayList<String> topic_name;
    private final String type;

    public static /* synthetic */ DayWiseTopicName copy$default(DayWiseTopicName dayWiseTopicName, int i, String str, ArrayList arrayList, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dayWiseTopicName.hour;
        }
        if ((i2 & 2) != 0) {
            str = dayWiseTopicName.type;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            arrayList = dayWiseTopicName.topic_name;
        }
        ArrayList arrayList2 = arrayList;
        if ((i2 & 8) != 0) {
            str2 = dayWiseTopicName.subject;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            str3 = dayWiseTopicName.staff;
        }
        return dayWiseTopicName.copy(i, str4, arrayList2, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHour() {
        return this.hour;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ArrayList<String> component3() {
        return this.topic_name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component5, reason: from getter */
    public final String getStaff() {
        return this.staff;
    }

    public final DayWiseTopicName copy(int hour, String type, ArrayList<String> topic_name, String subject, String staff) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(topic_name, "topic_name");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(staff, "staff");
        return new DayWiseTopicName(hour, type, topic_name, subject, staff);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DayWiseTopicName)) {
            return false;
        }
        DayWiseTopicName dayWiseTopicName = (DayWiseTopicName) other;
        return this.hour == dayWiseTopicName.hour && Intrinsics.areEqual(this.type, dayWiseTopicName.type) && Intrinsics.areEqual(this.topic_name, dayWiseTopicName.topic_name) && Intrinsics.areEqual(this.subject, dayWiseTopicName.subject) && Intrinsics.areEqual(this.staff, dayWiseTopicName.staff);
    }

    public int hashCode() {
        return (((((((this.hour * 31) + this.type.hashCode()) * 31) + this.topic_name.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.staff.hashCode();
    }

    public String toString() {
        return "DayWiseTopicName(hour=" + this.hour + ", type=" + this.type + ", topic_name=" + this.topic_name + ", subject=" + this.subject + ", staff=" + this.staff + ")";
    }

    public DayWiseTopicName(int i, String type, ArrayList<String> topic_name, String subject, String staff) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(topic_name, "topic_name");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(staff, "staff");
        this.hour = i;
        this.type = type;
        this.topic_name = topic_name;
        this.subject = subject;
        this.staff = staff;
    }

    public final int getHour() {
        return this.hour;
    }

    public final String getType() {
        return this.type;
    }

    public final ArrayList<String> getTopic_name() {
        return this.topic_name;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getStaff() {
        return this.staff;
    }
}