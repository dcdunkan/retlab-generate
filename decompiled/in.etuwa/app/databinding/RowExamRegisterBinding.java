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
public final class RowExamRegisterBinding implements ViewBinding {
    public final CardView cvCoverageRow;
    public final TextView deleteBtn;
    private final CardView rootView;
    public final TextView sourceBookName;
    public final TextView updateBtn;

    private RowExamRegisterBinding(CardView rootView, CardView cvCoverageRow, TextView deleteBtn, TextView sourceBookName, TextView updateBtn) {
        this.rootView = rootView;
        this.cvCoverageRow = cvCoverageRow;
        this.deleteBtn = deleteBtn;
        this.sourceBookName = sourceBookName;
        this.updateBtn = updateBtn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowExamRegisterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowExamRegisterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_exam_register, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowExamRegisterBinding bind(View rootView) {
        CardView cardView = (CardView) rootView;
        int i = R.id.delete_btn;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.source_book_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.update_btn;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new RowExamRegisterBinding(cardView, cardView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}