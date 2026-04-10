package in.etuwa.app.ui.subjectregistration.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.subjectregistration.SemSubjects;
import in.etuwa.app.data.model.subjectregistration.SemesterList;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewSemSubHistoryAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ViewSemSubHistoryAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private StatusListCallBack listener;
    private final ArrayList<SemesterList> subjectList = new ArrayList<>();

    /* JADX INFO: compiled from: ViewSemSubHistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/view/ViewSemSubHistoryAdapter$StatusListCallBack;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface StatusListCallBack {
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view_sem_sub_history, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …b_history, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.subjectList.size() > 0) {
            return this.subjectList.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.subjectList.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: ViewSemSubHistoryAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/view/ViewSemSubHistoryAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/subjectregistration/view/ViewSemSubHistoryAdapter;Landroid/view/View;)V", "mdcSubjectsContainer", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "minorSubjectsContainer", "semName", "Landroid/widget/TextView;", "sgpa", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final LinearLayout mdcSubjectsContainer;
        private final LinearLayout minorSubjectsContainer;
        private final TextView semName;
        private final TextView sgpa;
        final /* synthetic */ ViewSemSubHistoryAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ViewSemSubHistoryAdapter viewSemSubHistoryAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = viewSemSubHistoryAdapter;
            this.semName = (TextView) itemView.findViewById(R.id.semester_tv);
            this.sgpa = (TextView) itemView.findViewById(R.id.sgpa_tv);
            this.minorSubjectsContainer = (LinearLayout) itemView.findViewById(R.id.minor_subjects_container);
            this.mdcSubjectsContainer = (LinearLayout) itemView.findViewById(R.id.mdc_subjects_container);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            int i;
            String string;
            super.onBind(position);
            try {
                Object obj = this.this$0.subjectList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "subjectList[position]");
                SemesterList semesterList = (SemesterList) obj;
                this.sgpa.setText(semesterList.getSgpa());
                this.semName.setText("Semester " + semesterList.getSeme_pos());
                this.minorSubjectsContainer.removeAllViews();
                this.mdcSubjectsContainer.removeAllViews();
                Iterator<SemSubjects> it = semesterList.getMinor_subjects().iterator();
                while (true) {
                    i = 1;
                    if (!it.hasNext()) {
                        break;
                    }
                    SemSubjects next = it.next();
                    if (Build.VERSION.SDK_INT >= 24) {
                        String subject_name = next.getSubject_name();
                        if (subject_name == null) {
                            subject_name = "";
                        }
                        string = Html.fromHtml(subject_name, 0).toString();
                    } else {
                        String subject_name2 = next.getSubject_name();
                        if (subject_name2 == null) {
                            subject_name2 = "";
                        }
                        string = Html.fromHtml(subject_name2).toString();
                    }
                    this.minorSubjectsContainer.addView(onBind$createRow(this.this$0, "Subject", string + " (Group " + next.getGroup() + ")"));
                    this.minorSubjectsContainer.addView(onBind$createRow(this.this$0, "Mark", next.getMark()));
                    View view = new View(this.this$0.context);
                    ViewSemSubHistoryAdapter viewSemSubHistoryAdapter = this.this$0;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, viewSemSubHistoryAdapter.dpToPx(1));
                    layoutParams.setMargins(viewSemSubHistoryAdapter.dpToPx(15), viewSemSubHistoryAdapter.dpToPx(5), viewSemSubHistoryAdapter.dpToPx(15), viewSemSubHistoryAdapter.dpToPx(10));
                    view.setLayoutParams(layoutParams);
                    view.setBackgroundColor(Color.parseColor("#2077C9"));
                    this.minorSubjectsContainer.addView(view);
                }
                for (SemSubjects semSubjects : semesterList.getMdc_subjects()) {
                    this.mdcSubjectsContainer.addView(onBind$createRow$10(this.this$0, "Subject", semSubjects.getSubject_name() + " (Group " + semSubjects.getGroup() + ")"));
                    this.mdcSubjectsContainer.addView(onBind$createRow$10(this.this$0, "Mark", semSubjects.getMark()));
                    View view2 = new View(this.this$0.context);
                    ViewSemSubHistoryAdapter viewSemSubHistoryAdapter2 = this.this$0;
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, viewSemSubHistoryAdapter2.dpToPx(i));
                    layoutParams2.setMargins(viewSemSubHistoryAdapter2.dpToPx(15), viewSemSubHistoryAdapter2.dpToPx(5), viewSemSubHistoryAdapter2.dpToPx(15), viewSemSubHistoryAdapter2.dpToPx(10));
                    view2.setLayoutParams(layoutParams2);
                    view2.setBackgroundColor(Color.parseColor("#2077C9"));
                    this.mdcSubjectsContainer.addView(view2);
                    i = 1;
                }
            } catch (Exception unused) {
                System.out.println((Object) "");
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00d7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static final android.widget.LinearLayout onBind$createRow(in.etuwa.app.ui.subjectregistration.view.ViewSemSubHistoryAdapter r8, java.lang.String r9, java.lang.String r10) {
            /*
                Method dump skipped, instruction units count: 278
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.subjectregistration.view.ViewSemSubHistoryAdapter.ViewHolder.onBind$createRow(in.etuwa.app.ui.subjectregistration.view.ViewSemSubHistoryAdapter, java.lang.String, java.lang.String):android.widget.LinearLayout");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00d7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static final android.widget.LinearLayout onBind$createRow$10(in.etuwa.app.ui.subjectregistration.view.ViewSemSubHistoryAdapter r8, java.lang.String r9, java.lang.String r10) {
            /*
                Method dump skipped, instruction units count: 278
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.subjectregistration.view.ViewSemSubHistoryAdapter.ViewHolder.onBind$createRow$10(in.etuwa.app.ui.subjectregistration.view.ViewSemSubHistoryAdapter, java.lang.String, java.lang.String):android.widget.LinearLayout");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<SemesterList> list, Context context) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(context, "context");
        this.subjectList.clear();
        this.subjectList.addAll(list);
        this.context = context;
        notifyDataSetChanged();
    }

    public final void setSubjectListCallBack(ViewSubjectRegistrationDialog context) {
        this.listener = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dpToPx(int dp) {
        Context context = this.context;
        Intrinsics.checkNotNull(context);
        return (int) TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }
}