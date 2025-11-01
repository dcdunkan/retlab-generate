package in.etuwa.app.ui.homework;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import at.blogc.android.views.ExpandableTextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.exam.ExamFiles;
import in.etuwa.app.data.model.homework.HomeWork;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.homework.HomeWorkAdapter;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: HomeWorkAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/ui/homework/HomeWorkAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "homeWork", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/homework/HomeWork;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/homework/HomeWorkAdapter$HomeWorkListener;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "context", "Lin/etuwa/app/ui/homework/HomeWorkFragment;", "HomeWorkListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HomeWorkAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<HomeWork> homeWork = new ArrayList<>();
    private HomeWorkListener listener;

    /* compiled from: HomeWorkAdapter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J \u0010\u000e\u001a\u00020\u00072\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012H&¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/ui/homework/HomeWorkAdapter$HomeWorkListener;", "", "checkFileExistence", "", "fileName", "", "deleteHomeWork", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "", "onPickDoc", "openDownloadDialog", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/exam/ExamFiles;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface HomeWorkListener {
        boolean checkFileExistence(String fileName);

        void deleteHomeWork(String id);

        void downloadFile(String url, int position);

        void onPickDoc(String id);

        void openDownloadDialog(ArrayList<ExamFiles> list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_home_work, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …home_work, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.homeWork.size() > 0) {
            return this.homeWork.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.homeWork.isEmpty() ? 1 : 0;
    }

    /* compiled from: HomeWorkAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lin/etuwa/app/ui/homework/HomeWorkAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/homework/HomeWorkAdapter;Landroid/view/View;)V", "deleteBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", ErrorBundle.DETAIL_ENTRY, "Lat/blogc/android/views/ExpandableTextView;", "detailsLayout", "Landroid/widget/LinearLayout;", "dwnBtn", "feedLayout", "feedback", "hwDetailsLayout", "hwExpandLayout", "issueDate", "lastDate", "lateDate", "lateLayout", "lateStatus", AttendanceDayDialogKt.ARG_SEM, NotificationCompat.CATEGORY_STATUS, "sub", "submittedView", "title", "toggle", "upBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView deleteBtn;
        private final ExpandableTextView details;
        private final LinearLayout detailsLayout;
        private final TextView dwnBtn;
        private final LinearLayout feedLayout;
        private final TextView feedback;
        private final LinearLayout hwDetailsLayout;
        private final LinearLayout hwExpandLayout;
        private final TextView issueDate;
        private final TextView lastDate;
        private final TextView lateDate;
        private final LinearLayout lateLayout;
        private final TextView lateStatus;
        private final TextView semester;
        private final TextView status;
        private final TextView sub;
        private final View submittedView;
        final /* synthetic */ HomeWorkAdapter this$0;
        private final TextView title;
        private final TextView toggle;
        private final TextView upBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(HomeWorkAdapter homeWorkAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = homeWorkAdapter;
            this.sub = (TextView) itemView.findViewById(R.id.home_work_subject);
            this.semester = (TextView) itemView.findViewById(R.id.home_work_sem);
            this.title = (TextView) itemView.findViewById(R.id.home_work_title);
            this.issueDate = (TextView) itemView.findViewById(R.id.home_work_issue_date);
            this.lastDate = (TextView) itemView.findViewById(R.id.home_work_last_date);
            this.status = (TextView) itemView.findViewById(R.id.home_work_status);
            this.dwnBtn = (TextView) itemView.findViewById(R.id.home_work_download);
            this.upBtn = (TextView) itemView.findViewById(R.id.home_work_upload_btn);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.delete_home_work);
            this.detailsLayout = (LinearLayout) itemView.findViewById(R.id.hw_detail_layout);
            this.details = (ExpandableTextView) itemView.findViewById(R.id.hw_details);
            this.toggle = (TextView) itemView.findViewById(R.id.hw_toggle);
            this.feedLayout = (LinearLayout) itemView.findViewById(R.id.hw_feedback_layout);
            this.feedback = (TextView) itemView.findViewById(R.id.hw_teacher_feedback);
            this.lateStatus = (TextView) itemView.findViewById(R.id.home_work_late_status);
            this.lateDate = (TextView) itemView.findViewById(R.id.home_work_late_date);
            this.hwDetailsLayout = (LinearLayout) itemView.findViewById(R.id.hw_details_layout);
            this.hwExpandLayout = (LinearLayout) itemView.findViewById(R.id.expand_hw_layout);
            this.lateLayout = (LinearLayout) itemView.findViewById(R.id.late_layout);
            this.submittedView = itemView.findViewById(R.id.submitted_view_home);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.homeWork.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "homeWork[position]");
                final HomeWork homeWork = (HomeWork) obj;
                boolean z = true;
                this.sub.setText(StringsKt.trim((CharSequence) StringsKt.split$default((CharSequence) homeWork.getSubject(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null).get(1)).toString());
                this.semester.setText(homeWork.getSemester());
                this.title.setText(homeWork.getTitle());
                this.issueDate.setText(homeWork.getIssuedDate());
                this.lastDate.setText(homeWork.getLastDate());
                this.status.setText(homeWork.getStatus());
                this.details.setText(homeWork.getDetails());
                this.feedback.setText(homeWork.getTeacherFeedback());
                this.lateDate.setText(homeWork.getLateSubmissionDate());
                this.lateStatus.setText(homeWork.getLateSubmissionStatus());
                this.detailsLayout.setVisibility(homeWork.getDetails().length() == 0 ? 8 : 0);
                if (Intrinsics.areEqual(homeWork.getStatus(), "SUBMITTED")) {
                    this.submittedView.setBackgroundColor(Color.rgb(120, 217, 3));
                } else {
                    this.submittedView.setBackgroundColor(Color.rgb(225, 51, 0));
                }
                this.details.setAnimationDuration(1500L);
                this.details.setInterpolator(new OvershootInterpolator());
                this.toggle.setBackgroundResource(R.drawable.ic_expand);
                this.details.setExpandInterpolator(new OvershootInterpolator());
                this.details.setCollapseInterpolator(new OvershootInterpolator());
                this.toggle.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.homework.HomeWorkAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeWorkAdapter.ViewHolder.onBind$lambda$0(HomeWorkAdapter.ViewHolder.this, view);
                    }
                });
                String lowerCase = homeWork.getLateSubmissionStatus().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, "late submission not allowed")) {
                    this.lateLayout.setVisibility(8);
                }
                if (homeWork.getTeacherFeedback().length() != 0) {
                    z = false;
                }
                if (z) {
                    this.feedLayout.setVisibility(8);
                } else {
                    this.feedLayout.setVisibility(0);
                }
                if (Intrinsics.areEqual(homeWork.getStatus(), "SUBMITTED") && Intrinsics.areEqual(homeWork.getType(), "Online")) {
                    this.deleteBtn.setVisibility(0);
                } else {
                    this.deleteBtn.setVisibility(8);
                }
                if (!Intrinsics.areEqual(homeWork.getType(), "Online")) {
                    this.upBtn.setVisibility(4);
                }
                TextView textView = this.deleteBtn;
                final HomeWorkAdapter homeWorkAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.homework.HomeWorkAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeWorkAdapter.ViewHolder.onBind$lambda$1(HomeWorkAdapter.this, homeWork, view);
                    }
                });
                TextView textView2 = this.dwnBtn;
                final HomeWorkAdapter homeWorkAdapter2 = this.this$0;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.homework.HomeWorkAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeWorkAdapter.ViewHolder.onBind$lambda$2(HomeWorkAdapter.this, homeWork, view);
                    }
                });
                String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(homeWork.getUploadedFile(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                if (Intrinsics.areEqual(homeWork.getStatus(), "SUBMITTED")) {
                    HomeWorkListener homeWorkListener = this.this$0.listener;
                    Boolean valueOf = homeWorkListener != null ? Boolean.valueOf(homeWorkListener.checkFileExistence(replace)) : null;
                    Intrinsics.checkNotNull(valueOf);
                    if (valueOf.booleanValue()) {
                        this.upBtn.setText("Open Submitted File");
                        this.upBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_inactive);
                    } else {
                        this.upBtn.setText("View Submitted File");
                        this.upBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_dark);
                    }
                } else {
                    this.upBtn.setText("Submit");
                    this.upBtn.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
                }
                TextView textView3 = this.upBtn;
                final HomeWorkAdapter homeWorkAdapter3 = this.this$0;
                textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.homework.HomeWorkAdapter$ViewHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeWorkAdapter.ViewHolder.onBind$lambda$3(HomeWork.this, homeWorkAdapter3, this, position, view);
                    }
                });
                this.hwExpandLayout.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.homework.HomeWorkAdapter$ViewHolder$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeWorkAdapter.ViewHolder.onBind$lambda$4(HomeWorkAdapter.ViewHolder.this, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.details.toggle();
            if (this$0.details.isExpanded()) {
                this$0.details.collapse();
                this$0.toggle.setBackgroundResource(R.drawable.ic_expand);
            } else {
                this$0.details.expand();
                this$0.toggle.setBackgroundResource(R.drawable.ic_collapse);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(HomeWorkAdapter this$0, HomeWork work, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(work, "$work");
            HomeWorkListener homeWorkListener = this$0.listener;
            if (homeWorkListener != null) {
                homeWorkListener.deleteHomeWork(work.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(HomeWorkAdapter this$0, HomeWork work, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(work, "$work");
            HomeWorkListener homeWorkListener = this$0.listener;
            if (homeWorkListener != null) {
                homeWorkListener.openDownloadDialog(work.getFiles());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$3(HomeWork work, HomeWorkAdapter this$0, ViewHolder this$1, int i, View view) {
            Intrinsics.checkNotNullParameter(work, "$work");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!Intrinsics.areEqual(work.getStatus(), "NOT SUBMITTED")) {
                HomeWorkListener homeWorkListener = this$0.listener;
                if (homeWorkListener != null) {
                    homeWorkListener.downloadFile(work.getUploadedFile(), i);
                    return;
                }
                return;
            }
            if (work.getCanSubmit()) {
                HomeWorkListener homeWorkListener2 = this$0.listener;
                if (homeWorkListener2 != null) {
                    homeWorkListener2.onPickDoc(work.getId());
                    return;
                }
                return;
            }
            TextView upBtn = this$1.upBtn;
            Intrinsics.checkNotNullExpressionValue(upBtn, "upBtn");
            ToastExtKt.showInfoToast(upBtn, "Student can submit exam from start time to the end time only.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$4(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.hwDetailsLayout.getVisibility() == 0) {
                this$0.hwDetailsLayout.setVisibility(0);
            } else {
                this$0.hwDetailsLayout.setVisibility(0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<HomeWork> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.homeWork.clear();
        this.homeWork.addAll(list);
        notifyDataSetChanged();
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void setCallBack(HomeWorkFragment context) {
        this.listener = context;
    }
}