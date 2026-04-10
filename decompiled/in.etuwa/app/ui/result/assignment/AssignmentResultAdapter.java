package in.etuwa.app.ui.result.assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.result.ResultAssignment;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AssignmentResultAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class AssignmentResultAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<ResultAssignment> results = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_result_assi, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …sult_assi, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
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

    /* JADX INFO: compiled from: AssignmentResultAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lin/etuwa/app/ui/result/assignment/AssignmentResultAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/result/assignment/AssignmentResultAdapter;Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "notSubmittedLyt", "Landroid/widget/LinearLayout;", "notTv", FirebaseAnalytics.Param.SCORE, "subject", "submittedLyt", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView name;
        private final LinearLayout notSubmittedLyt;
        private final TextView notTv;
        private final TextView score;
        private final TextView subject;
        private final LinearLayout submittedLyt;
        final /* synthetic */ AssignmentResultAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(AssignmentResultAdapter assignmentResultAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = assignmentResultAdapter;
            this.name = (TextView) itemView.findViewById(R.id.result_assignment_name);
            this.subject = (TextView) itemView.findViewById(R.id.result_assignment_subject);
            this.score = (TextView) itemView.findViewById(R.id.result_assignment_score);
            this.submittedLyt = (LinearLayout) itemView.findViewById(R.id.score_container);
            this.notSubmittedLyt = (LinearLayout) itemView.findViewById(R.id.not_submitted_container);
            this.notTv = (TextView) itemView.findViewById(R.id.no_score_text);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.results.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "results[position]");
                ResultAssignment resultAssignment = (ResultAssignment) obj;
                this.name.setText(StringsKt.trim((CharSequence) resultAssignment.getName()).toString());
                List listSplit$default = StringsKt.split$default((CharSequence) resultAssignment.getSubject(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null);
                if (listSplit$default.size() == 2) {
                    this.subject.setText(StringsKt.trim((CharSequence) listSplit$default.get(listSplit$default.size() - 1)).toString());
                } else if (listSplit$default.size() == 3) {
                    this.subject.setText(StringsKt.trim((CharSequence) listSplit$default.get(listSplit$default.size() - 2)).toString() + " - " + StringsKt.trim((CharSequence) listSplit$default.get(listSplit$default.size() - 1)).toString());
                }
                if (!Intrinsics.areEqual(resultAssignment.getObtainMark(), "NOT SUBMITTED") && !Intrinsics.areEqual(resultAssignment.getObtainMark(), "Results not published")) {
                    this.score.setText(resultAssignment.getObtainMark() + RemoteSettings.FORWARD_SLASH_STRING + resultAssignment.getMaxMark());
                    this.submittedLyt.setVisibility(0);
                    this.notSubmittedLyt.setVisibility(8);
                    return;
                }
                this.notTv.setText(resultAssignment.getObtainMark());
                this.submittedLyt.setVisibility(8);
                this.notSubmittedLyt.setVisibility(0);
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<ResultAssignment> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.results.clear();
        this.results.addAll(list);
        notifyDataSetChanged();
    }
}