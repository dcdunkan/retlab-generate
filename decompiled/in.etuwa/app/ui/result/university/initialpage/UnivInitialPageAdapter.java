package in.etuwa.app.ui.result.university.initialpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.result.univ.UnivSubjects;
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

/* JADX INFO: compiled from: UnivInitialPageAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class UnivInitialPageAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<UnivSubjects> results = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.row_univ_subjects, parent, false);
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

    public final void addItems(ArrayList<UnivSubjects> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.results.clear();
        this.results.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: compiled from: UnivInitialPageAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/result/university/initialpage/UnivInitialPageAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/result/university/initialpage/UnivInitialPageAdapter;Landroid/view/View;)V", NotificationCompat.CATEGORY_STATUS, "Landroid/widget/TextView;", "subject", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView status;
        private final TextView subject;
        final /* synthetic */ UnivInitialPageAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(UnivInitialPageAdapter univInitialPageAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = univInitialPageAdapter;
            View viewFindViewById = itemView.findViewById(R.id.univ_subject);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.id.univ_subject)");
            this.subject = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.univ_status);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "itemView.findViewById(R.id.univ_status)");
            this.status = (TextView) viewFindViewById2;
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            Pair pair;
            super.onBind(position);
            UnivInitialPageAdapter univInitialPageAdapter = this.this$0;
            try {
                Result.Companion companion = Result.INSTANCE;
                ViewHolder viewHolder = this;
                Object obj = univInitialPageAdapter.results.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "results[position]");
                UnivSubjects univSubjects = (UnivSubjects) obj;
                this.subject.setText(univSubjects.getSubject());
                this.status.setText(univSubjects.getStatus());
                Context context = this.itemView.getContext();
                String status = univSubjects.getStatus();
                if (status == null) {
                    pair = TuplesKt.to(Integer.valueOf(R.color.status_pass_bg), Integer.valueOf(R.color.status_pass_text));
                } else {
                    int iHashCode = status.hashCode();
                    if (iHashCode == 45) {
                        if (!status.equals(HelpFormatter.DEFAULT_OPT_PREFIX)) {
                            pair = TuplesKt.to(Integer.valueOf(R.color.status_pass_bg), Integer.valueOf(R.color.status_pass_text));
                        }
                        pair = TuplesKt.to(Integer.valueOf(R.color.status_na_bg), Integer.valueOf(R.color.status_na_text));
                    } else if (iHashCode == 70) {
                        if (!status.equals("F")) {
                            pair = TuplesKt.to(Integer.valueOf(R.color.status_pass_bg), Integer.valueOf(R.color.status_pass_text));
                        }
                        pair = TuplesKt.to(Integer.valueOf(R.color.status_fail_bg), Integer.valueOf(R.color.status_fail_text));
                    } else if (iHashCode == 73) {
                        if (!status.equals("I")) {
                            pair = TuplesKt.to(Integer.valueOf(R.color.status_pass_bg), Integer.valueOf(R.color.status_pass_text));
                        }
                        pair = TuplesKt.to(Integer.valueOf(R.color.status_fail_bg), Integer.valueOf(R.color.status_fail_text));
                    } else {
                        if (iHashCode != 2239) {
                            if (iHashCode != 1954926425 || !status.equals("Absent")) {
                            }
                            pair = TuplesKt.to(Integer.valueOf(R.color.status_na_bg), Integer.valueOf(R.color.status_na_text));
                        } else if (status.equals("FE")) {
                            pair = TuplesKt.to(Integer.valueOf(R.color.status_fail_bg), Integer.valueOf(R.color.status_fail_text));
                        }
                        pair = TuplesKt.to(Integer.valueOf(R.color.status_pass_bg), Integer.valueOf(R.color.status_pass_text));
                    }
                }
                int iIntValue = ((Number) pair.component1()).intValue();
                int iIntValue2 = ((Number) pair.component2()).intValue();
                this.status.setBackgroundColor(ContextCompat.getColor(context, iIntValue));
                this.status.setTextColor(ContextCompat.getColor(context, iIntValue2));
                Result.m1430constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1430constructorimpl(ResultKt.createFailure(th));
            }
        }
    }
}