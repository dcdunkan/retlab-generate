package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowTechSurveyBinding implements ViewBinding {
    public final MaterialCardView cardTeacherSurvey;
    private final MaterialCardView rootView;
    public final MaterialButton surTeachBtn;
    public final TextView surTeachName;
    public final TextView surTeachStatusBadge;
    public final TextView surTeachSubName;
    public final View viewAccentBar;

    private RowTechSurveyBinding(MaterialCardView rootView, MaterialCardView cardTeacherSurvey, MaterialButton surTeachBtn, TextView surTeachName, TextView surTeachStatusBadge, TextView surTeachSubName, View viewAccentBar) {
        this.rootView = rootView;
        this.cardTeacherSurvey = cardTeacherSurvey;
        this.surTeachBtn = surTeachBtn;
        this.surTeachName = surTeachName;
        this.surTeachStatusBadge = surTeachStatusBadge;
        this.surTeachSubName = surTeachSubName;
        this.viewAccentBar = viewAccentBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowTechSurveyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowTechSurveyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_tech_survey, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowTechSurveyBinding bind(View rootView) {
        View viewFindChildViewById;
        MaterialCardView materialCardView = (MaterialCardView) rootView;
        int i = R.id.sur_teach_btn;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
        if (materialButton != null) {
            i = R.id.sur_teach_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.sur_teach_status_badge;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.sur_teach_sub_name;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.view_accent_bar))) != null) {
                        return new RowTechSurveyBinding(materialCardView, materialCardView, materialButton, textView, textView2, textView3, viewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}