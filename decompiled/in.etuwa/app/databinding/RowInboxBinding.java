package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowInboxBinding implements ViewBinding {
    public final TextView inboxBadge;
    public final TextView inboxContent;
    public final TextView inboxDate;
    public final TextView inboxFrom;
    public final TextView inboxSubject;
    public final MaterialCardView inboxView;
    private final MaterialCardView rootView;

    private RowInboxBinding(MaterialCardView rootView, TextView inboxBadge, TextView inboxContent, TextView inboxDate, TextView inboxFrom, TextView inboxSubject, MaterialCardView inboxView) {
        this.rootView = rootView;
        this.inboxBadge = inboxBadge;
        this.inboxContent = inboxContent;
        this.inboxDate = inboxDate;
        this.inboxFrom = inboxFrom;
        this.inboxSubject = inboxSubject;
        this.inboxView = inboxView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowInboxBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowInboxBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_inbox, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowInboxBinding bind(View rootView) {
        int i = R.id.inbox_badge;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.inbox_content;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.inbox_date;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.inbox_from;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.inbox_subject;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            MaterialCardView materialCardView = (MaterialCardView) rootView;
                            return new RowInboxBinding(materialCardView, textView, textView2, textView3, textView4, textView5, materialCardView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}