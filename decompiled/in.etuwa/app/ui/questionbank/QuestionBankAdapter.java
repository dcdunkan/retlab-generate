package in.etuwa.app.ui.questionbank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
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

/* compiled from: QuestionBankAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\u0006\u0010\r\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/ui/questionbank/QuestionBankAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/questionbank/QuestionBankAdapter$QuestionListener;", "materials", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/materials/Materials;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", "clearItems", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setQuestionListener", "context", "Lin/etuwa/app/ui/questionbank/QuestionBankFragment;", "QuestionListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestionBankAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private QuestionListener listener;
    private final ArrayList<Materials> materials = new ArrayList<>();

    /* compiled from: QuestionBankAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/questionbank/QuestionBankAdapter$QuestionListener;", "", "checkFileExistence", "", "fileName", "", "downloadFile", "", "url", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface QuestionListener {
        boolean checkFileExistence(String fileName);

        void downloadFile(String url, int position);
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

    /* compiled from: QuestionBankAdapter.kt */
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
                List split$default = StringsKt.split$default((CharSequence) materials.getSubject(), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null);
                this.subject.setText(StringsKt.trim((CharSequence) split$default.get(split$default.size() - 1)).toString());
                this.sem.setText(materials.getSemester());
                this.title.setText(materials.getTitle());
                String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(materials.getUrl(), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                QuestionListener questionListener = this.this$0.listener;
                Boolean valueOf = questionListener != null ? Boolean.valueOf(questionListener.checkFileExistence(replace)) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
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
                        QuestionBankAdapter.ViewHolder.onBind$lambda$0(QuestionBankAdapter.this, materials, position, view);
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

    public final void setQuestionListener(QuestionBankFragment context) {
        this.listener = context;
    }
}