package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowCertificateRequestBinding implements ViewBinding {
    public final TextView certificateType;
    public final TextView date;
    private final MaterialCardView rootView;
    public final TextView status;
    public final LinearLayout statusBadge;

    private RowCertificateRequestBinding(MaterialCardView rootView, TextView certificateType, TextView date, TextView status, LinearLayout statusBadge) {
        this.rootView = rootView;
        this.certificateType = certificateType;
        this.date = date;
        this.status = status;
        this.statusBadge = statusBadge;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowCertificateRequestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowCertificateRequestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_certificate_request, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowCertificateRequestBinding bind(View rootView) {
        int i = R.id.certificate_type;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.date;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.status;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.status_badge;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        return new RowCertificateRequestBinding((MaterialCardView) rootView, textView, textView2, textView3, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}