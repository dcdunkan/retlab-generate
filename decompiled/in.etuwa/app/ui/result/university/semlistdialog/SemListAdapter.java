package in.etuwa.app.ui.result.university.semlistdialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.result.university.semlistdialog.SemListAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemListAdapter.kt */
/* loaded from: classes5.dex */
public final class SemListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<Semester> list = new ArrayList<>();
    private SemCallBack listener;

    /* compiled from: SemListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/result/university/semlistdialog/SemListAdapter$SemCallBack;", "", "onSemSelected", "", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SemCallBack {
        void onSemSelected(String id);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_univ_sem_list, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …_sem_list, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.list.size() > 0) {
            return this.list.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.list.isEmpty() ? 1 : 0;
    }

    /* compiled from: SemListAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/result/university/semlistdialog/SemListAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/result/university/semlistdialog/SemListAdapter;Landroid/view/View;)V", "tvSem", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        final /* synthetic */ SemListAdapter this$0;
        private final TextView tvSem;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SemListAdapter semListAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = semListAdapter;
            this.tvSem = (TextView) itemView.findViewById(R.id.univ_sem);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                final Semester semester = (Semester) obj;
                this.tvSem.setText(semester.getName());
                TextView textView = this.tvSem;
                final SemListAdapter semListAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.result.university.semlistdialog.SemListAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SemListAdapter.ViewHolder.onBind$lambda$0(SemListAdapter.this, semester, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(SemListAdapter this$0, Semester sem, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(sem, "$sem");
            SemCallBack semCallBack = this$0.listener;
            if (semCallBack != null) {
                semCallBack.onSemSelected(sem.getId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Semester> _list) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        this.list.clear();
        this.list.addAll(_list);
        notifyDataSetChanged();
    }

    public final void clearItems() {
        this.list.clear();
        notifyDataSetChanged();
    }

    public final void setCallBack(SemListDialog context) {
        this.listener = context;
    }
}