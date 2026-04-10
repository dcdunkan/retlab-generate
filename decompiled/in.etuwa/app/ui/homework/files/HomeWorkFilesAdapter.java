package in.etuwa.app.ui.homework.files;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.exam.ExamFiles;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.homework.files.HomeWorkFilesAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: HomeWorkFilesAdapter.kt */
/* loaded from: classes4.dex */
public final class HomeWorkFilesAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<ExamFiles> exams = new ArrayList<>();
    private DocListener listener;

    /* compiled from: HomeWorkFilesAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/homework/files/HomeWorkFilesAdapter$DocListener;", "", "checkFileExistence", "", "fileName", "", "downloadFile", "", "url", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface DocListener {
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_question, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …_question, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.exams.size() > 0) {
            return this.exams.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.exams.isEmpty() ? 1 : 0;
    }

    /* compiled from: HomeWorkFilesAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/homework/files/HomeWorkFilesAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/homework/files/HomeWorkFilesAdapter;Landroid/view/View;)V", "doc", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "downBtn", "no", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView doc;
        private final TextView downBtn;
        private final TextView no;
        final /* synthetic */ HomeWorkFilesAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(HomeWorkFilesAdapter homeWorkFilesAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = homeWorkFilesAdapter;
            this.no = (TextView) itemView.findViewById(R.id.tv_no);
            this.doc = (TextView) itemView.findViewById(R.id.tv_doc);
            this.downBtn = (TextView) itemView.findViewById(R.id.tv_doc_down_btn);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.exams.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "exams[position]");
                final ExamFiles examFiles = (ExamFiles) obj;
                this.no.setText(String.valueOf(position + 1));
                this.doc.setText(examFiles.getDoc());
                Regex regex = new Regex("[^A-Za-z0-9.]");
                String path = examFiles.getPath();
                Intrinsics.checkNotNull(path);
                String replace = regex.replace(StringsKt.substringAfterLast$default(path, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
                DocListener docListener = this.this$0.listener;
                Boolean valueOf = docListener != null ? Boolean.valueOf(docListener.checkFileExistence(replace)) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
                    this.downBtn.setText("Open");
                    this.downBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_inactive);
                } else {
                    this.downBtn.setText("Download");
                    this.downBtn.setBackgroundResource(R.drawable.shape_round_corner_fill_dark);
                }
                TextView textView = this.downBtn;
                final HomeWorkFilesAdapter homeWorkFilesAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.homework.files.HomeWorkFilesAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeWorkFilesAdapter.ViewHolder.onBind$lambda$0(HomeWorkFilesAdapter.this, examFiles, position, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(HomeWorkFilesAdapter this$0, ExamFiles exam, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(exam, "$exam");
            DocListener docListener = this$0.listener;
            if (docListener != null) {
                docListener.downloadFile(exam.getPath(), i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<ExamFiles> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.exams.clear();
        this.exams.addAll(list);
        notifyDataSetChanged();
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void setCallBack(HomeWorkFilesDialog context) {
        this.listener = context;
    }
}