package in.etuwa.app.data.model.profileasiet.projectwork;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProjectWorkResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class ProjectWorkResponse {
    private final boolean login;
    private final ArrayList<ProjectWork> project;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProjectWorkResponse copy$default(ProjectWorkResponse projectWorkResponse, boolean z, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            z = projectWorkResponse.login;
        }
        if ((i & 2) != 0) {
            arrayList = projectWorkResponse.project;
        }
        return projectWorkResponse.copy(z, arrayList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ProjectWork> component2() {
        return this.project;
    }

    public final ProjectWorkResponse copy(boolean login, ArrayList<ProjectWork> project) {
        Intrinsics.checkNotNullParameter(project, "project");
        return new ProjectWorkResponse(login, project);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProjectWorkResponse)) {
            return false;
        }
        ProjectWorkResponse projectWorkResponse = (ProjectWorkResponse) other;
        return this.login == projectWorkResponse.login && Intrinsics.areEqual(this.project, projectWorkResponse.project);
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
        return (r0 * 31) + this.project.hashCode();
    }

    public String toString() {
        return "ProjectWorkResponse(login=" + this.login + ", project=" + this.project + ")";
    }

    public ProjectWorkResponse(boolean z, ArrayList<ProjectWork> project) {
        Intrinsics.checkNotNullParameter(project, "project");
        this.login = z;
        this.project = project;
    }

    public final boolean getLogin() {
        return this.login;
    }

    public final ArrayList<ProjectWork> getProject() {
        return this.project;
    }
}