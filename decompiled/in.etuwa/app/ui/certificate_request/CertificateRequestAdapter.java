package in.etuwa.app.ui.certificate_request;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.certificaterequest.CertificateRequest;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CertificateRequestAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CertificateRequestAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final ArrayList<CertificateRequest> certificateRequests = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_certificate_request, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …e_request, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.certificateRequests.size() > 0) {
            return this.certificateRequests.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.certificateRequests.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: CertificateRequestAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/certificate_request/CertificateRequestAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/certificate_request/CertificateRequestAdapter;Landroid/view/View;)V", "date", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_STATUS, "statusBadge", "Landroid/widget/LinearLayout;", "type", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private TextView date;
        private TextView status;
        private LinearLayout statusBadge;
        final /* synthetic */ CertificateRequestAdapter this$0;
        private TextView type;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(CertificateRequestAdapter certificateRequestAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = certificateRequestAdapter;
            this.type = (TextView) itemView.findViewById(R.id.certificate_type);
            this.date = (TextView) itemView.findViewById(R.id.date);
            this.status = (TextView) itemView.findViewById(R.id.status);
            this.statusBadge = (LinearLayout) itemView.findViewById(R.id.status_badge);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.certificateRequests.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "certificateRequests[position]");
                CertificateRequest certificateRequest = (CertificateRequest) obj;
                this.type.setText(certificateRequest.getCertificateType());
                this.date.setText("Date : " + certificateRequest.getDateOfApplication());
                this.status.setText("Status : " + certificateRequest.getStatus());
                String status = certificateRequest.getStatus();
                int iHashCode = status.hashCode();
                if (iHashCode != -543852386) {
                    if (iHashCode != 982065527) {
                        if (iHashCode == 1249888983 && status.equals("Approved")) {
                            this.statusBadge.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D1FAE5")));
                            this.status.setTextColor(Color.parseColor("#059669"));
                            this.status.setText("Approved");
                        }
                    } else if (status.equals("Pending")) {
                        this.statusBadge.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FEF3C7")));
                        this.status.setTextColor(Color.parseColor("#D97706"));
                        this.status.setText("Pending");
                    }
                } else if (status.equals("Rejected")) {
                    this.statusBadge.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FEE2E2")));
                    this.status.setTextColor(Color.parseColor("#DC2626"));
                    this.status.setText("Rejected");
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<CertificateRequest> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.certificateRequests.clear();
        this.certificateRequests.addAll(list);
        notifyDataSetChanged();
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }
}