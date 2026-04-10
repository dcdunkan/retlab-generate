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
public final class RowSurveyBinding implements ViewBinding {
    public final MaterialCardView cardSurvey;
    private final MaterialCardView rootView;
    public final MaterialButton surveyDo;
    public final TextView surveyLastDate;
    public final TextView surveyName;
    public final TextView surveySession;
    public final TextView surveyStatusBadge;
    public final View viewAccentBar;

    private RowSurveyBinding(MaterialCardView rootView, MaterialCardView cardSurvey, MaterialButton surveyDo, TextView surveyLastDate, TextView surveyName, TextView surveySession, TextView surveyStatusBadge, View viewAccentBar) {
        this.rootView = rootView;
        this.cardSurvey = cardSurvey;
        this.surveyDo = surveyDo;
        this.surveyLastDate = surveyLastDate;
        this.surveyName = surveyName;
        this.surveySession = surveySession;
        this.surveyStatusBadge = surveyStatusBadge;
        this.viewAccentBar = viewAccentBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowSurveyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowSurveyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_survey, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowSurveyBinding bind(View rootView) {
        View viewFindChildViewById;
        MaterialCardView materialCardView = (MaterialCardView) rootView;
        int i = R.id.survey_do;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
        if (materialButton != null) {
            i = R.id.survey_last_date;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.survey_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.survey_session;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.survey_status_badge;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.view_accent_bar))) != null) {
                            return new RowSurveyBinding(materialCardView, materialCardView, materialButton, textView, textView2, textView3, textView4, viewFindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}