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
public final class RowCourseSurveyBinding implements ViewBinding {
    public final CardView cardSurvey;
    private final CardView rootView;
    public final TextView surveyDo;
    public final TextView surveyLastDate;
    public final TextView surveyName;
    public final TextView surveySession;
    public final TextView surveyStatus;

    private RowCourseSurveyBinding(CardView rootView, CardView cardSurvey, TextView surveyDo, TextView surveyLastDate, TextView surveyName, TextView surveySession, TextView surveyStatus) {
        this.rootView = rootView;
        this.cardSurvey = cardSurvey;
        this.surveyDo = surveyDo;
        this.surveyLastDate = surveyLastDate;
        this.surveyName = surveyName;
        this.surveySession = surveySession;
        this.surveyStatus = surveyStatus;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RowCourseSurveyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowCourseSurveyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.row_course_survey, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RowCourseSurveyBinding bind(View rootView) {
        CardView cardView = (CardView) rootView;
        int i = R.id.survey_do;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.survey_last_date;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.survey_name;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.survey_session;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.survey_status;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            return new RowCourseSurveyBinding(cardView, cardView, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}