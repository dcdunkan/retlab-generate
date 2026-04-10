package in.etuwa.app.ui.university;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.university.UniversityResult;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniversityResultAdapter.kt */
/* loaded from: classes5.dex */
public final class UniversityResultAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private CallBack listener;
    private final ArrayList<UniversityResult> result = new ArrayList<>();

    /* compiled from: UniversityResultAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/university/UniversityResultAdapter$CallBack;", "", "checkFileExistence", "", "fileName", "", "flag", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        boolean checkFileExistence(String fileName, boolean flag);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tkm_university, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …niversity, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.result.size() > 0) {
            return this.result.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.result.isEmpty() ? 1 : 0;
    }

    /* compiled from: UniversityResultAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/university/UniversityResultAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/university/UniversityResultAdapter;Landroid/view/View;)V", "credit", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "grade", "name", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView credit;
        private final TextView grade;
        private final TextView name;
        final /* synthetic */ UniversityResultAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(UniversityResultAdapter universityResultAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = universityResultAdapter;
            this.name = (TextView) itemView.findViewById(R.id.univ_subject_name);
            this.grade = (TextView) itemView.findViewById(R.id.univ_grade);
            this.credit = (TextView) itemView.findViewById(R.id.univ_credit);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.result.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "result[position]");
                UniversityResult universityResult = (UniversityResult) obj;
                this.name.setText(universityResult.getCode() + HelpFormatter.DEFAULT_OPT_PREFIX + universityResult.getName());
                this.grade.setText(universityResult.getGrade());
                this.credit.setText(universityResult.getCredit());
                this.credit.setBackgroundColor(Color.parseColor("#808080"));
                String pass_status = universityResult.getPass_status();
                int hashCode = pass_status.hashCode();
                if (hashCode == 45) {
                    if (pass_status.equals(HelpFormatter.DEFAULT_OPT_PREFIX)) {
                        this.grade.setBackgroundColor(Color.parseColor("#808080"));
                    }
                    this.grade.setBackgroundColor(Color.parseColor("#266d19"));
                }
                if (hashCode == 73) {
                    if (pass_status.equals("I")) {
                        this.grade.setBackgroundColor(Color.parseColor("#E10000"));
                    } else {
                        this.grade.setBackgroundColor(Color.parseColor("#266d19"));
                    }
                }
                if (hashCode == 2239) {
                    if (pass_status.equals("FE")) {
                        this.grade.setBackgroundColor(Color.parseColor("#E10000"));
                    } else {
                        this.grade.setBackgroundColor(Color.parseColor("#266d19"));
                    }
                }
                if (hashCode == 1954926425) {
                    if (pass_status.equals("Absent")) {
                        this.grade.setBackgroundColor(Color.parseColor("#808080"));
                    } else {
                        this.grade.setBackgroundColor(Color.parseColor("#266d19"));
                    }
                }
                if (hashCode == 2096857181 && pass_status.equals("Failed")) {
                    this.grade.setBackgroundColor(Color.parseColor("#E10000"));
                }
                this.grade.setBackgroundColor(Color.parseColor("#266d19"));
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<UniversityResult> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.result.clear();
        this.result.addAll(list);
        notifyDataSetChanged();
    }

    public final void clear() {
        this.result.clear();
        notifyDataSetChanged();
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void setCallBack(UniversityResultFragment context) {
        this.listener = context;
    }
}