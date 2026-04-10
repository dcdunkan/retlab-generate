package in.etuwa.app.ui.evaluation;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import at.blogc.android.views.ExpandableTextView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.config.CookieSpecs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.exam.ExamFiles;
import in.etuwa.app.data.model.homework.HomeWork;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.bouncycastle.i18n.ErrorBundle;

/* JADX INFO: compiled from: EvaluationHomeworkAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EvaluationHomeworkAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private HomeWorkListener listener;
    private final ArrayList<HomeWork> homeWork = new ArrayList<>();
    private final ArrayList<HomeWork> filteredHomeWork = new ArrayList<>();

    /* JADX INFO: compiled from: EvaluationHomeworkAdapter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J \u0010\u000e\u001a\u00020\u00072\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012H&¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/ui/evaluation/EvaluationHomeworkAdapter$HomeWorkListener;", "", "checkFileExistence", "", "fileName", "", "deleteHomeWork", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "", "onPickDoc", "openDownloadDialog", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/exam/ExamFiles;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_home_work, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …home_work, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…mpty_view, parent, false)");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.filteredHomeWork.size() > 0) {
            return this.filteredHomeWork.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.filteredHomeWork.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: EvaluationHomeworkAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lin/etuwa/app/ui/evaluation/EvaluationHomeworkAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/evaluation/EvaluationHomeworkAdapter;Landroid/view/View;)V", "deleteBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", ErrorBundle.DETAIL_ENTRY, "Lat/blogc/android/views/ExpandableTextView;", "detailsLayout", "Landroid/widget/LinearLayout;", "dwnBtn", "feedLayout", "feedback", "hwDetailsLayout", "issueDate", "lastDate", "lateDate", "lateLayout", "lateStatus", AttendanceDayDialogKt.ARG_SEM, "sub", "submittedView", "title", "toggle", "upBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView deleteBtn;
        private final ExpandableTextView details;
        private final LinearLayout detailsLayout;
        private final TextView dwnBtn;
        private final LinearLayout feedLayout;
        private final TextView feedback;
        private final LinearLayout hwDetailsLayout;
        private final TextView issueDate;
        private final TextView lastDate;
        private final TextView lateDate;
        private final LinearLayout lateLayout;
        private final TextView lateStatus;
        private final TextView semester;
        private final TextView sub;
        private final View submittedView;
        final /* synthetic */ EvaluationHomeworkAdapter this$0;
        private final TextView title;
        private final TextView toggle;
        private final TextView upBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(EvaluationHomeworkAdapter evaluationHomeworkAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = evaluationHomeworkAdapter;
            this.sub = (TextView) itemView.findViewById(R.id.home_work_subject);
            this.semester = (TextView) itemView.findViewById(R.id.home_work_sem);
            this.title = (TextView) itemView.findViewById(R.id.home_work_title);
            this.issueDate = (TextView) itemView.findViewById(R.id.home_work_issue_date);
            this.lastDate = (TextView) itemView.findViewById(R.id.home_work_last_date);
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
            this.lateLayout = (LinearLayout) itemView.findViewById(R.id.late_layout);
            this.submittedView = itemView.findViewById(R.id.submitted_view_home);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            String subject;
            String str;
            super.onBind(position);
            try {
                Object obj = this.this$0.filteredHomeWork.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "filteredHomeWork[position]");
                final HomeWork homeWork = (HomeWork) obj;
                this.itemView.getContext();
                TextView textView = this.sub;
                boolean z = true;
                String str2 = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) homeWork.getSubject(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null), 1);
                if (str2 == null || (subject = StringsKt.trim((CharSequence) str2).toString()) == null) {
                    subject = homeWork.getSubject();
                }
                textView.setText(subject);
                this.semester.setText(homeWork.getSemester());
                this.title.setText(homeWork.getTitle());
                this.issueDate.setText("Issued: " + this.this$0.orShort(homeWork.getIssuedDate(), HelpFormatter.DEFAULT_LONG_OPT_PREFIX));
                this.lastDate.setText("Due: " + this.this$0.orShort(homeWork.getLastDate(), HelpFormatter.DEFAULT_LONG_OPT_PREFIX));
                this.details.setText(homeWork.getDetails());
                this.feedback.setText(homeWork.getTeacherFeedback());
                this.lateDate.setText(homeWork.getLateSubmissionDate());
                this.lateStatus.setText(homeWork.getLateSubmissionStatus());
                this.detailsLayout.setVisibility(homeWork.getDetails().length() == 0 ? 8 : 0);
                if (Intrinsics.areEqual(homeWork.getStatus(), "SUBMITTED")) {
                    this.submittedView.setBackgroundColor(Color.parseColor("#4CAF50"));
                } else {
                    this.submittedView.setBackgroundColor(Color.parseColor("#F44336"));
                }
                this.details.setAnimationDuration(250L);
                this.details.setInterpolator(new AccelerateDecelerateInterpolator());
                this.toggle.setBackgroundResource(R.drawable.ic_expand);
                this.details.setExpandInterpolator(new AccelerateDecelerateInterpolator());
                this.details.setCollapseInterpolator(new AccelerateDecelerateInterpolator());
                this.toggle.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EvaluationHomeworkAdapter.ViewHolder.onBind$lambda$0(this.f$0, view);
                    }
                });
                String lowerCase = homeWork.getLateSubmissionStatus().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, "late submission not allowed")) {
                    this.lateLayout.setVisibility(8);
                }
                this.feedLayout.setVisibility(homeWork.getTeacherFeedback().length() == 0 ? 8 : 0);
                if (Intrinsics.areEqual(homeWork.getStatus(), "SUBMITTED") && Intrinsics.areEqual(homeWork.getType(), "Online")) {
                    this.deleteBtn.setVisibility(0);
                } else {
                    this.deleteBtn.setVisibility(8);
                }
                if (!Intrinsics.areEqual(homeWork.getType(), "Online")) {
                    this.upBtn.setVisibility(4);
                }
                TextView textView2 = this.deleteBtn;
                final EvaluationHomeworkAdapter evaluationHomeworkAdapter = this.this$0;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EvaluationHomeworkAdapter.ViewHolder.onBind$lambda$1(evaluationHomeworkAdapter, homeWork, view);
                    }
                });
                TextView textView3 = this.dwnBtn;
                final EvaluationHomeworkAdapter evaluationHomeworkAdapter2 = this.this$0;
                textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EvaluationHomeworkAdapter.ViewHolder.onBind$lambda$2(evaluationHomeworkAdapter2, homeWork, view);
                    }
                });
                String strReplace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(homeWork.getUploadedFile(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                TextView textView4 = this.upBtn;
                if (Intrinsics.areEqual(homeWork.getStatus(), "SUBMITTED")) {
                    HomeWorkListener homeWorkListener = this.this$0.listener;
                    if (homeWorkListener == null || !homeWorkListener.checkFileExistence(strReplace)) {
                        z = false;
                    }
                    str = z ? "Open File" : "View File";
                }
                textView4.setText(str);
                TextView textView5 = this.upBtn;
                final EvaluationHomeworkAdapter evaluationHomeworkAdapter3 = this.this$0;
                textView5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter$ViewHolder$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EvaluationHomeworkAdapter.ViewHolder.onBind$lambda$3(homeWork, evaluationHomeworkAdapter3, this, position, view);
                    }
                });
                this.hwDetailsLayout.setVisibility(8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.details.toggle();
            this$0.toggle.setBackgroundResource(this$0.details.isExpanded() ? R.drawable.ic_collapse : R.drawable.ic_expand);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(EvaluationHomeworkAdapter this$0, HomeWork work, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(work, "$work");
            HomeWorkListener homeWorkListener = this$0.listener;
            if (homeWorkListener != null) {
                homeWorkListener.deleteHomeWork(work.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(EvaluationHomeworkAdapter this$0, HomeWork work, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(work, "$work");
            HomeWorkListener homeWorkListener = this$0.listener;
            if (homeWorkListener != null) {
                homeWorkListener.openDownloadDialog(work.getFiles());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$3(HomeWork work, EvaluationHomeworkAdapter this$0, ViewHolder this$1, int i, View view) {
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
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<HomeWork> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.homeWork.clear();
        ArrayList<HomeWork> arrayList = list;
        this.homeWork.addAll(arrayList);
        this.filteredHomeWork.clear();
        this.filteredHomeWork.addAll(arrayList);
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void applyCombinedFilter(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "status"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.util.ArrayList<in.etuwa.app.data.model.homework.HomeWork> r0 = r10.filteredHomeWork
            r0.clear()
            java.util.ArrayList<in.etuwa.app.data.model.homework.HomeWork> r0 = r10.homeWork
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L49
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L29:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L44
            java.lang.Object r3 = r0.next()
            r4 = r3
            in.etuwa.app.data.model.homework.HomeWork r4 = (in.etuwa.app.data.model.homework.HomeWork) r4
            java.lang.String r4 = r4.getStatus()
            boolean r4 = kotlin.text.StringsKt.equals(r4, r11, r2)
            if (r4 == 0) goto L29
            r1.add(r3)
            goto L29
        L44:
            java.util.List r1 = (java.util.List) r1
            r0 = r1
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        L49:
            r11 = r12
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = kotlin.text.StringsKt.isBlank(r11)
            r11 = r11 ^ r2
            if (r11 == 0) goto Lb4
            java.util.Locale r11 = java.util.Locale.ROOT
            java.lang.String r11 = r12.toLowerCase(r11)
            java.lang.String r12 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L6b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto Laf
            java.lang.Object r3 = r0.next()
            r4 = r3
            in.etuwa.app.data.model.homework.HomeWork r4 = (in.etuwa.app.data.model.homework.HomeWork) r4
            java.lang.String r5 = r4.getSubject()
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r12)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = r11
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = 0
            r8 = 2
            r9 = 0
            boolean r5 = kotlin.text.StringsKt.contains$default(r5, r6, r7, r8, r9)
            if (r5 != 0) goto La8
            java.lang.String r4 = r4.getTitle()
            java.util.Locale r5 = java.util.Locale.ROOT
            java.lang.String r4 = r4.toLowerCase(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r12)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = kotlin.text.StringsKt.contains$default(r4, r6, r7, r8, r9)
            if (r4 == 0) goto La9
        La8:
            r7 = 1
        La9:
            if (r7 == 0) goto L6b
            r1.add(r3)
            goto L6b
        Laf:
            java.util.List r1 = (java.util.List) r1
            r0 = r1
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        Lb4:
            java.util.ArrayList<in.etuwa.app.data.model.homework.HomeWork> r11 = r10.filteredHomeWork
            java.util.Collection r0 = (java.util.Collection) r0
            r11.addAll(r0)
            r10.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.evaluation.EvaluationHomeworkAdapter.applyCombinedFilter(java.lang.String, java.lang.String):void");
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void setCallBack(EvaluationFragment context) {
        this.listener = context;
    }

    public static /* synthetic */ String orShort$default(EvaluationHomeworkAdapter evaluationHomeworkAdapter, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
        }
        return evaluationHomeworkAdapter.orShort(str, str2);
    }

    public final String orShort(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "default");
        String str3 = str;
        return ((str3 == null || StringsKt.isBlank(str3)) || Intrinsics.areEqual(str, "null")) ? str2 : str;
    }
}