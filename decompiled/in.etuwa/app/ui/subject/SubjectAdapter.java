package in.etuwa.app.ui.subject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import at.grabner.circleprogress.CircleProgressView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.subject.Subjects;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import in.etuwa.app.ui.subject.SubjectAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SubjectAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/ui/subject/SubjectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/subject/SubjectAdapter$SubjectCallBack;", "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subject/Subjects;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSubjectCallBack", "context", "Lin/etuwa/app/ui/subject/SubjectFragment;", "SubjectCallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubjectAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private SubjectCallBack listener;
    private final ArrayList<Subjects> subjects = new ArrayList<>();

    /* compiled from: SubjectAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/subject/SubjectAdapter$SubjectCallBack;", "", "onCoClicked", "", StoreFragmentKt.SUB_ID, "", "onCoverageClicked", "onSyllabusClicked", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SubjectCallBack {
        void onCoClicked(String subId);

        void onCoverageClicked(String subId);

        void onSyllabusClicked(String subId);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_subject, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …w_subject, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.subjects.size() > 0) {
            return this.subjects.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.subjects.isEmpty() ? 1 : 0;
    }

    /* compiled from: SubjectAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lin/etuwa/app/ui/subject/SubjectAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/subject/SubjectAdapter;Landroid/view/View;)V", "attendance", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "coBtn", "coverageBtn", "ge", "perBar", "Lat/grabner/circleprogress/CircleProgressView;", "subjectName", "syllabusBtn", "teacher", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView attendance;
        private final TextView coBtn;
        private final TextView coverageBtn;
        private final TextView ge;
        private final CircleProgressView perBar;
        private final TextView subjectName;
        private final TextView syllabusBtn;
        private final TextView teacher;
        final /* synthetic */ SubjectAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SubjectAdapter subjectAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = subjectAdapter;
            this.subjectName = (TextView) itemView.findViewById(R.id.sub_name);
            this.teacher = (TextView) itemView.findViewById(R.id.subject_teacher_name);
            this.attendance = (TextView) itemView.findViewById(R.id.attendance_text);
            this.perBar = (CircleProgressView) itemView.findViewById(R.id.subject_progress_bar);
            this.syllabusBtn = (TextView) itemView.findViewById(R.id.syllabus_btn);
            this.coBtn = (TextView) itemView.findViewById(R.id.co_btn);
            this.coverageBtn = (TextView) itemView.findViewById(R.id.coverage_btn);
            this.ge = (TextView) itemView.findViewById(R.id.ge_subject);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.subjects.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "subjects[position]");
                final Subjects subjects = (Subjects) obj;
                List split$default = StringsKt.split$default((CharSequence) subjects.getSubName(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null);
                if (split$default.size() == 2) {
                    this.subjectName.setText(StringsKt.trim((CharSequence) split$default.get(split$default.size() - 1)).toString());
                } else if (split$default.size() == 3) {
                    this.subjectName.setText(StringsKt.trim((CharSequence) split$default.get(split$default.size() - 2)).toString() + " - " + StringsKt.trim((CharSequence) split$default.get(split$default.size() - 1)).toString());
                }
                this.teacher.setText(subjects.getTeacher());
                this.attendance.setText(subjects.getAttendanceText());
                if (Intrinsics.areEqual(subjects.getAttendancePercentage(), "N/A")) {
                    this.perBar.setValueAnimated(0.0f);
                } else {
                    this.perBar.setValueAnimated(Float.parseFloat(subjects.getAttendancePercentage()));
                }
                if (subjects.isSubGe()) {
                    this.ge.setVisibility(0);
                }
                TextView textView = this.syllabusBtn;
                final SubjectAdapter subjectAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subject.SubjectAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SubjectAdapter.ViewHolder.onBind$lambda$0(SubjectAdapter.this, subjects, view);
                    }
                });
                TextView textView2 = this.coBtn;
                final SubjectAdapter subjectAdapter2 = this.this$0;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subject.SubjectAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SubjectAdapter.ViewHolder.onBind$lambda$1(SubjectAdapter.this, subjects, view);
                    }
                });
                TextView textView3 = this.coverageBtn;
                final SubjectAdapter subjectAdapter3 = this.this$0;
                textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subject.SubjectAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SubjectAdapter.ViewHolder.onBind$lambda$2(SubjectAdapter.this, subjects, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(SubjectAdapter this$0, Subjects subject, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(subject, "$subject");
            SubjectCallBack subjectCallBack = this$0.listener;
            if (subjectCallBack != null) {
                subjectCallBack.onSyllabusClicked(subject.getSubId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(SubjectAdapter this$0, Subjects subject, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(subject, "$subject");
            SubjectCallBack subjectCallBack = this$0.listener;
            if (subjectCallBack != null) {
                subjectCallBack.onCoClicked(subject.getSubId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(SubjectAdapter this$0, Subjects subject, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(subject, "$subject");
            SubjectCallBack subjectCallBack = this$0.listener;
            if (subjectCallBack != null) {
                subjectCallBack.onCoverageClicked(subject.getSubId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Subjects> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.subjects.clear();
        this.subjects.addAll(list);
        notifyDataSetChanged();
    }

    public final void setSubjectCallBack(SubjectFragment context) {
        this.listener = context;
    }
}