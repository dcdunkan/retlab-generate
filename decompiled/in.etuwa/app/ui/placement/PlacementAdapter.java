package in.etuwa.app.ui.placement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.kernel.xmp.PdfConst;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.placement.Placement;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlacementAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class PlacementAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private PlacementInteraction listener;
    private final ArrayList<Placement> placements = new ArrayList<>();

    /* JADX INFO: compiled from: PlacementAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/placement/PlacementAdapter$PlacementInteraction;", "", "apply", "", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface PlacementInteraction {
        void apply(String id);
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_placement, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …placement, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.placements.size() > 0) {
            return this.placements.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.placements.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: PlacementAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/placement/PlacementAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/placement/PlacementAdapter;Landroid/view/View;)V", "apply", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "company", "date", PdfConst.Description, "lastDate", "registeredTv", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView apply;
        private final TextView company;
        private final TextView date;
        private final TextView description;
        private final TextView lastDate;
        private final TextView registeredTv;
        final /* synthetic */ PlacementAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PlacementAdapter placementAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = placementAdapter;
            this.company = (TextView) itemView.findViewById(R.id.pl_company_name);
            this.description = (TextView) itemView.findViewById(R.id.pl_description);
            this.date = (TextView) itemView.findViewById(R.id.pl_date);
            this.lastDate = (TextView) itemView.findViewById(R.id.pl_last_date);
            this.apply = (TextView) itemView.findViewById(R.id.pl_apply_btn);
            this.registeredTv = (TextView) itemView.findViewById(R.id.registered_tv);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x00ca A[Catch: Exception -> 0x010e, TryCatch #0 {Exception -> 0x010e, blocks: (B:3:0x0009, B:5:0x0069, B:7:0x0084, B:9:0x009e, B:11:0x00a9, B:14:0x00b3, B:16:0x00c4, B:18:0x00cf, B:20:0x00e2, B:21:0x00ed, B:23:0x00fe, B:24:0x0109, B:17:0x00ca, B:10:0x00a4, B:6:0x007d), top: B:27:0x0009 }] */
        @Override // in.etuwa.app.ui.base.BaseViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onBind(int r7) {
            /*
                Method dump skipped, instruction units count: 271
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.placement.PlacementAdapter.ViewHolder.onBind(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(Placement placement, PlacementAdapter this$0, View view) {
            PlacementInteraction placementInteraction;
            Intrinsics.checkNotNullParameter(placement, "$placement");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual(placement.getStatus(), "Registered") || (placementInteraction = this$0.listener) == null) {
                return;
            }
            placementInteraction.apply(placement.getId());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Placement> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.placements.clear();
        this.placements.addAll(list);
        CollectionsKt.reverse(this.placements);
        notifyDataSetChanged();
    }

    public final void setPlacementInteraction(PlacementFragment context) {
        this.listener = context;
    }
}