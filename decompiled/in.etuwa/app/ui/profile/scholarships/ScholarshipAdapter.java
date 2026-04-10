package in.etuwa.app.ui.profile.scholarships;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.profileasiet.scholarships.Scholarships;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.profile.scholarships.ScholarshipAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: ScholarshipAdapter.kt */
/* loaded from: classes5.dex */
public final class ScholarshipAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private ScholarshipListener listener;
    private final ArrayList<Scholarships> scholarships = new ArrayList<>();

    /* compiled from: ScholarshipAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/profile/scholarships/ScholarshipAdapter$ScholarshipListener;", "", "checkFileExistence", "", "fileName", "", "deleteBtnClicked", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "", "editBtnClicked", ErrorBundle.DETAIL_ENTRY, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ScholarshipListener {
        boolean checkFileExistence(String fileName);

        void deleteBtnClicked(String id);

        void downloadFile(String url, int position);

        void editBtnClicked(String id, String details);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_scholarships, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …olarships, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.scholarships.size() > 0) {
            return this.scholarships.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.scholarships.isEmpty() ? 1 : 0;
    }

    /* compiled from: ScholarshipAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/profile/scholarships/ScholarshipAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/profile/scholarships/ScholarshipAdapter;Landroid/view/View;)V", "deleteBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "editBtn", "title", "typeTv", "yearTv", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView deleteBtn;
        private final TextView editBtn;
        final /* synthetic */ ScholarshipAdapter this$0;
        private final TextView title;
        private final TextView typeTv;
        private final TextView yearTv;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ScholarshipAdapter scholarshipAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = scholarshipAdapter;
            this.title = (TextView) itemView.findViewById(R.id.title_tv);
            this.typeTv = (TextView) itemView.findViewById(R.id.type_tv);
            this.yearTv = (TextView) itemView.findViewById(R.id.year_tv);
            this.editBtn = (TextView) itemView.findViewById(R.id.edit_btn);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.delete_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.scholarships.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "scholarships[position]");
                final Scholarships scholarships = (Scholarships) obj;
                this.title.setText(scholarships.getName());
                this.typeTv.setText(scholarships.getType());
                this.yearTv.setText(scholarships.getYear());
                TextView textView = this.editBtn;
                if (textView != null) {
                    final ScholarshipAdapter scholarshipAdapter = this.this$0;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.scholarships.ScholarshipAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ScholarshipAdapter.ViewHolder.onBind$lambda$0(ScholarshipAdapter.this, scholarships, view);
                        }
                    });
                }
                TextView textView2 = this.deleteBtn;
                if (textView2 != null) {
                    final ScholarshipAdapter scholarshipAdapter2 = this.this$0;
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.scholarships.ScholarshipAdapter$ViewHolder$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ScholarshipAdapter.ViewHolder.onBind$lambda$1(ScholarshipAdapter.this, scholarships, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ScholarshipAdapter this$0, Scholarships scholarships, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(scholarships, "$scholarships");
            ScholarshipListener scholarshipListener = this$0.listener;
            if (scholarshipListener != null) {
                scholarshipListener.editBtnClicked(scholarships.getId(), scholarships.getName());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(ScholarshipAdapter this$0, Scholarships scholarships, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(scholarships, "$scholarships");
            ScholarshipListener scholarshipListener = this$0.listener;
            if (scholarshipListener != null) {
                scholarshipListener.deleteBtnClicked(scholarships.getId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Scholarships> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.scholarships.clear();
        this.scholarships.addAll(list);
        notifyDataSetChanged();
    }

    public final void setScholarshipListener(ScholarshipFragment context) {
        this.listener = context;
    }
}