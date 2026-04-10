package in.etuwa.app.ui.studymaterials;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.materials.MaterialsNew;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.studymaterials.MaterialAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MaterialAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class MaterialAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private MaterialDownload listener;
    private final ArrayList<MaterialsNew> materials = new ArrayList<>();
    private final ArrayList<MaterialsNew> filteredMaterials = new ArrayList<>();

    /* JADX INFO: compiled from: MaterialAdapter.kt */
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
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_material, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …_material, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
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

    /* JADX INFO: compiled from: MaterialAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lin/etuwa/app/ui/studymaterials/MaterialAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/studymaterials/MaterialAdapter;Landroid/view/View;)V", "detailsLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "downBtn", "Lcom/google/android/material/button/MaterialButton;", "expandLayout", "linkBtn", "Landroid/widget/TextView;", "mDate", "module", "sem", "subject", "title", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final LinearLayout detailsLayout;
        private final MaterialButton downBtn;
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
            this.downBtn = (MaterialButton) itemView.findViewById(R.id.material_download_btn);
            this.expandLayout = (LinearLayout) itemView.findViewById(R.id.expand_layout);
            this.detailsLayout = (LinearLayout) itemView.findViewById(R.id.detail_layout);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.materials.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "materials[position]");
                final MaterialsNew materialsNew = (MaterialsNew) obj;
                List listSplit$default = StringsKt.split$default((CharSequence) materialsNew.getSubject(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null);
                this.subject.setText(StringsKt.trim((CharSequence) listSplit$default.get(listSplit$default.size() - 1)).toString());
                this.sem.setText(materialsNew.getSemester());
                this.title.setText("Title : " + materialsNew.getTitle());
                this.module.setText(materialsNew.getModule());
                this.mDate.setText(materialsNew.getDate());
                if (materialsNew.getUrl().size() > 0 || !Intrinsics.areEqual(materialsNew.getDownload(), "")) {
                    System.out.println(position);
                    this.downBtn.setVisibility(0);
                } else {
                    System.out.println(position);
                    this.downBtn.setVisibility(4);
                }
                TextView textView = this.linkBtn;
                final MaterialAdapter materialAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.studymaterials.MaterialAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MaterialAdapter.ViewHolder.onBind$lambda$0(materialAdapter, materialsNew, view);
                    }
                });
                String strReplace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(materialsNew.getDownload(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                MaterialDownload materialDownload = this.this$0.listener;
                Boolean boolValueOf = materialDownload != null ? Boolean.valueOf(materialDownload.checkFileExistence(strReplace)) : null;
                Intrinsics.checkNotNull(boolValueOf);
                if (boolValueOf.booleanValue()) {
                    if (Intrinsics.areEqual(materialsNew.getDownload(), "") && materialsNew.getUrl().size() > 0) {
                        this.downBtn.setText("Download");
                        this.downBtn.setIcon(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ic_download));
                        this.downBtn.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this.itemView.getContext(), R.color.colorPrimary)));
                    } else {
                        this.downBtn.setText("Open");
                        this.downBtn.setIcon(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ic_open_file));
                        this.downBtn.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this.itemView.getContext(), R.color.green_600)));
                    }
                } else {
                    this.downBtn.setText("Download");
                    this.downBtn.setIcon(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.ic_download));
                    this.downBtn.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this.itemView.getContext(), R.color.colorPrimary)));
                }
                MaterialButton materialButton = this.downBtn;
                final MaterialAdapter materialAdapter2 = this.this$0;
                materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.studymaterials.MaterialAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MaterialAdapter.ViewHolder.onBind$lambda$1(materialsNew, materialAdapter2, position, view);
                    }
                });
                this.expandLayout.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.studymaterials.MaterialAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MaterialAdapter.ViewHolder.onBind$lambda$2(this.f$0, view);
                    }
                });
            } catch (Exception unused) {
            }
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

    /* JADX WARN: Removed duplicated region for block: B:11:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void applyCombinedFilter(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.util.ArrayList<in.etuwa.app.data.model.materials.MaterialsNew> r0 = r11.filteredMaterials
            r0.clear()
            java.util.ArrayList<in.etuwa.app.data.model.materials.MaterialsNew> r0 = r11.materials
            r1 = r12
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L78
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r12 = r12.toLowerCase(r1)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r0 = r0.iterator()
        L2f:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L73
            java.lang.Object r4 = r0.next()
            r5 = r4
            in.etuwa.app.data.model.materials.MaterialsNew r5 = (in.etuwa.app.data.model.materials.MaterialsNew) r5
            java.lang.String r6 = r5.getSubject()
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r6 = r6.toLowerCase(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = r12
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r8 = 0
            r9 = 2
            r10 = 0
            boolean r6 = kotlin.text.StringsKt.contains$default(r6, r7, r8, r9, r10)
            if (r6 != 0) goto L6c
            java.lang.String r5 = r5.getTitle()
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = kotlin.text.StringsKt.contains$default(r5, r7, r8, r9, r10)
            if (r5 == 0) goto L6d
        L6c:
            r8 = 1
        L6d:
            if (r8 == 0) goto L2f
            r3.add(r4)
            goto L2f
        L73:
            java.util.List r3 = (java.util.List) r3
            r0 = r3
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        L78:
            java.util.ArrayList<in.etuwa.app.data.model.materials.MaterialsNew> r12 = r11.filteredMaterials
            java.util.Collection r0 = (java.util.Collection) r0
            r12.addAll(r0)
            r11.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.studymaterials.MaterialAdapter.applyCombinedFilter(java.lang.String):void");
    }

    public final void setMaterialDownload(MaterialFragment context) {
        this.listener = context;
    }
}