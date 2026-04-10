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
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UniversityExamAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class UniversityExamAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<UnivExamSubjects> results = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.row_univ_exam_subjects, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflater.inflate(R.layou…_subjects, parent, false)");
            return new ViewHolder(this, viewInflate);
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "inflater.inflate(R.layou…mpty_view, parent, false)");
        return new EmptyViewHolder(viewInflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!this.results.isEmpty()) {
            return this.results.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.results.isEmpty() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<UnivExamSubjects> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.results.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearItems() {
        this.results.clear();
        notifyDataSetChanged();
    }

    /* JADX INFO: compiled from: UniversityExamAdapter.kt */
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
            String string;
            String string2;
            String string3;
            String string4;
            Pair pair;
            String string5 = HelpFormatter.DEFAULT_OPT_PREFIX;
            super.onBind(position);
            UniversityExamAdapter universityExamAdapter = this.this$0;
            try {
                Result.Companion companion = Result.INSTANCE;
                ViewHolder viewHolder = this;
                Object obj = universityExamAdapter.results.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "results[position]");
                UnivExamSubjects univExamSubjects = (UnivExamSubjects) obj;
                String univMark = univExamSubjects.getUnivMark();
                boolean z = !Intrinsics.areEqual(univMark != null ? StringsKt.trim((CharSequence) univMark).toString() : null, HelpFormatter.DEFAULT_OPT_PREFIX);
                TextView textView = this.subject;
                if (z) {
                    String subject = univExamSubjects.getSubject();
                    string = subject != null ? StringsKt.trim((CharSequence) subject).toString() : null;
                }
                textView.setText(string);
                TextView textView2 = this.attendance;
                if (z) {
                    String attendance = univExamSubjects.getAttendance();
                    string2 = attendance != null ? StringsKt.trim((CharSequence) attendance).toString() : null;
                }
                textView2.setText(string2);
                TextView textView3 = this.credit;
                if (z) {
                    String credits = univExamSubjects.getCredits();
                    string3 = credits != null ? StringsKt.trim((CharSequence) credits).toString() : null;
                }
                textView3.setText(string3);
                TextView textView4 = this.uniMark;
                if (z) {
                    String univMark2 = univExamSubjects.getUnivMark();
                    string4 = univMark2 != null ? StringsKt.trim((CharSequence) univMark2).toString() : null;
                }
                textView4.setText(string4);
                TextView textView5 = this.status;
                if (z) {
                    String status = univExamSubjects.getStatus();
                    string5 = status != null ? StringsKt.trim((CharSequence) status).toString() : null;
                }
                textView5.setText(string5);
                if (!z) {
                    pair = TuplesKt.to("#808080", "#FFFFFF");
                } else {
                    String status2 = univExamSubjects.getStatus();
                    if (Intrinsics.areEqual(status2 != null ? StringsKt.trim((CharSequence) status2).toString() : null, "P")) {
                        pair = TuplesKt.to("#266d19", "#FFFFFF");
                    } else {
                        String status3 = univExamSubjects.getStatus();
                        pair = Intrinsics.areEqual(status3 != null ? StringsKt.trim((CharSequence) status3).toString() : null, "F") ? TuplesKt.to("#E10000", "#FFFFFF") : TuplesKt.to("#808080", "#FFFFFF");
                    }
                }
                String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                this.status.setBackgroundColor(Color.parseColor(str));
                this.status.setTextColor(Color.parseColor(str2));
                Result.m1430constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1430constructorimpl(ResultKt.createFailure(th));
            }
        }
    }
}