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
public final class RowDoSurveyBinding implements ViewBinding {
    private final CardView rootView;
    public final TextView surTeachBtn;
    public final TextView surTeachStatus;
    public final TextView surTeachSubName;

    private RowDoSurveyBinding(CardView rootView, TextView surTeachBtn, TextView surTeachStatus, TextView surTeachSubName) {
        this.rootView = rootView;
        this.surTeachBtn = surTeachBtn;
        this.surTeachStatus = surTeachStatus;
        this.surTeachSubName = surTeachSubName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowDoSurveyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowDoSurveyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_do_survey, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowDoSurveyBinding bind(View rootView) {
        int i = R.id.sur_teach_btn;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.sur_teach_status;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.sur_teach_sub_name;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    return new RowDoSurveyBinding((CardView) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}