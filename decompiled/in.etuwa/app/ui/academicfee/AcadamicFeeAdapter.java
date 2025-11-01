package in.etuwa.app.ui.academicfee;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HTTP;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AcadamicFeeAdapter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/ui/academicfee/AcadamicFeeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/academicfee/AcadamicFeeAdapter$ViewHolder;", "context", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/ui/academicfee/AcadamicFeeBean;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "getList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", CommonCssConstants.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AcadamicFeeAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context context;
    private final ArrayList<AcadamicFeeBean> list;

    public AcadamicFeeAdapter(Context context, ArrayList<AcadamicFeeBean> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "list");
        this.context = context;
        this.list = list;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ArrayList<AcadamicFeeBean> getList() {
        return this.list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_acadamic_pay, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…damic_pay, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getName().setText(this.list.get(position).getName());
        holder.getAmount().setText(this.list.get(position).getAmount());
        holder.getLayout().setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.academicfee.AcadamicFeeAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AcadamicFeeAdapter.onBindViewHolder$lambda$0(AcadamicFeeAdapter.this, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(AcadamicFeeAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this$0.context);
            View inflate = LayoutInflater.from(this$0.context).inflate(R.layout.dialog_acadamic, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.acadaDialoPayAmount);
            TextView textView2 = (TextView) inflate.findViewById(R.id.acadaDialoPaySchol);
            TextView textView3 = (TextView) inflate.findViewById(R.id.acadaDialoPayPaid);
            TextView textView4 = (TextView) inflate.findViewById(R.id.acadaDialoPayBal);
            TextView textView5 = (TextView) inflate.findViewById(R.id.acadaDialoTotPayable);
            textView.setText(this$0.list.get(i).getAmount());
            textView2.setText(this$0.list.get(i).getScholer());
            textView3.setText(this$0.list.get(i).getPaid());
            textView4.setText(this$0.list.get(i).getBalance());
            textView5.setText("Total : " + this$0.list.get(i).getPayable());
            builder.setNegativeButton(HTTP.CONN_CLOSE, (DialogInterface.OnClickListener) null);
            builder.setView(inflate);
            builder.show();
        } catch (Exception unused) {
        }
    }

    /* compiled from: AcadamicFeeAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lin/etuwa/app/ui/academicfee/AcadamicFeeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", ExamSubjectDetailDialogKt.ARG_AMOUNT, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAmount", "()Landroid/widget/TextView;", "layout", "Landroid/widget/LinearLayout;", "getLayout", "()Landroid/widget/LinearLayout;", "name", "getName", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView amount;
        private final LinearLayout layout;
        private final TextView name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.name = (TextView) itemView.findViewById(R.id.acdamicPayName);
            this.amount = (TextView) itemView.findViewById(R.id.acadamicAmount);
            this.layout = (LinearLayout) itemView.findViewById(R.id.linearplay);
        }

        public final TextView getName() {
            return this.name;
        }

        public final TextView getAmount() {
            return this.amount;
        }

        public final LinearLayout getLayout() {
            return this.layout;
        }
    }
}