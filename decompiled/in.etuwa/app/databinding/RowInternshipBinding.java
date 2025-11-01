package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowInternshipBinding implements ViewBinding {
    public final TextView certificateDownload;
    public final TextView certificateUpload;
    public final LinearLayout comletionLayout;
    public final LinearLayout comletionLayout2;
    public final TextView companyName;
    public final TextView internshipFrom;
    public final TextView internshipStatus;
    public final TextView internshipTo;
    private final CardView rootView;
    public final TextView slNo;
    public final TextView verifiedCertificateDownload;
    public final LinearLayout verifiedLayout;

    private RowInternshipBinding(CardView rootView, TextView certificateDownload, TextView certificateUpload, LinearLayout comletionLayout, LinearLayout comletionLayout2, TextView companyName, TextView internshipFrom, TextView internshipStatus, TextView internshipTo, TextView slNo, TextView verifiedCertificateDownload, LinearLayout verifiedLayout) {
        this.rootView = rootView;
        this.certificateDownload = certificateDownload;
        this.certificateUpload = certificateUpload;
        this.comletionLayout = comletionLayout;
        this.comletionLayout2 = comletionLayout2;
        this.companyName = companyName;
        this.internshipFrom = internshipFrom;
        this.internshipStatus = internshipStatus;
        this.internshipTo = internshipTo;
        this.slNo = slNo;
        this.verifiedCertificateDownload = verifiedCertificateDownload;
        this.verifiedLayout = verifiedLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowInternshipBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowInternshipBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_internship, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowInternshipBinding bind(View rootView) {
        int i = R.id.certificate_download;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.certificate_upload;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.comletion_layout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout != null) {
                    i = R.id.comletion_layout2;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout2 != null) {
                        i = R.id.company_name;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.internship_from;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView4 != null) {
                                i = R.id.internship_status;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView5 != null) {
                                    i = R.id.internship_to;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView6 != null) {
                                        i = R.id.sl_no;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView7 != null) {
                                            i = R.id.verified_certificate_download;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView8 != null) {
                                                i = R.id.verified_layout;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (linearLayout3 != null) {
                                                    return new RowInternshipBinding((CardView) rootView, textView, textView2, linearLayout, linearLayout2, textView3, textView4, textView5, textView6, textView7, textView8, linearLayout3);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}