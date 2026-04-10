package in.etuwa.app.ui.questionbank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.materials.Materials;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.questionbank.QuestionBankAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: QuestionBankAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class QuestionBankAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private QuestionListener listener;
    private final ArrayList<Materials> materials = new ArrayList<>();
    private final ArrayList<Materials> filteredMaterials = new ArrayList<>();

    /* JADX INFO: compiled from: QuestionBankAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/questionbank/QuestionBankAdapter$QuestionListener;", "", "checkFileExistence", "", "fileName", "", "downloadFile", "", "url", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface QuestionListener {
        boolean checkFileExistence(String fileName);

        void downloadFile(String url, int position);
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

    /* JADX INFO: compiled from: QuestionBankAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0014"}, d2 = {"Lin/etuwa/app/ui/questionbank/QuestionBankAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/questionbank/QuestionBankAdapter;Landroid/view/View;)V", "downBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getDownBtn", "()Landroid/widget/TextView;", "sem", "getSem", "subject", "title", "getTitle", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView downBtn;
        private final TextView sem;
        private final TextView subject;
        final /* synthetic */ QuestionBankAdapter this$0;
        private final TextView title;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(QuestionBankAdapter questionBankAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = questionBankAdapter;
            this.subject = (TextView) itemView.findViewById(R.id.material_name);
            this.sem = (TextView) itemView.findViewById(R.id.material_sem);
            this.title = (TextView) itemView.findViewById(R.id.material_title);
            this.downBtn = (TextView) itemView.findViewById(R.id.material_download_btn);
        }

        public final TextView getSem() {
            return this.sem;
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final TextView getDownBtn() {
            return this.downBtn;
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.materials.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "materials[position]");
                final Materials materials = (Materials) obj;
                List listSplit$default = StringsKt.split$default((CharSequence) materials.getSubject(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null);
                this.subject.setText(StringsKt.trim((CharSequence) listSplit$default.get(listSplit$default.size() - 2)).toString());
                this.sem.setText(materials.getSemester());
                this.title.setText(materials.getTitle());
                String strReplace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(materials.getUrl(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                QuestionListener questionListener = this.this$0.listener;
                Boolean boolValueOf = questionListener != null ? Boolean.valueOf(questionListener.checkFileExistence(strReplace)) : null;
                Intrinsics.checkNotNull(boolValueOf);
                if (boolValueOf.booleanValue()) {
                    this.downBtn.setText("Open");
                    this.downBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_inactive);
                } else {
                    this.downBtn.setText("Download");
                    this.downBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_dark);
                }
                TextView textView = this.downBtn;
                final QuestionBankAdapter questionBankAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.questionbank.QuestionBankAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QuestionBankAdapter.ViewHolder.onBind$lambda$0(questionBankAdapter, materials, position, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(QuestionBankAdapter this$0, Materials material, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(material, "$material");
            QuestionListener questionListener = this$0.listener;
            if (questionListener != null) {
                questionListener.downloadFile(material.getUrl(), i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Materials> list) {
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
            java.util.ArrayList<in.etuwa.app.data.model.materials.Materials> r0 = r11.filteredMaterials
            r0.clear()
            java.util.ArrayList<in.etuwa.app.data.model.materials.Materials> r0 = r11.materials
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
            in.etuwa.app.data.model.materials.Materials r5 = (in.etuwa.app.data.model.materials.Materials) r5
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
            java.util.ArrayList<in.etuwa.app.data.model.materials.Materials> r12 = r11.filteredMaterials
            java.util.Collection r0 = (java.util.Collection) r0
            r12.addAll(r0)
            r11.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.questionbank.QuestionBankAdapter.applyCombinedFilter(java.lang.String):void");
    }

    public final void setQuestionListener(QuestionBankFragment context) {
        this.listener = context;
    }
}