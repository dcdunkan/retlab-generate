package in.etuwa.app.data.model.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.svg.SvgConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Teacher.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, d2 = {"Lin/etuwa/app/data/model/common/Teacher;", "", "teacher", "", "subject", "phone", "mail", SvgConstants.Tags.IMAGE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImage", "()Ljava/lang/String;", "setImage", "(Ljava/lang/String;)V", "getMail", "setMail", "getPhone", "setPhone", "getSubject", "setSubject", "getTeacher", "setTeacher", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Teacher {

    @SerializedName("image_url")
    @Expose
    private String image;

    @SerializedName("t_email")
    @Expose
    private String mail;

    @SerializedName("t_phone")
    @Expose
    private String phone;

    @SerializedName("t_subject")
    @Expose
    private String subject;

    @SerializedName("t_name")
    @Expose
    private String teacher;

    public static /* synthetic */ Teacher copy$default(Teacher teacher, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = teacher.teacher;
        }
        if ((i & 2) != 0) {
            str2 = teacher.subject;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = teacher.phone;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = teacher.mail;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = teacher.image;
        }
        return teacher.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTeacher() {
        return this.teacher;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMail() {
        return this.mail;
    }

    /* renamed from: component5, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    public final Teacher copy(String teacher, String subject, String phone, String mail, String image) {
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(mail, "mail");
        Intrinsics.checkNotNullParameter(image, "image");
        return new Teacher(teacher, subject, phone, mail, image);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Teacher)) {
            return false;
        }
        Teacher teacher = (Teacher) other;
        return Intrinsics.areEqual(this.teacher, teacher.teacher) && Intrinsics.areEqual(this.subject, teacher.subject) && Intrinsics.areEqual(this.phone, teacher.phone) && Intrinsics.areEqual(this.mail, teacher.mail) && Intrinsics.areEqual(this.image, teacher.image);
    }

    public int hashCode() {
        return (((((((this.teacher.hashCode() * 31) + this.subject.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.mail.hashCode()) * 31) + this.image.hashCode();
    }

    public String toString() {
        return "Teacher(teacher=" + this.teacher + ", subject=" + this.subject + ", phone=" + this.phone + ", mail=" + this.mail + ", image=" + this.image + ")";
    }

    public Teacher(String teacher, String subject, String phone, String mail, String image) {
        Intrinsics.checkNotNullParameter(teacher, "teacher");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(mail, "mail");
        Intrinsics.checkNotNullParameter(image, "image");
        this.teacher = teacher;
        this.subject = subject;
        this.phone = phone;
        this.mail = mail;
        this.image = image;
    }

    public final String getTeacher() {
        return this.teacher;
    }

    public final void setTeacher(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.teacher = str;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final void setSubject(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subject = str;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final void setPhone(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.phone = str;
    }

    public final String getMail() {
        return this.mail;
    }

    public final void setMail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mail = str;
    }

    public final String getImage() {
        return this.image;
    }

    public final void setImage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.image = str;
    }
}