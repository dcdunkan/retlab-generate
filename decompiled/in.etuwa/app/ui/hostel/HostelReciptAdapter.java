package in.etuwa.app.ui.hostel;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.helper.ValidChecker;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostelReciptAdapter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/ui/hostel/HostelReciptAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/hostel/HostelReciptAdapter$ViewHolder;", "context", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/ui/hostel/HostelReciptBean;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "getList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", CommonCssConstants.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HostelReciptAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context context;
    private final ArrayList<HostelReciptBean> list;

    public HostelReciptAdapter(Context context, ArrayList<HostelReciptBean> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "list");
        this.context = context;
        this.list = list;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ArrayList<HostelReciptBean> getList() {
        return this.list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_hostel_fee, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…ostel_fee, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getReNo().setText(this.list.get(position).getReceipt_no());
        holder.getReDate().setText(this.list.get(position).getDate());
        holder.getCard().setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.HostelReciptAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HostelReciptAdapter.onBindViewHolder$lambda$0(HostelReciptAdapter.this, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(HostelReciptAdapter this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlertDialog.Builder builder = new AlertDialog.Builder(this$0.context);
        View inflate = LayoutInflater.from(this$0.context).inflate(R.layout.show_hostel_recipt, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.hostReNo);
        TextView textView2 = (TextView) inflate.findViewById(R.id.hostReHostel);
        TextView textView3 = (TextView) inflate.findViewById(R.id.hostReInst);
        TextView textView4 = (TextView) inflate.findViewById(R.id.hostReAmount);
        TextView textView5 = (TextView) inflate.findViewById(R.id.hostReDate);
        try {
            textView.setText(this$0.list.get(i).getReceipt_no());
            textView2.setText(this$0.list.get(i).getHostel());
            textView3.setText(this$0.list.get(i).getInstallment());
            textView4.setText(this$0.list.get(i).getAmount());
            textView5.setText(new ValidChecker(this$0.context).dateFormatter(this$0.list.get(i).getDate()));
        } catch (Exception unused) {
        }
        builder.setNegativeButton("close", (DialogInterface.OnClickListener) null);
        builder.setView(inflate);
        builder.show();
    }

    /* compiled from: HostelReciptAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lin/etuwa/app/ui/hostel/HostelReciptAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "card", "Landroidx/cardview/widget/CardView;", "kotlin.jvm.PlatformType", "getCard", "()Landroidx/cardview/widget/CardView;", "reDate", "Landroid/widget/TextView;", "getReDate", "()Landroid/widget/TextView;", "reNo", "getReNo", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final CardView card;
        private final TextView reDate;
        private final TextView reNo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.reNo = (TextView) itemView.findViewById(R.id.hostelReNo);
            this.reDate = (TextView) itemView.findViewById(R.id.hostelReDate);
            this.card = (CardView) itemView.findViewById(R.id.cardHostel);
        }

        public final TextView getReNo() {
            return this.reNo;
        }

        public final TextView getReDate() {
            return this.reDate;
        }

        public final CardView getCard() {
            return this.card;
        }
    }
}