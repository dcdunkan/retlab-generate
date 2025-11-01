package in.etuwa.app.ui.studymaterials;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.materials.MaterialsNew;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaterialAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\u0006\u0010\r\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/ui/studymaterials/MaterialAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/studymaterials/MaterialAdapter$MaterialDownload;", "materials", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/materials/MaterialsNew;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "clearItems", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setMaterialDownload", "context", "Lin/etuwa/app/ui/studymaterials/MaterialFragment;", "MaterialDownload", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MaterialAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private MaterialDownload listener;
    private final ArrayList<MaterialsNew> materials = new ArrayList<>();

    /* compiled from: MaterialAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J8\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/studymaterials/MaterialAdapter$MaterialDownload;", "", "checkFileExistence", "", "fileName", "", "downloadFile", "", "url", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "url2", CommonCssConstants.POSITION, "", "flag", "onLinkClick", "link", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface MaterialDownload {
        boolean checkFileExistence(String fileName);

        void downloadFile(ArrayList<String> url, String url2, int position, boolean flag);

        void onLinkClick(String link);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_material, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …_material, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.materials.size() > 0) {
            return this.materials.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.materials.isEmpty() ? 1 : 0;
    }

    /* compiled from: MaterialAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lin/etuwa/app/ui/studymaterials/MaterialAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/studymaterials/MaterialAdapter;Landroid/view/View;)V", "detailsLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "downBtn", "Landroid/widget/TextView;", "expandLayout", "linkBtn", "mDate", "module", "sem", "subject", "title", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final LinearLayout detailsLayout;
        private final TextView downBtn;
        private final LinearLayout expandLayout;
        private final TextView linkBtn;
        private final TextView mDate;
        private final TextView module;
        private final TextView sem;
        private final TextView subject;
        final /* synthetic */ MaterialAdapter this$0;
        private final TextView title;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(MaterialAdapter materialAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = materialAdapter;
            this.subject = (TextView) itemView.findViewById(R.id.material_name);
            this.sem = (TextView) itemView.findViewById(R.id.material_sem);
            this.title = (TextView) itemView.findViewById(R.id.material_title);
            this.module = (TextView) itemView.findViewById(R.id.material_module);
            this.mDate = (TextView) itemView.findViewById(R.id.material_date);
            this.linkBtn = (TextView) itemView.findViewById(R.id.material_link);
            this.downBtn = (TextView) itemView.findViewById(R.id.material_download_btn);
            this.expandLayout = (LinearLayout) itemView.findViewById(R.id.expand_layout);
            this.detailsLayout = (LinearLayout) itemView.findViewById(R.id.detail_layout);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x00db A[Catch: Exception -> 0x0146, TryCatch #0 {Exception -> 0x0146, blocks: (B:3:0x0005, B:6:0x008d, B:9:0x0098, B:10:0x00ae, B:12:0x00db, B:13:0x00e3, B:16:0x00ee, B:18:0x00f8, B:20:0x0102, B:21:0x0130, B:25:0x0111, B:26:0x0122, B:27:0x00a4), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00ee A[Catch: Exception -> 0x0146, TRY_ENTER, TryCatch #0 {Exception -> 0x0146, blocks: (B:3:0x0005, B:6:0x008d, B:9:0x0098, B:10:0x00ae, B:12:0x00db, B:13:0x00e3, B:16:0x00ee, B:18:0x00f8, B:20:0x0102, B:21:0x0130, B:25:0x0111, B:26:0x0122, B:27:0x00a4), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0122 A[Catch: Exception -> 0x0146, TryCatch #0 {Exception -> 0x0146, blocks: (B:3:0x0005, B:6:0x008d, B:9:0x0098, B:10:0x00ae, B:12:0x00db, B:13:0x00e3, B:16:0x00ee, B:18:0x00f8, B:20:0x0102, B:21:0x0130, B:25:0x0111, B:26:0x0122, B:27:0x00a4), top: B:2:0x0005 }] */
        @Override // in.etuwa.app.ui.base.BaseViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onBind(final int r11) {
            /*
                Method dump skipped, instructions count: 327
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.studymaterials.MaterialAdapter.ViewHolder.onBind(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(MaterialAdapter this$0, MaterialsNew material, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(material, "$material");
            MaterialDownload materialDownload = this$0.listener;
            if (materialDownload != null) {
                materialDownload.onLinkClick(material.getLink());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(MaterialsNew material, MaterialAdapter this$0, int i, View view) {
            Intrinsics.checkNotNullParameter(material, "$material");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!Intrinsics.areEqual(material.getDownload(), "") || material.getUrl().size() <= 0) {
                MaterialDownload materialDownload = this$0.listener;
                if (materialDownload != null) {
                    materialDownload.downloadFile(material.getUrl(), material.getDownload(), i, false);
                    return;
                }
                return;
            }
            MaterialDownload materialDownload2 = this$0.listener;
            if (materialDownload2 != null) {
                materialDownload2.downloadFile(material.getUrl(), material.getDownload(), i, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.detailsLayout.getVisibility() == 0) {
                this$0.detailsLayout.setVisibility(8);
            } else {
                this$0.detailsLayout.setVisibility(0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<MaterialsNew> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.materials.clear();
        this.materials.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearItems() {
        this.materials.clear();
        notifyDataSetChanged();
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void setMaterialDownload(MaterialFragment context) {
        this.listener = context;
    }
}