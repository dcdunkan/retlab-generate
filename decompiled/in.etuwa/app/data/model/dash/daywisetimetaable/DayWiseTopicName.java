package in.etuwa.app.data.model.dash.daywisetimetaable;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DayWiseTopicName.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class DayWiseTopicName {
    private final int hour;
    private final String staff;
    private final String subject;
    private final ArrayList<String> topic_name;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getHour() {
        return this.hour;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ArrayList<String> component3() {
        return this.topic_name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
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