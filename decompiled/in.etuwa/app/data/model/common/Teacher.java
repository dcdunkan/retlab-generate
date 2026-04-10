package in.etuwa.app.data.model.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.itextpdf.svg.SvgConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Teacher.kt */
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