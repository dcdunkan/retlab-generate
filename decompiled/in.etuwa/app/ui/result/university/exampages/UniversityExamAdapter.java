package in.etuwa.app.ui.result.university.exampages;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.result.univ.UnivExamSubjects;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UniversityExamAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\u0006\u0010\u000b\u001a\u00020\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lin/etuwa/app/ui/result/university/exampages/UniversityExamAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "results", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/result/univ/UnivExamSubjects;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "clearItems", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UniversityExamAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<UnivExamSubjects> results = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_univ_exam_subjects, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …_subjects, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.results.size() > 0) {
            return this.results.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.results.isEmpty() ? 1 : 0;
    }

    /* compiled from: UniversityExamAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/result/university/exampages/UniversityExamAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/result/university/exampages/UniversityExamAdapter;Landroid/view/View;)V", "attendance", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "credit", NotificationCompat.CATEGORY_STATUS, "subject", "uniMark", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView attendance;
        private final TextView credit;
        private final TextView status;
        private final TextView subject;
        final /* synthetic */ UniversityExamAdapter this$0;
        private final TextView uniMark;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(UniversityExamAdapter universityExamAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = universityExamAdapter;
            this.subject = (TextView) itemView.findViewById(R.id.univ_exam_subject);
            this.attendance = (TextView) itemView.findViewById(R.id.univ_exam_attendance);
            this.credit = (TextView) itemView.findViewById(R.id.univ_exam_credit);
            this.uniMark = (TextView) itemView.findViewById(R.id.univ_exam_mark);
            this.status = (TextView) itemView.findViewById(R.id.view_uni_status);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.results.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "results[position]");
                UnivExamSubjects univExamSubjects = (UnivExamSubjects) obj;
                String univMark = univExamSubjects.getUnivMark();
                if (!Intrinsics.areEqual(univMark != null ? StringsKt.trim((CharSequence) univMark).toString() : null, HelpFormatter.DEFAULT_OPT_PREFIX)) {
                    TextView textView = this.subject;
                    String subject = univExamSubjects.getSubject();
                    textView.setText(subject != null ? StringsKt.trim((CharSequence) subject).toString() : null);
                    TextView textView2 = this.attendance;
                    String attendance = univExamSubjects.getAttendance();
                    textView2.setText(attendance != null ? StringsKt.trim((CharSequence) attendance).toString() : null);
                    TextView textView3 = this.credit;
                    String credits = univExamSubjects.getCredits();
                    textView3.setText(credits != null ? StringsKt.trim((CharSequence) credits).toString() : null);
                    TextView textView4 = this.uniMark;
                    String univMark2 = univExamSubjects.getUnivMark();
                    textView4.setText(univMark2 != null ? StringsKt.trim((CharSequence) univMark2).toString() : null);
                    TextView textView5 = this.status;
                    String status = univExamSubjects.getStatus();
                    textView5.setText(status != null ? StringsKt.trim((CharSequence) status).toString() : null);
                    String status2 = univExamSubjects.getStatus();
                    if (Intrinsics.areEqual(status2, "P")) {
                        this.status.setBackgroundColor(Color.parseColor("#266d19"));
                        return;
                    } else if (Intrinsics.areEqual(status2, "F")) {
                        this.status.setBackgroundColor(Color.parseColor("#E10000"));
                        return;
                    } else {
                        this.status.setBackgroundColor(Color.parseColor("#808080"));
                        return;
                    }
                }
                this.subject.setText(HelpFormatter.DEFAULT_OPT_PREFIX);
                this.attendance.setText(HelpFormatter.DEFAULT_OPT_PREFIX);
                this.credit.setText(HelpFormatter.DEFAULT_OPT_PREFIX);
                this.uniMark.setText(HelpFormatter.DEFAULT_OPT_PREFIX);
                this.status.setText(HelpFormatter.DEFAULT_OPT_PREFIX);
                this.status.setBackgroundColor(Color.parseColor("#808080"));
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<UnivExamSubjects> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.results.clear();
        this.results.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearItems() {
        this.results.clear();
        notifyDataSetChanged();
    }
}