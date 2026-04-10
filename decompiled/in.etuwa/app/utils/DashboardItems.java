package in.etuwa.app.utils;

import in.etuwa.app.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: DashboardItems.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class DashboardItems {
    public static final DashboardItems INSTANCE = new DashboardItems();
    private static final ArrayList<String> title = CollectionsKt.arrayListOf("Evaluations", "Results", "Study Materials", "Courses", "Faculties", "Question Bank", "Analysis", "Laboratory", "Exam Schedule", "Exam Or Quiz", "Video Lectures", "Academic", "Transport", "Hostel", "Dues", "Online Class", "Circulars", "Program Outcomes", "Survey", "Library", "Remarks", "Semester Registration", "Counselling", "Certificate Request", "Leave", "Grievance", "Activity Points", "Subject Registration", "Stationary", "Digital Library", "Placements", "Internship");
    private static final ArrayList<String> titleTkm = CollectionsKt.arrayListOf("Evaluations", "Results", "Study Materials", "Courses", "Faculties", "Question Bank", "Analysis", "Laboratory", "Exam Schedule", "Exam Or Quiz", "Video Lectures", "University Exam", "Academic", "Transport", "Hostel", "Dues", "Online Class", "Circulars", "Program Outcomes", "Survey", "Library", "Remarks", "Semester Registration", "Counselling", "Certificate Request", "Leave", "Grievance", "Activity Points", "Subject Registration", "Stationary", "Digital Library", "Placements", "Internship");
    private static final ArrayList<String> titleArts = CollectionsKt.arrayListOf("Evaluations", "Results", "Study Materials", "Courses", "Faculties", "Question Bank", "Analysis", "Laboratory", "Exam Schedule", "Exam Or Quiz", "Video Lectures", "Academic", "Online Class", "Circulars", "Program Outcomes", "Survey", "Library", "Remarks", "Semester Registration", "Counselling", "Leave", "Grievance", "Activity Points", "Subject Registration", "Stationary", "Placements", "Internship");
    private static final ArrayList<String> titleParent = CollectionsKt.arrayListOf("Attendance", "Assignments", "Series Exam", "Results", "Study Materials", "Module Test", "Exam Schedule", "Subjects", "Leave", "Academic Analysis", "Activity", "Certificate Request", " Circular", "Dues", "Fee", "Homework", "Internship", "Laboratory", "Notice Board", "Notification", "Online Class", "Placements", "Program Outcomes", "Question Bank", "Quiz/Exam", "Remarks", "Survey", "Teachers", "Time Table", "Tutorials", "Vaccine Certificate", "Video Lectures", "Library", "Hostel", "Stationary");
    private static final ArrayList<Integer> icons = CollectionsKt.arrayListOf(Integer.valueOf(R.drawable.evaluation), Integer.valueOf(R.drawable.result), Integer.valueOf(R.drawable.study_material), Integer.valueOf(R.drawable.courses), Integer.valueOf(R.drawable.teacher), Integer.valueOf(R.drawable.question), Integer.valueOf(R.drawable.analysis), Integer.valueOf(R.drawable.laboratory), Integer.valueOf(R.drawable.exam_schedule), Integer.valueOf(R.drawable.quiz), Integer.valueOf(R.drawable.video_lecture), Integer.valueOf(R.drawable.academic_fees), Integer.valueOf(R.drawable.bus), Integer.valueOf(R.drawable.hostel), Integer.valueOf(R.drawable.receipt), Integer.valueOf(R.drawable.classroom), Integer.valueOf(R.drawable.circulars), Integer.valueOf(R.drawable.program_outcme), Integer.valueOf(R.drawable.survey), Integer.valueOf(R.drawable.survey), Integer.valueOf(R.drawable.remarks), Integer.valueOf(R.drawable.survey), Integer.valueOf(R.drawable.counselling), Integer.valueOf(R.drawable.certificaterequest), Integer.valueOf(R.drawable.leaves), Integer.valueOf(R.drawable.grievance), Integer.valueOf(R.drawable.activity), Integer.valueOf(R.drawable.subjects), Integer.valueOf(R.drawable.stationary), Integer.valueOf(R.drawable.survey), Integer.valueOf(R.drawable.placements), Integer.valueOf(R.drawable.internship));
    private static final ArrayList<Integer> iconsTkm = CollectionsKt.arrayListOf(Integer.valueOf(R.drawable.evaluation), Integer.valueOf(R.drawable.result), Integer.valueOf(R.drawable.study_material), Integer.valueOf(R.drawable.courses), Integer.valueOf(R.drawable.teacher), Integer.valueOf(R.drawable.question), Integer.valueOf(R.drawable.analysis), Integer.valueOf(R.drawable.laboratory), Integer.valueOf(R.drawable.exam_schedule), Integer.valueOf(R.drawable.quiz), Integer.valueOf(R.drawable.video_lecture), Integer.valueOf(R.drawable.university_exam), Integer.valueOf(R.drawable.academic_fees), Integer.valueOf(R.drawable.bus), Integer.valueOf(R.drawable.hostel), Integer.valueOf(R.drawable.receipt), Integer.valueOf(R.drawable.classroom), Integer.valueOf(R.drawable.circulars), Integer.valueOf(R.drawable.program_outcme), Integer.valueOf(R.drawable.survey), Integer.valueOf(R.drawable.remarks), Integer.valueOf(R.drawable.remarks), Integer.valueOf(R.drawable.remarks), Integer.valueOf(R.drawable.counselling), Integer.valueOf(R.drawable.certificaterequest), Integer.valueOf(R.drawable.leaves), Integer.valueOf(R.drawable.grievance), Integer.valueOf(R.drawable.activity), Integer.valueOf(R.drawable.subjects), Integer.valueOf(R.drawable.stationary), Integer.valueOf(R.drawable.remarks), Integer.valueOf(R.drawable.placements), Integer.valueOf(R.drawable.internship));
    private static final ArrayList<Integer> iconsParents = CollectionsKt.arrayListOf(Integer.valueOf(R.drawable.attendance), Integer.valueOf(R.drawable.assignments), Integer.valueOf(R.drawable.series), Integer.valueOf(R.drawable.results), Integer.valueOf(R.drawable.module), Integer.valueOf(R.drawable.materials), Integer.valueOf(R.drawable.examschedule), Integer.valueOf(R.drawable.subjects), Integer.valueOf(R.drawable.leaves), Integer.valueOf(R.drawable.analysis), Integer.valueOf(R.drawable.activity), Integer.valueOf(R.drawable.certificaterequest), Integer.valueOf(R.drawable.circulars), Integer.valueOf(R.drawable.due), Integer.valueOf(R.drawable.fee), Integer.valueOf(R.drawable.homeworks), Integer.valueOf(R.drawable.internship), Integer.valueOf(R.drawable.laboratory), Integer.valueOf(R.drawable.noticeboard), Integer.valueOf(R.drawable.notification), Integer.valueOf(R.drawable.classroom), Integer.valueOf(R.drawable.placements), Integer.valueOf(R.drawable.program_outcme), Integer.valueOf(R.drawable.questionbank), Integer.valueOf(R.drawable.quiz), Integer.valueOf(R.drawable.remarks), Integer.valueOf(R.drawable.survey), Integer.valueOf(R.drawable.teachers), Integer.valueOf(R.drawable.timetable), Integer.valueOf(R.drawable.tutorials), Integer.valueOf(R.drawable.covid_certificate), Integer.valueOf(R.drawable.video_lectures_nw), Integer.valueOf(R.drawable.analysis), Integer.valueOf(R.drawable.hostel), Integer.valueOf(R.drawable.stationary));
    private static final ArrayList<Integer> iconsArts = CollectionsKt.arrayListOf(Integer.valueOf(R.drawable.evaluation), Integer.valueOf(R.drawable.result), Integer.valueOf(R.drawable.study_material), Integer.valueOf(R.drawable.courses), Integer.valueOf(R.drawable.teacher), Integer.valueOf(R.drawable.question), Integer.valueOf(R.drawable.analysis), Integer.valueOf(R.drawable.laboratory), Integer.valueOf(R.drawable.exam_schedule), Integer.valueOf(R.drawable.quiz), Integer.valueOf(R.drawable.video_lecture), Integer.valueOf(R.drawable.academic_fees), Integer.valueOf(R.drawable.classroom), Integer.valueOf(R.drawable.circulars), Integer.valueOf(R.drawable.program_outcme), Integer.valueOf(R.drawable.survey), Integer.valueOf(R.drawable.results), Integer.valueOf(R.drawable.remarks), Integer.valueOf(R.drawable.registration), Integer.valueOf(R.drawable.counselling), Integer.valueOf(R.drawable.leaves), Integer.valueOf(R.drawable.grievance), Integer.valueOf(R.drawable.activity), Integer.valueOf(R.drawable.subjects), Integer.valueOf(R.drawable.stationary), Integer.valueOf(R.drawable.placements), Integer.valueOf(R.drawable.internship));
    private static final ArrayList<String> titleAcademics = CollectionsKt.arrayListOf("Evaluations", "Results", "Study Materials", "Courses", "Faculties", "Question Bank", "Analysis", "Laboratory", "Exam Schedule", "Exam Or Quiz", "Video Lectures", "University Exam");
    private static final ArrayList<String> titleAcademicsArts = CollectionsKt.arrayListOf("Evaluations", "Results", "Study Materials", "Courses", "Faculties", "Question Bank", "Analysis", "Laboratory", "Exam Schedule", "Exam Or Quiz", "Video Lectures");
    private static final ArrayList<Integer> iconsAcademics = CollectionsKt.arrayListOf(Integer.valueOf(R.drawable.evaluation), Integer.valueOf(R.drawable.result), Integer.valueOf(R.drawable.study_material), Integer.valueOf(R.drawable.courses), Integer.valueOf(R.drawable.teacher), Integer.valueOf(R.drawable.question), Integer.valueOf(R.drawable.analysis), Integer.valueOf(R.drawable.laboratory), Integer.valueOf(R.drawable.exam_schedule), Integer.valueOf(R.drawable.quiz), Integer.valueOf(R.drawable.video_lecture), Integer.valueOf(R.drawable.university_exam));
    private static final ArrayList<Integer> iconsAcademicsArts = CollectionsKt.arrayListOf(Integer.valueOf(R.drawable.evaluation), Integer.valueOf(R.drawable.result), Integer.valueOf(R.drawable.study_material), Integer.valueOf(R.drawable.courses), Integer.valueOf(R.drawable.teacher), Integer.valueOf(R.drawable.question), Integer.valueOf(R.drawable.analysis), Integer.valueOf(R.drawable.laboratory), Integer.valueOf(R.drawable.exam_schedule), Integer.valueOf(R.drawable.quiz), Integer.valueOf(R.drawable.video_lecture));
    private static final ArrayList<String> titleFees = CollectionsKt.arrayListOf("Academic", "Transport", "Hostel", "Dues");
    private static final ArrayList<String> titleFeesArts = CollectionsKt.arrayListOf("Academic");
    private static final ArrayList<Integer> iconFees = CollectionsKt.arrayListOf(Integer.valueOf(R.drawable.academic_fees), Integer.valueOf(R.drawable.bus), Integer.valueOf(R.drawable.hostel), Integer.valueOf(R.drawable.receipt));
    private static final ArrayList<Integer> iconFeesArts = CollectionsKt.arrayListOf(Integer.valueOf(R.drawable.academic_fees));
    private static final ArrayList<String> titleInfo = CollectionsKt.arrayListOf("Online Class", "Circulars", "Program Outcomes", "Survey", "Library", "Remarks");
    private static final ArrayList<String> titleOffice = CollectionsKt.arrayListOf("Semester Registration", "Counselling", "Certificate Request", "Leave", "Grievance", "Activity Points", "Subject Registration", "Stationary", "Digital Library");
    private static final ArrayList<String> titleOfficeArts = CollectionsKt.arrayListOf("Semester Registration", "Counselling", "Leave", "Grievance", "Subject Registration");
    private static final ArrayList<String> titlePlacement = CollectionsKt.arrayListOf("Placements", "Internship");
    private static final ArrayList<String> titlePlacementArts = CollectionsKt.arrayListOf("Placements", "Internship");
    private static final ArrayList<Integer> drawableIconBg = CollectionsKt.arrayListOf(Integer.valueOf(R.drawable.shape_attendance_icon_bg), Integer.valueOf(R.drawable.shape_assignment_icon_bg), Integer.valueOf(R.drawable.shape_material_icon_bg), Integer.valueOf(R.drawable.shape_video_icon_bg), Integer.valueOf(R.drawable.shape_sub_icon_bg), Integer.valueOf(R.drawable.shape_online_icon_bg), Integer.valueOf(R.drawable.shape_attendance_icon_bg), Integer.valueOf(R.drawable.shape_assignment_icon_bg), Integer.valueOf(R.drawable.shape_material_icon_bg), Integer.valueOf(R.drawable.shape_video_icon_bg), Integer.valueOf(R.drawable.shape_sub_icon_bg), Integer.valueOf(R.drawable.shape_online_icon_bg), Integer.valueOf(R.drawable.shape_attendance_icon_bg), Integer.valueOf(R.drawable.shape_assignment_icon_bg), Integer.valueOf(R.drawable.shape_material_icon_bg), Integer.valueOf(R.drawable.shape_video_icon_bg), Integer.valueOf(R.drawable.shape_sub_icon_bg), Integer.valueOf(R.drawable.shape_online_icon_bg), Integer.valueOf(R.drawable.shape_attendance_icon_bg), Integer.valueOf(R.drawable.shape_assignment_icon_bg), Integer.valueOf(R.drawable.shape_material_icon_bg), Integer.valueOf(R.drawable.shape_video_icon_bg), Integer.valueOf(R.drawable.shape_sub_icon_bg), Integer.valueOf(R.drawable.shape_online_icon_bg), Integer.valueOf(R.drawable.shape_attendance_icon_bg), Integer.valueOf(R.drawable.shape_assignment_icon_bg), Integer.valueOf(R.drawable.shape_material_icon_bg), Integer.valueOf(R.drawable.shape_video_icon_bg), Integer.valueOf(R.drawable.shape_sub_icon_bg), Integer.valueOf(R.drawable.shape_online_icon_bg), Integer.valueOf(R.drawable.shape_attendance_icon_bg), Integer.valueOf(R.drawable.shape_assignment_icon_bg), Integer.valueOf(R.drawable.shape_material_icon_bg), Integer.valueOf(R.drawable.shape_video_icon_bg), Integer.valueOf(R.drawable.shape_sub_icon_bg), Integer.valueOf(R.drawable.shape_online_icon_bg), Integer.valueOf(R.drawable.shape_attendance_icon_bg), Integer.valueOf(R.drawable.shape_assignment_icon_bg), Integer.valueOf(R.drawable.shape_material_icon_bg), Integer.valueOf(R.drawable.shape_video_icon_bg), Integer.valueOf(R.drawable.shape_sub_icon_bg), Integer.valueOf(R.drawable.shape_online_icon_bg), Integer.valueOf(R.drawable.shape_attendance_icon_bg), Integer.valueOf(R.drawable.shape_assignment_icon_bg), Integer.valueOf(R.drawable.shape_material_icon_bg), Integer.valueOf(R.drawable.shape_video_icon_bg), Integer.valueOf(R.drawable.shape_sub_icon_bg), Integer.valueOf(R.drawable.shape_online_icon_bg));
    private static final ArrayList<Integer> colorBg = CollectionsKt.arrayListOf(Integer.valueOf(R.color.dashColorOneBg), Integer.valueOf(R.color.dashColorTwoBg), Integer.valueOf(R.color.dashColorThreeBg), Integer.valueOf(R.color.dashColorFourBg), Integer.valueOf(R.color.dashColorFiveBg), Integer.valueOf(R.color.dashColorSixBg), Integer.valueOf(R.color.dashColorOneBg), Integer.valueOf(R.color.dashColorTwoBg), Integer.valueOf(R.color.dashColorThreeBg), Integer.valueOf(R.color.dashColorFourBg), Integer.valueOf(R.color.dashColorFiveBg), Integer.valueOf(R.color.dashColorSixBg), Integer.valueOf(R.color.dashColorOneBg), Integer.valueOf(R.color.dashColorTwoBg), Integer.valueOf(R.color.dashColorThreeBg), Integer.valueOf(R.color.dashColorFourBg), Integer.valueOf(R.color.dashColorFiveBg), Integer.valueOf(R.color.dashColorSixBg), Integer.valueOf(R.color.dashColorOneBg), Integer.valueOf(R.color.dashColorTwoBg), Integer.valueOf(R.color.dashColorThreeBg), Integer.valueOf(R.color.dashColorFourBg), Integer.valueOf(R.color.dashColorFiveBg), Integer.valueOf(R.color.dashColorSixBg), Integer.valueOf(R.color.dashColorOneBg), Integer.valueOf(R.color.dashColorTwoBg), Integer.valueOf(R.color.dashColorThreeBg), Integer.valueOf(R.color.dashColorFourBg), Integer.valueOf(R.color.dashColorFiveBg), Integer.valueOf(R.color.dashColorSixBg), Integer.valueOf(R.color.dashColorOneBg), Integer.valueOf(R.color.dashColorTwoBg), Integer.valueOf(R.color.dashColorThreeBg), Integer.valueOf(R.color.dashColorFourBg), Integer.valueOf(R.color.dashColorFiveBg), Integer.valueOf(R.color.dashColorSixBg), Integer.valueOf(R.color.dashColorOneBg), Integer.valueOf(R.color.dashColorTwoBg), Integer.valueOf(R.color.dashColorThreeBg), Integer.valueOf(R.color.dashColorFourBg), Integer.valueOf(R.color.dashColorFiveBg), Integer.valueOf(R.color.dashColorSixBg), Integer.valueOf(R.color.dashColorOneBg), Integer.valueOf(R.color.dashColorTwoBg), Integer.valueOf(R.color.dashColorThreeBg), Integer.valueOf(R.color.dashColorFourBg), Integer.valueOf(R.color.dashColorFiveBg), Integer.valueOf(R.color.dashColorSixBg));
    private static final ArrayList<Integer> colorTint = CollectionsKt.arrayListOf(Integer.valueOf(R.color.dashColorOneTint), Integer.valueOf(R.color.dashColorTwoTint), Integer.valueOf(R.color.dashColorThreeTint), Integer.valueOf(R.color.dashColorFourTint), Integer.valueOf(R.color.dashColorFiveTint), Integer.valueOf(R.color.dashColorSixTint), Integer.valueOf(R.color.dashColorOneTint), Integer.valueOf(R.color.dashColorTwoTint), Integer.valueOf(R.color.dashColorThreeTint), Integer.valueOf(R.color.dashColorFourTint), Integer.valueOf(R.color.dashColorFiveTint), Integer.valueOf(R.color.dashColorSixTint), Integer.valueOf(R.color.dashColorOneTint), Integer.valueOf(R.color.dashColorTwoTint), Integer.valueOf(R.color.dashColorThreeTint), Integer.valueOf(R.color.dashColorFourTint), Integer.valueOf(R.color.dashColorFiveTint), Integer.valueOf(R.color.dashColorSixTint), Integer.valueOf(R.color.dashColorOneTint), Integer.valueOf(R.color.dashColorTwoTint), Integer.valueOf(R.color.dashColorThreeTint), Integer.valueOf(R.color.dashColorFourTint), Integer.valueOf(R.color.dashColorFiveTint), Integer.valueOf(R.color.dashColorSixTint), Integer.valueOf(R.color.dashColorOneTint), Integer.valueOf(R.color.dashColorTwoTint), Integer.valueOf(R.color.dashColorThreeTint), Integer.valueOf(R.color.dashColorFourTint), Integer.valueOf(R.color.dashColorFiveTint), Integer.valueOf(R.color.dashColorSixTint), Integer.valueOf(R.color.dashColorOneTint), Integer.valueOf(R.color.dashColorTwoTint), Integer.valueOf(R.color.dashColorThreeTint), Integer.valueOf(R.color.dashColorFourTint), Integer.valueOf(R.color.dashColorFiveTint), Integer.valueOf(R.color.dashColorSixTint), Integer.valueOf(R.color.dashColorOneTint), Integer.valueOf(R.color.dashColorTwoTint), Integer.valueOf(R.color.dashColorThreeTint), Integer.valueOf(R.color.dashColorFourTint), Integer.valueOf(R.color.dashColorFiveTint), Integer.valueOf(R.color.dashColorSixTint), Integer.valueOf(R.color.dashColorOneTint), Integer.valueOf(R.color.dashColorTwoTint), Integer.valueOf(R.color.dashColorThreeTint), Integer.valueOf(R.color.dashColorFourTint), Integer.valueOf(R.color.dashColorFiveTint), Integer.valueOf(R.color.dashColorSixTint));
    private static final ArrayList<Integer> colorCircleTint = CollectionsKt.arrayListOf(Integer.valueOf(R.color.dashColorIconOneBg), Integer.valueOf(R.color.dashColorIconTwoBg), Integer.valueOf(R.color.dashColorIconThreeBg), Integer.valueOf(R.color.dashColorIconFourBg), Integer.valueOf(R.color.dashColorIconFiveBg), Integer.valueOf(R.color.dashColorIconSixBg), Integer.valueOf(R.color.dashColorIconOneBg), Integer.valueOf(R.color.dashColorIconTwoBg), Integer.valueOf(R.color.dashColorIconThreeBg), Integer.valueOf(R.color.dashColorIconFourBg), Integer.valueOf(R.color.dashColorIconFiveBg), Integer.valueOf(R.color.dashColorIconSixBg), Integer.valueOf(R.color.dashColorIconOneBg), Integer.valueOf(R.color.dashColorIconTwoBg), Integer.valueOf(R.color.dashColorIconThreeBg), Integer.valueOf(R.color.dashColorIconFourBg), Integer.valueOf(R.color.dashColorIconFiveBg), Integer.valueOf(R.color.dashColorIconSixBg), Integer.valueOf(R.color.dashColorIconOneBg), Integer.valueOf(R.color.dashColorIconTwoBg), Integer.valueOf(R.color.dashColorIconThreeBg), Integer.valueOf(R.color.dashColorIconFourBg), Integer.valueOf(R.color.dashColorIconFiveBg), Integer.valueOf(R.color.dashColorIconSixBg), Integer.valueOf(R.color.dashColorIconOneBg), Integer.valueOf(R.color.dashColorIconTwoBg), Integer.valueOf(R.color.dashColorIconThreeBg), Integer.valueOf(R.color.dashColorIconFourBg), Integer.valueOf(R.color.dashColorIconFiveBg), Integer.valueOf(R.color.dashColorIconSixBg), Integer.valueOf(R.color.dashColorIconOneBg), Integer.valueOf(R.color.dashColorIconTwoBg), Integer.valueOf(R.color.dashColorIconThreeBg), Integer.valueOf(R.color.dashColorIconFourBg), Integer.valueOf(R.color.dashColorIconFiveBg), Integer.valueOf(R.color.dashColorIconSixBg), Integer.valueOf(R.color.dashColorIconOneBg), Integer.valueOf(R.color.dashColorIconTwoBg), Integer.valueOf(R.color.dashColorIconThreeBg), Integer.valueOf(R.color.dashColorIconFourBg), Integer.valueOf(R.color.dashColorIconFiveBg), Integer.valueOf(R.color.dashColorIconSixBg), Integer.valueOf(R.color.dashColorIconOneBg), Integer.valueOf(R.color.dashColorIconTwoBg), Integer.valueOf(R.color.dashColorIconThreeBg), Integer.valueOf(R.color.dashColorIconFourBg), Integer.valueOf(R.color.dashColorIconFiveBg), Integer.valueOf(R.color.dashColorIconSixBg));

    private DashboardItems() {
    }

    public final ArrayList<String> getTitle() {
        return title;
    }

    public final ArrayList<String> getTitleTkm() {
        return titleTkm;
    }

    public final ArrayList<String> getTitleArts() {
        return titleArts;
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

    public final ArrayList<Integer> getIconsArts() {
        return iconsArts;
    }

    public final ArrayList<String> getTitleAcademics() {
        return titleAcademics;
    }

    public final ArrayList<String> getTitleAcademicsArts() {
        return titleAcademicsArts;
    }

    public final ArrayList<Integer> getIconsAcademics() {
        return iconsAcademics;
    }

    public final ArrayList<Integer> getIconsAcademicsArts() {
        return iconsAcademicsArts;
    }

    public final ArrayList<String> getTitleFees() {
        return titleFees;
    }

    public final ArrayList<String> getTitleFeesArts() {
        return titleFeesArts;
    }

    public final ArrayList<Integer> getIconFees() {
        return iconFees;
    }

    public final ArrayList<Integer> getIconFeesArts() {
        return iconFeesArts;
    }

    public final ArrayList<String> getTitleInfo() {
        return titleInfo;
    }

    public final ArrayList<String> getTitleOffice() {
        return titleOffice;
    }

    public final ArrayList<String> getTitleOfficeArts() {
        return titleOfficeArts;
    }

    public final ArrayList<String> getTitlePlacement() {
        return titlePlacement;
    }

    public final ArrayList<String> getTitlePlacementArts() {
        return titlePlacementArts;
    }

    public final ArrayList<Integer> getDrawableIconBg() {
        return drawableIconBg;
    }

    public final ArrayList<Integer> getColorBg() {
        return colorBg;
    }

    public final ArrayList<Integer> getColorTint() {
        return colorTint;
    }

    public final ArrayList<Integer> getColorCircleTint() {
        return colorCircleTint;
    }
}