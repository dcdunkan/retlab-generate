package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import at.blogc.android.views.ExpandableTextView;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowHomeWorkBinding implements ViewBinding {
    public final TextView deleteHomeWork;
    public final LinearLayout expandHwLayout;
    public final TextView homeWorkDownload;
    public final TextView homeWorkIssueDate;
    public final TextView homeWorkLastDate;
    public final TextView homeWorkLateDate;
    public final TextView homeWorkLateStatus;
    public final TextView homeWorkSem;
    public final TextView homeWorkStatus;
    public final TextView homeWorkSubject;
    public final TextView homeWorkTitle;
    public final TextView homeWorkUploadBtn;
    public final LinearLayout hwDetailLayout;
    public final ExpandableTextView hwDetails;
    public final LinearLayout hwDetailsLayout;
    public final LinearLayout hwFeedbackLayout;
    public final TextView hwTeacherFeedback;
    public final TextView hwToggle;
    public final LinearLayout lateLayout;
    private final CardView rootView;
    public final View submittedViewHome;

    private RowHomeWorkBinding(CardView rootView, TextView deleteHomeWork, LinearLayout expandHwLayout, TextView homeWorkDownload, TextView homeWorkIssueDate, TextView homeWorkLastDate, TextView homeWorkLateDate, TextView homeWorkLateStatus, TextView homeWorkSem, TextView homeWorkStatus, TextView homeWorkSubject, TextView homeWorkTitle, TextView homeWorkUploadBtn, LinearLayout hwDetailLayout, ExpandableTextView hwDetails, LinearLayout hwDetailsLayout, LinearLayout hwFeedbackLayout, TextView hwTeacherFeedback, TextView hwToggle, LinearLayout lateLayout, View submittedViewHome) {
        this.rootView = rootView;
        this.deleteHomeWork = deleteHomeWork;
        this.expandHwLayout = expandHwLayout;
        this.homeWorkDownload = homeWorkDownload;
        this.homeWorkIssueDate = homeWorkIssueDate;
        this.homeWorkLastDate = homeWorkLastDate;
        this.homeWorkLateDate = homeWorkLateDate;
        this.homeWorkLateStatus = homeWorkLateStatus;
        this.homeWorkSem = homeWorkSem;
        this.homeWorkStatus = homeWorkStatus;
        this.homeWorkSubject = homeWorkSubject;
        this.homeWorkTitle = homeWorkTitle;
        this.homeWorkUploadBtn = homeWorkUploadBtn;
        this.hwDetailLayout = hwDetailLayout;
        this.hwDetails = hwDetails;
        this.hwDetailsLayout = hwDetailsLayout;
        this.hwFeedbackLayout = hwFeedbackLayout;
        this.hwTeacherFeedback = hwTeacherFeedback;
        this.hwToggle = hwToggle;
        this.lateLayout = lateLayout;
        this.submittedViewHome = submittedViewHome;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowHomeWorkBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowHomeWorkBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_home_work, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowHomeWorkBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.delete_home_work;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.expand_hw_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.home_work_download;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.home_work_issue_date;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.home_work_last_date;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.home_work_late_date;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                i = R.id.home_work_late_status;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView6 != null) {
                                    i = R.id.home_work_sem;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView7 != null) {
                                        i = R.id.home_work_status;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView8 != null) {
                                            i = R.id.home_work_subject;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView9 != null) {
                                                i = R.id.home_work_title;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView10 != null) {
                                                    i = R.id.home_work_upload_btn;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView11 != null) {
                                                        i = R.id.hw_detail_layout;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.hw_details;
                                                            ExpandableTextView expandableTextView = (ExpandableTextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (expandableTextView != null) {
                                                                i = R.id.hw_details_layout;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.hw_feedback_layout;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (linearLayout4 != null) {
                                                                        i = R.id.hw_teacher_feedback;
                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView12 != null) {
                                                                            i = R.id.hw_toggle;
                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView13 != null) {
                                                                                i = R.id.late_layout;
                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (linearLayout5 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.submitted_view_home))) != null) {
                                                                                    return new RowHomeWorkBinding((CardView) rootView, textView, linearLayout, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, linearLayout2, expandableTextView, linearLayout3, linearLayout4, textView12, textView13, linearLayout5, findChildViewById);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}