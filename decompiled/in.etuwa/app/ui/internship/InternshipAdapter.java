package in.etuwa.app.ui.internship;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.internship.Internship;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.internship.InternshipAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternshipAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lin/etuwa/app/ui/internship/InternshipAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "intern", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/internship/Internship;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/internship/InternshipAdapter$CallBack;", "addItems", "", "list", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "context", "Lin/etuwa/app/ui/internship/InternshipFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InternshipAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<Internship> intern = new ArrayList<>();
    private CallBack listener;

    /* compiled from: InternshipAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\bH&J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Lin/etuwa/app/ui/internship/InternshipAdapter$CallBack;", "", "checkFileExistence", "", "fileName", "", "flag", "downloadFile", "", "url", CommonCssConstants.POSITION, "", "onPickDoc", "id", "onViewDoc", "openReport", "showError", "upload", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        boolean checkFileExistence(String fileName, boolean flag);

        void downloadFile(String url, int position, boolean flag);

        void onPickDoc(String id);

        void onViewDoc(String url);

        void openReport(String url);

        void showError();

        void upload(String id);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_internship, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …nternship, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.intern.size() > 0) {
            return this.intern.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.intern.isEmpty() ? 1 : 0;
    }

    /* compiled from: InternshipAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lin/etuwa/app/ui/internship/InternshipAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/internship/InternshipAdapter;Landroid/view/View;)V", "companyName", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "completionLayout", "Landroid/widget/LinearLayout;", "completionLayout2", "downloadBtn", "fromDate", "slNo", NotificationCompat.CATEGORY_STATUS, "toDate", "uploadBtn", "verifiedLayout", "viewVerifiedCertificateBtn", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView companyName;
        private final LinearLayout completionLayout;
        private final LinearLayout completionLayout2;
        private final TextView downloadBtn;
        private final TextView fromDate;
        private final TextView slNo;
        private final TextView status;
        final /* synthetic */ InternshipAdapter this$0;
        private final TextView toDate;
        private final TextView uploadBtn;
        private final LinearLayout verifiedLayout;
        private final TextView viewVerifiedCertificateBtn;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(InternshipAdapter internshipAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = internshipAdapter;
            this.slNo = (TextView) itemView.findViewById(R.id.sl_no);
            this.companyName = (TextView) itemView.findViewById(R.id.company_name);
            this.fromDate = (TextView) itemView.findViewById(R.id.internship_from);
            this.toDate = (TextView) itemView.findViewById(R.id.internship_to);
            this.status = (TextView) itemView.findViewById(R.id.internship_status);
            this.completionLayout = (LinearLayout) itemView.findViewById(R.id.comletion_layout);
            this.uploadBtn = (TextView) itemView.findViewById(R.id.certificate_upload);
            this.completionLayout2 = (LinearLayout) itemView.findViewById(R.id.comletion_layout2);
            this.downloadBtn = (TextView) itemView.findViewById(R.id.certificate_download);
            this.viewVerifiedCertificateBtn = (TextView) itemView.findViewById(R.id.verified_certificate_download);
            this.verifiedLayout = (LinearLayout) itemView.findViewById(R.id.verified_layout);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.intern.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "intern[position]");
                final Internship internship = (Internship) obj;
                this.companyName.setText(internship.getSlno() + ". " + internship.getName());
                this.fromDate.setText(internship.getFromDate());
                this.toDate.setText(internship.getToDate());
                this.status.setText(internship.getStatus());
                if (internship.getVerifiedCertificate() == null) {
                    this.verifiedLayout.setVisibility(8);
                }
                if (!Intrinsics.areEqual(internship.getStatus(), "Applied")) {
                    this.completionLayout.setVisibility(0);
                    this.completionLayout2.setVisibility(0);
                } else {
                    this.completionLayout.setVisibility(8);
                    this.completionLayout2.setVisibility(8);
                }
                if (Intrinsics.areEqual(internship.getCompletion(), "Upload")) {
                    this.completionLayout.setVisibility(0);
                    this.completionLayout2.setVisibility(8);
                } else if (Intrinsics.areEqual(internship.getCompletion(), "Download")) {
                    this.completionLayout.setVisibility(8);
                    this.completionLayout2.setVisibility(0);
                } else {
                    this.completionLayout.setVisibility(8);
                    this.completionLayout2.setVisibility(8);
                }
                TextView textView = this.uploadBtn;
                final InternshipAdapter internshipAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.InternshipAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        InternshipAdapter.ViewHolder.onBind$lambda$0(InternshipAdapter.this, internship, view);
                    }
                });
                TextView textView2 = this.downloadBtn;
                final InternshipAdapter internshipAdapter2 = this.this$0;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.InternshipAdapter$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        InternshipAdapter.ViewHolder.onBind$lambda$1(Internship.this, internshipAdapter2, position, view);
                    }
                });
                TextView textView3 = this.viewVerifiedCertificateBtn;
                final InternshipAdapter internshipAdapter3 = this.this$0;
                textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.InternshipAdapter$ViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        InternshipAdapter.ViewHolder.onBind$lambda$2(InternshipAdapter.this, internship, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(InternshipAdapter this$0, Internship intern, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(intern, "$intern");
            System.out.println((Object) "========================All is well=====================");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.onPickDoc(intern.getId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(Internship intern, InternshipAdapter this$0, int i, View view) {
            Intrinsics.checkNotNullParameter(intern, "$intern");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            System.out.println((Object) ("========================" + intern.getUrl() + "====================="));
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.downloadFile(intern.getUrl(), i, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$2(InternshipAdapter this$0, Internship intern, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(intern, "$intern");
            try {
                CallBack callBack = this$0.listener;
                if (callBack != null) {
                    callBack.openReport(intern.getVerifiedCertificate());
                }
            } catch (NullPointerException unused) {
                CallBack callBack2 = this$0.listener;
                if (callBack2 != null) {
                    callBack2.showError();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void addItems(ArrayList<Internship> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.intern.clear();
        this.intern.addAll(list);
        notifyDataSetChanged();
    }

    public final void setCallBack(InternshipFragment context) {
        this.listener = context;
    }
}