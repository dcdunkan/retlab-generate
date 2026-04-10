package in.etuwa.app.data.model.result.tutorial;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TutorialResult.kt */
/* loaded from: classes3.dex */
public final /* data */ class TutorialResult {
    private final String mark;
    private final String subject;
    private final String title;

    public static /* synthetic */ TutorialResult copy$default(TutorialResult tutorialResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tutorialResult.subject;
        }
        if ((i & 2) != 0) {
            str2 = tutorialResult.title;
        }
        if ((i & 4) != 0) {
            str3 = tutorialResult.mark;
        }
        return tutorialResult.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMark() {
        return this.mark;
    }

    public final TutorialResult copy(String subject, String title, String mark) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(mark, "mark");
        return new TutorialResult(subject, title, mark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TutorialResult)) {
            return false;
        }
        TutorialResult tutorialResult = (TutorialResult) other;
        return Intrinsics.areEqual(this.subject, tutorialResult.subject) && Intrinsics.areEqual(this.title, tutorialResult.title) && Intrinsics.areEqual(this.mark, tutorialResult.mark);
    }

    public int hashCode() {
        return (((this.subject.hashCode() * 31) + this.title.hashCode()) * 31) + this.mark.hashCode();
    }

    public String toString() {
        return "TutorialResult(subject=" + this.subject + ", title=" + this.title + ", mark=" + this.mark + ")";
    }

    public TutorialResult(String subject, String title, String mark) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(mark, "mark");
        this.subject = subject;
        this.title = title;
        this.mark = mark;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMark() {
        return this.mark;
    }
}