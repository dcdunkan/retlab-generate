package in.etuwa.app.data.model.quiz.result.filetype;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileTypeQuestions.kt */
/* loaded from: classes3.dex */
public final /* data */ class FileTypeQuestions {
    private final ArrayList<QuizResultFile> file;

    @SerializedName("is_attended")
    private final boolean isAttended;

    @SerializedName("mark_obtained")
    private final String markObtained;

    @SerializedName("question_content")
    private final String questionContent;

    @SerializedName("question_no")
    private final String questionNo;

    public static /* synthetic */ FileTypeQuestions copy$default(FileTypeQuestions fileTypeQuestions, String str, boolean z, String str2, String str3, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileTypeQuestions.questionNo;
        }
        if ((i & 2) != 0) {
            z = fileTypeQuestions.isAttended;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str2 = fileTypeQuestions.markObtained;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = fileTypeQuestions.questionContent;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            arrayList = fileTypeQuestions.file;
        }
        return fileTypeQuestions.copy(str, z2, str4, str5, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQuestionNo() {
        return this.questionNo;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsAttended() {
        return this.isAttended;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMarkObtained() {
        return this.markObtained;
    }

    /* renamed from: component4, reason: from getter */
    public final String getQuestionContent() {
        return this.questionContent;
    }

    public final ArrayList<QuizResultFile> component5() {
        return this.file;
    }

    public final FileTypeQuestions copy(String questionNo, boolean isAttended, String markObtained, String questionContent, ArrayList<QuizResultFile> file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new FileTypeQuestions(questionNo, isAttended, markObtained, questionContent, file);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileTypeQuestions)) {
            return false;
        }
        FileTypeQuestions fileTypeQuestions = (FileTypeQuestions) other;
        return Intrinsics.areEqual(this.questionNo, fileTypeQuestions.questionNo) && this.isAttended == fileTypeQuestions.isAttended && Intrinsics.areEqual(this.markObtained, fileTypeQuestions.markObtained) && Intrinsics.areEqual(this.questionContent, fileTypeQuestions.questionContent) && Intrinsics.areEqual(this.file, fileTypeQuestions.file);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.questionNo;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.isAttended;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        String str2 = this.markObtained;
        int hashCode2 = (i2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.questionContent;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "FileTypeQuestions(questionNo=" + this.questionNo + ", isAttended=" + this.isAttended + ", markObtained=" + this.markObtained + ", questionContent=" + this.questionContent + ", file=" + this.file + ")";
    }

    public FileTypeQuestions(String str, boolean z, String str2, String str3, ArrayList<QuizResultFile> file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.questionNo = str;
        this.isAttended = z;
        this.markObtained = str2;
        this.questionContent = str3;
        this.file = file;
    }

    public final String getQuestionNo() {
        return this.questionNo;
    }

    public final boolean isAttended() {
        return this.isAttended;
    }

    public final String getMarkObtained() {
        return this.markObtained;
    }

    public final String getQuestionContent() {
        return this.questionContent;
    }

    public final ArrayList<QuizResultFile> getFile() {
        return this.file;
    }
}