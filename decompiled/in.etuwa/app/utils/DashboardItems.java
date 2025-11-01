package in.etuwa.app.utils;

import in.etuwa.app.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: DashboardItems.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0004j\b\u0012\u0004\u0012\u00020\u000e`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0004j\b\u0012\u0004\u0012\u00020\u000e`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0004j\b\u0012\u0004\u0012\u00020\u000e`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\b¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/utils/DashboardItems;", "", "()V", "icons", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getIcons", "()Ljava/util/ArrayList;", "iconsParents", "getIconsParents", "iconsTkm", "getIconsTkm", "title", "", "getTitle", "titleParent", "getTitleParent", "titleTkm", "getTitleTkm", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DashboardItems {
    public static final DashboardItems INSTANCE = new DashboardItems();
    private static final ArrayList<String> title = CollectionsKt.arrayListOf("Attendance", "Assignments", "Series Exam", "Results", "Study Materials", "Module Test", "Exam Schedule", "Subjects", "Leave", "Academic Analysis", "Activity", "Certificate Request", " Circular", "Counselling", "Dues", "Fee", "Grievance", "Homework", "Internship", "Laboratory", "Notice Board", "Notification", "Online Class", "Placements", "Program Outcomes", "Question Bank", "Quiz/Exam", "Remarks", "Semester Registration", "Subject Registration", "Survey", "Teachers", "Time Table", "Tutorials", "Vaccine Certificate", "Video Lectures", "Library", "Hostel", "Stationary");
    private static final ArrayList<String> titleTkm = CollectionsKt.arrayListOf("Attendance", "Assignments", "Series Exam", "Results", "University Exam", "Study Materials", "Module Test", "Exam Schedule", "Subjects", "Leave", "Academic Analysis", "Activity", "Certificate Request", " Circular", "Counselling", "Dues", "Fee", "Grievance", "Homework", "Internship", "Laboratory", "Notice Board", "Notification", "Online Class", "Placements", "Program Outcomes", "Question Bank", "Quiz/Exam", "Remarks", "Semester Registration", "Survey", "Teachers", "Time Table", "Tutorials", "Vaccine Certificate", "Video Lectures", "Hostel");
    private static final ArrayList<String> titleParent = CollectionsKt.arrayListOf("Attendance", "Assignments", "Series Exam", "Results", "Study Materials", "Module Test", "Exam Schedule", "Subjects", "Leave", "Academic Analysis", "Activity", "Certificate Request", " Circular", "Dues", "Fee", "Homework", "Internship", "Laboratory", "Notice Board", "Notification", "Online Class", "Placements", "Program Outcomes", "Question Bank", "Quiz/Exam", "Remarks", "Survey", "Teachers", "Time Table", "Tutorials", "Vaccine Certificate", "Video Lectures", "Library", "Hostel", "Stationary");
    private static final ArrayList<Integer> icons = CollectionsKt.arrayListOf(Integer.valueOf(R.drawable.attendance), Integer.valueOf(R.drawable.assignments), Integer.valueOf(R.drawable.series), Integer.valueOf(R.drawable.results), Integer.valueOf(R.drawable.module), Integer.valueOf(R.drawable.materials), Integer.valueOf(R.drawable.examschedule), Integer.valueOf(R.drawable.subjects), Integer.valueOf(R.drawable.leaves), Integer.valueOf(R.drawable.analysis), Integer.valueOf(R.drawable.activity), Integer.valueOf(R.drawable.certificaterequest), Integer.valueOf(R.drawable.circulars), Integer.valueOf(R.drawable.counselling), Integer.valueOf(R.drawable.due), Integer.valueOf(R.drawable.fee), Integer.valueOf(R.drawable.grievance), Integer.valueOf(R.drawable.homeworks), Integer.valueOf(R.drawable.internship), Integer.valueOf(R.drawable.laboratory), Integer.valueOf(R.drawable.noticeboard), Integer.valueOf(R.drawable.notification), Integer.valueOf(R.drawable.classroom), Integer.valueOf(R.drawable.placements), Integer.valueOf(R.drawable.program_outcme), Integer.valueOf(R.drawable.questionbank), Integer.valueOf(R.drawable.quiz), Integer.valueOf(R.drawable.remarks), Integer.valueOf(R.drawable.semreg), Integer.valueOf(R.drawable.semreg), Integer.valueOf(R.drawable.survey), Integer.valueOf(R.drawable.teachers), Integer.valueOf(R.drawable.timetable), Integer.valueOf(R.drawable.tutorials), Integer.valueOf(R.drawable.covid_certificate), Integer.valueOf(R.drawable.video_lectures_nw), Integer.valueOf(R.drawable.analysis), Integer.valueOf(R.drawable.hostel), Integer.valueOf(R.drawable.stationary));
    private static final ArrayList<Integer> iconsTkm = CollectionsKt.arrayListOf(Integer.valueOf(R.drawable.attendance), Integer.valueOf(R.drawable.assignments), Integer.valueOf(R.drawable.series), Integer.valueOf(R.drawable.results), Integer.valueOf(R.drawable.results), Integer.valueOf(R.drawable.module), Integer.valueOf(R.drawable.materials), Integer.valueOf(R.drawable.examschedule), Integer.valueOf(R.drawable.subjects), Integer.valueOf(R.drawable.leaves), Integer.valueOf(R.drawable.analysis), Integer.valueOf(R.drawable.activity), Integer.valueOf(R.drawable.certificaterequest), Integer.valueOf(R.drawable.circulars), Integer.valueOf(R.drawable.counselling), Integer.valueOf(R.drawable.due), Integer.valueOf(R.drawable.fee), Integer.valueOf(R.drawable.grievance), Integer.valueOf(R.drawable.homeworks), Integer.valueOf(R.drawable.internship), Integer.valueOf(R.drawable.laboratory), Integer.valueOf(R.drawable.noticeboard), Integer.valueOf(R.drawable.notification), Integer.valueOf(R.drawable.classroom), Integer.valueOf(R.drawable.placements), Integer.valueOf(R.drawable.program_outcme), Integer.valueOf(R.drawable.questionbank), Integer.valueOf(R.drawable.quiz), Integer.valueOf(R.drawable.remarks), Integer.valueOf(R.drawable.semreg), Integer.valueOf(R.drawable.survey), Integer.valueOf(R.drawable.teachers), Integer.valueOf(R.drawable.timetable), Integer.valueOf(R.drawable.tutorials), Integer.valueOf(R.drawable.covid_certificate), Integer.valueOf(R.drawable.video_lectures_nw), Integer.valueOf(R.drawable.hostel));
    private static final ArrayList<Integer> iconsParents = CollectionsKt.arrayListOf(Integer.valueOf(R.drawable.attendance), Integer.valueOf(R.drawable.assignments), Integer.valueOf(R.drawable.series), Integer.valueOf(R.drawable.results), Integer.valueOf(R.drawable.module), Integer.valueOf(R.drawable.materials), Integer.valueOf(R.drawable.examschedule), Integer.valueOf(R.drawable.subjects), Integer.valueOf(R.drawable.leaves), Integer.valueOf(R.drawable.analysis), Integer.valueOf(R.drawable.activity), Integer.valueOf(R.drawable.certificaterequest), Integer.valueOf(R.drawable.circulars), Integer.valueOf(R.drawable.due), Integer.valueOf(R.drawable.fee), Integer.valueOf(R.drawable.homeworks), Integer.valueOf(R.drawable.internship), Integer.valueOf(R.drawable.laboratory), Integer.valueOf(R.drawable.noticeboard), Integer.valueOf(R.drawable.notification), Integer.valueOf(R.drawable.classroom), Integer.valueOf(R.drawable.placements), Integer.valueOf(R.drawable.program_outcme), Integer.valueOf(R.drawable.questionbank), Integer.valueOf(R.drawable.quiz), Integer.valueOf(R.drawable.remarks), Integer.valueOf(R.drawable.survey), Integer.valueOf(R.drawable.teachers), Integer.valueOf(R.drawable.timetable), Integer.valueOf(R.drawable.tutorials), Integer.valueOf(R.drawable.covid_certificate), Integer.valueOf(R.drawable.video_lectures_nw), Integer.valueOf(R.drawable.analysis), Integer.valueOf(R.drawable.hostel), Integer.valueOf(R.drawable.stationary));

    private DashboardItems() {
    }

    public final ArrayList<String> getTitle() {
        return title;
    }

    public final ArrayList<String> getTitleTkm() {
        return titleTkm;
    }

    public final ArrayList<String> getTitleParent() {
        return titleParent;
    }

    public final ArrayList<Integer> getIcons() {
        return icons;
    }

    public final ArrayList<Integer> getIconsTkm() {
        return iconsTkm;
    }

    public final ArrayList<Integer> getIconsParents() {
        return iconsParents;
    }
}