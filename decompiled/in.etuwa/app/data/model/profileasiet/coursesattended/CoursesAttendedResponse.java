package in.etuwa.app.data.model.profileasiet.coursesattended;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoursesAttendedResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class CoursesAttendedResponse {
    private final ArrayList<CoursesAttended> courses;
    private final boolean login;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CoursesAttendedResponse copy$default(CoursesAttendedResponse coursesAttendedResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = coursesAttendedResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = coursesAttendedResponse.courses;
        }
        return coursesAttendedResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CoursesAttended> component2() {
        return this.courses;
    }

    public final CoursesAttendedResponse copy(boolean login, ArrayList<CoursesAttended> courses) {
        Intrinsics.checkNotNullParameter(courses, "courses");
        return new CoursesAttendedResponse(login, courses);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoursesAttendedResponse)) {
            return false;
        }
        CoursesAttendedResponse coursesAttendedResponse = (CoursesAttendedResponse) other;
        return this.login == coursesAttendedResponse.login && Intrinsics.areEqual(this.courses, coursesAttendedResponse.courses);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.login;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.courses.hashCode();
    }

    public String toString() {
        return "CoursesAttendedResponse(login=" + this.login + ", courses=" + this.courses + ")";
    }

    public CoursesAttendedResponse(boolean z, ArrayList<CoursesAttended> courses) {
        Intrinsics.checkNotNullParameter(courses, "courses");
        this.login = z;
        this.courses = courses;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<CoursesAttended> getCourses() {
        return this.courses;
    }
}