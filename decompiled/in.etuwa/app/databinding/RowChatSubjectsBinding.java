package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class RowChatSubjectsBinding implements ViewBinding {
    public final TextView chatSubName;
    private final CardView rootView;
    public final CardView subjectCard;

    private RowChatSubjectsBinding(CardView rootView, TextView chatSubName, CardView subjectCard) {
        this.rootView = rootView;
        this.chatSubName = chatSubName;
        this.subjectCard = subjectCard;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowChatSubjectsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowChatSubjectsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_chat_subjects, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowChatSubjectsBinding bind(View rootView) {
        int i = R.id.chat_sub_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            CardView cardView = (CardView) rootView;
            return new RowChatSubjectsBinding(cardView, textView, cardView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}