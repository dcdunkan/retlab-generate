package in.etuwa.app.data.model.quiz.result.filetype;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileTypeQuestions.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003JQ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001f"}, d2 = {"Lin/etuwa/app/data/model/quiz/result/filetype/FileTypeQuestions;", "", "questionNo", "", "isAttended", "", "markObtained", "questionContent", "file", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/quiz/result/filetype/QuizResultFile;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getFile", "()Ljava/util/ArrayList;", "()Z", "getMarkObtained", "()Ljava/lang/String;", "getQuestionContent", "getQuestionNo", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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