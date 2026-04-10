package in.etuwa.app.ui.profile.qualifiedexaminations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.profileasiet.qualifiedexamination.QualifiedExamination;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.profile.qualifiedexaminations.QualifiedExaminationAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QualifiedExaminationAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class QualifiedExaminationAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private ExaminationListener listener;
    private final ArrayList<QualifiedExamination> qualifiedExamination = new ArrayList<>();

    /* JADX INFO: compiled from: QualifiedExaminationAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J \u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/profile/qualifiedexaminations/QualifiedExaminationAdapter$ExaminationListener;", "", "checkFileExistence", "", "fileName", "", "deleteBtnClicked", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "editBtnClicked", "name", FirebaseAnalytics.Param.SCORE, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ExaminationListener {
        boolean checkFileExistence(String fileName);

        void deleteBtnClicked(String id);

        void downloadFile(String url, String position);

        void editBtnClicked(String id, String name, String score);
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_q_exam, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …ow_q_exam, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.qualifiedExamination.size() > 0) {
            return this.qualifiedExamination.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.qualifiedExamination.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: QualifiedExaminationAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/profile/qualifiedexaminations/QualifiedExaminationAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/profile/qualifiedexaminations/QualifiedExaminationAdapter;Landroid/view/View;)V", "academicYear", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "deleteBtn", "editBtn", "gradeTv", "title", "viewBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView academicYear;
        private final TextView deleteBtn;
        private final TextView editBtn;
        private final TextView gradeTv;
        final /* synthetic */ QualifiedExaminationAdapter this$0;
        private final TextView title;
        private final TextView viewBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(QualifiedExaminationAdapter qualifiedExaminationAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = qualifiedExaminationAdapter;
            this.title = (TextView) itemView.findViewById(R.id.title_tv);
            this.gradeTv = (TextView) itemView.findViewById(R.id.grade_tv);
            this.academicYear = (TextView) itemView.findViewById(R.id.academic_yr_tv);
            this.viewBtn = (TextView) itemView.findViewById(R.id.view_btn_hr);
            this.editBtn = (TextView) itemView.findViewById(R.id.edit_btn);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.delete_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.qualifiedExamination.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "qualifiedExamination[position]");
                final QualifiedExamination qualifiedExamination = (QualifiedExamination) obj;
                this.title.setText(qualifiedExamination.getName());
                this.gradeTv.setText(qualifiedExamination.getScore());
                this.academicYear.setText(qualifiedExamination.getYear());
                if (Intrinsics.areEqual(qualifiedExamination.getFile(), "")) {
                    this.viewBtn.setVisibility(4);
                } else {
                    this.viewBtn.setVisibility(0);
                }
                TextView textView = this.viewBtn;
                if (textView != null) {
                    final QualifiedExaminationAdapter qualifiedExaminationAdapter = this.this$0;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.QualifiedExaminationAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            QualifiedExaminationAdapter.ViewHolder.onBind$lambda$0(qualifiedExaminationAdapter, qualifiedExamination, view);
                        }
                    });
                }
                TextView textView2 = this.editBtn;
                if (textView2 != null) {
                    final QualifiedExaminationAdapter qualifiedExaminationAdapter2 = this.this$0;
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.QualifiedExaminationAdapter$ViewHolder$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            QualifiedExaminationAdapter.ViewHolder.onBind$lambda$1(qualifiedExaminationAdapter2, qualifiedExamination, view);
                        }
                    });
                }
                TextView textView3 = this.deleteBtn;
                if (textView3 != null) {
                    final QualifiedExaminationAdapter qualifiedExaminationAdapter3 = this.this$0;
                    textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.qualifiedexaminations.QualifiedExaminationAdapter$ViewHolder$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            QualifiedExaminationAdapter.ViewHolder.onBind$lambda$2(qualifiedExaminationAdapter3, qualifiedExamination, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(QualifiedExaminationAdapter this$0, QualifiedExamination qualifiedExamination, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(qualifiedExamination, "$qualifiedExamination");
            ExaminationListener examinationListener = this$0.listener;
            if (examinationListener != null) {
                examinationListener.downloadFile(qualifiedExamination.getFile(), qualifiedExamination.getFile());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(QualifiedExaminationAdapter this$0, QualifiedExamination qualifiedExamination, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(qualifiedExamination, "$qualifiedExamination");
            ExaminationListener examinationListener = this$0.listener;
            if (examinationListener != null) {
                examinationListener.editBtnClicked(qualifiedExamination.getId(), qualifiedExamination.getName(), qualifiedExamination.getScore());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(QualifiedExaminationAdapter this$0, QualifiedExamination qualifiedExamination, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(qualifiedExamination, "$qualifiedExamination");
            ExaminationListener examinationListener = this$0.listener;
            if (examinationListener != null) {
                examinationListener.deleteBtnClicked(qualifiedExamination.getId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<QualifiedExamination> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.qualifiedExamination.clear();
        this.qualifiedExamination.addAll(list);
        notifyDataSetChanged();
    }

    public final void setExaminationListener(QualifiedExaminationFragment context) {
        this.listener = context;
    }
}