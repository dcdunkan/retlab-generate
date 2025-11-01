package in.etuwa.app.ui.profile.positionheld;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.profileasiet.positionheld.PositionHeld;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.profile.positionheld.PositionHeldAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PositionHeldAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lin/etuwa/app/ui/profile/positionheld/PositionHeldAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/positionheld/PositionHeldAdapter$PositionHeldListener;", "positionHeld", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/profileasiet/positionheld/PositionHeld;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setPositionHeldListener", "context", "Lin/etuwa/app/ui/profile/positionheld/PositionHeldFragment;", "PositionHeldListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PositionHeldAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private PositionHeldListener listener;
    private final ArrayList<PositionHeld> positionHeld = new ArrayList<>();

    /* compiled from: PositionHeldAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J(\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/profile/positionheld/PositionHeldAdapter$PositionHeldListener;", "", "checkFileExistence", "", "fileName", "", "deleteBtnClicked", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "", "editBtnClicked", "name", "fromDate", "toDate", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface PositionHeldListener {
        boolean checkFileExistence(String fileName);

        void deleteBtnClicked(String id);

        void downloadFile(String url, int position);

        void editBtnClicked(String id, String name, String fromDate, String toDate);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_position, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …_position, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.positionHeld.size() > 0) {
            return this.positionHeld.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.positionHeld.isEmpty() ? 1 : 0;
    }

    /* compiled from: PositionHeldAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/profile/positionheld/PositionHeldAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/profile/positionheld/PositionHeldAdapter;Landroid/view/View;)V", "deleteBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "editBtn", "endDate", "startDate", "title", "yearTv", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView deleteBtn;
        private final TextView editBtn;
        private final TextView endDate;
        private final TextView startDate;
        final /* synthetic */ PositionHeldAdapter this$0;
        private final TextView title;
        private final TextView yearTv;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PositionHeldAdapter positionHeldAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = positionHeldAdapter;
            this.title = (TextView) itemView.findViewById(R.id.title_tv);
            this.yearTv = (TextView) itemView.findViewById(R.id.year_tv);
            this.startDate = (TextView) itemView.findViewById(R.id.start_date_tv);
            this.endDate = (TextView) itemView.findViewById(R.id.end_date_tv);
            this.editBtn = (TextView) itemView.findViewById(R.id.edit_btn);
            this.deleteBtn = (TextView) itemView.findViewById(R.id.delete_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.positionHeld.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "positionHeld[position]");
                final PositionHeld positionHeld = (PositionHeld) obj;
                this.title.setText(positionHeld.getName());
                this.startDate.setText(positionHeld.getStart());
                this.yearTv.setText(positionHeld.getYear());
                this.endDate.setText(positionHeld.getEnd());
                TextView textView = this.editBtn;
                if (textView != null) {
                    final PositionHeldAdapter positionHeldAdapter = this.this$0;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.positionheld.PositionHeldAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PositionHeldAdapter.ViewHolder.onBind$lambda$0(PositionHeldAdapter.this, positionHeld, view);
                        }
                    });
                }
                TextView textView2 = this.deleteBtn;
                if (textView2 != null) {
                    final PositionHeldAdapter positionHeldAdapter2 = this.this$0;
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.positionheld.PositionHeldAdapter$ViewHolder$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PositionHeldAdapter.ViewHolder.onBind$lambda$1(PositionHeldAdapter.this, positionHeld, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(PositionHeldAdapter this$0, PositionHeld positionHeld, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(positionHeld, "$positionHeld");
            PositionHeldListener positionHeldListener = this$0.listener;
            if (positionHeldListener != null) {
                positionHeldListener.editBtnClicked(positionHeld.getId(), positionHeld.getName(), positionHeld.getStart(), positionHeld.getEnd());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(PositionHeldAdapter this$0, PositionHeld positionHeld, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(positionHeld, "$positionHeld");
            PositionHeldListener positionHeldListener = this$0.listener;
            if (positionHeldListener != null) {
                positionHeldListener.deleteBtnClicked(positionHeld.getId());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<PositionHeld> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.positionHeld.clear();
        this.positionHeld.addAll(list);
        notifyDataSetChanged();
    }

    public final void setPositionHeldListener(PositionHeldFragment context) {
        this.listener = context;
    }
}