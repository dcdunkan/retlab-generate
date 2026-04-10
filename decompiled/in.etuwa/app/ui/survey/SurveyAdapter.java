package in.etuwa.app.ui.survey;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.survey.Survey;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import in.etuwa.app.ui.survey.SurveyAdapter;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class SurveyAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private boolean isAscending;
    private SurveyCallBack listener;
    private final ArrayList<Survey> surveyList = new ArrayList<>();
    private final ArrayList<Survey> fullList = new ArrayList<>();
    private String currentFilter = "pending";
    private String currentQuery = "";

    /* JADX INFO: compiled from: SurveyAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/survey/SurveyAdapter$SurveyCallBack;", "", "doTheSurvey", "", "id", "", "type", "surveyName", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SurveyCallBack {
        void doTheSurvey(String id, String type, String surveyName);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_survey, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context)\n   …ow_survey, parent, false)");
            return new ViewHolder(this, viewInflate);
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …mpty_view, parent, false)");
        return new EmptyViewHolder(viewInflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!this.surveyList.isEmpty()) {
            return this.surveyList.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.surveyList.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: SurveyAdapter.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J(\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J?\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u000fH\u0014J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u001dH\u0016R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0006*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lin/etuwa/app/ui/survey/SurveyAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/survey/SurveyAdapter;Landroid/view/View;)V", "accentBar", "kotlin.jvm.PlatformType", "lastDate", "Landroid/widget/TextView;", "statusBadge", "surveyDoBtn", "Lcom/google/android/material/button/MaterialButton;", "surveyName", "surveySession", "applyAccent", "", SvgConstants.Tags.VIEW, "hex", "", "applyBadge", "badge", "text", "bgHex", "textHex", "applyButton", FullDayDialogKt.ARG_BTN, "btnBg", "btnText", "iconRes", "", CommonCssConstants.ENABLED, "", "(Lcom/google/android/material/button/MaterialButton;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)V", "clear", "onBind", CommonCssConstants.POSITION, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final View accentBar;
        private final TextView lastDate;
        private final TextView statusBadge;
        private final MaterialButton surveyDoBtn;
        private final TextView surveyName;
        private final TextView surveySession;
        final /* synthetic */ SurveyAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SurveyAdapter surveyAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = surveyAdapter;
            this.surveyName = (TextView) itemView.findViewById(R.id.survey_name);
            this.surveySession = (TextView) itemView.findViewById(R.id.survey_session);
            this.lastDate = (TextView) itemView.findViewById(R.id.survey_last_date);
            this.statusBadge = (TextView) itemView.findViewById(R.id.survey_status_badge);
            this.accentBar = itemView.findViewById(R.id.view_accent_bar);
            this.surveyDoBtn = (MaterialButton) itemView.findViewById(R.id.survey_do);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            String str;
            super.onBind(position);
            try {
                Object obj = this.this$0.surveyList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "surveyList[position]");
                final Survey survey = (Survey) obj;
                this.itemView.getContext();
                this.surveyName.setText(survey.getName());
                this.surveySession.setText(survey.getSession());
                TextView textView = this.lastDate;
                String lowerCase = survey.getBtnStatus().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, "last date over")) {
                    str = "Was due " + survey.getLastDate();
                } else {
                    str = "Due " + survey.getLastDate();
                }
                textView.setText(str);
                String lowerCase2 = survey.getBtnStatus().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                boolean zAreEqual = Intrinsics.areEqual(lowerCase2, "last date over");
                boolean complete = survey.getComplete();
                if (zAreEqual && !complete) {
                    View accentBar = this.accentBar;
                    Intrinsics.checkNotNullExpressionValue(accentBar, "accentBar");
                    applyAccent(accentBar, "#F57C00");
                    TextView statusBadge = this.statusBadge;
                    Intrinsics.checkNotNullExpressionValue(statusBadge, "statusBadge");
                    applyBadge(statusBadge, "Expired", "#FFF3E0", "#E65100");
                    MaterialButton surveyDoBtn = this.surveyDoBtn;
                    Intrinsics.checkNotNullExpressionValue(surveyDoBtn, "surveyDoBtn");
                    applyButton(surveyDoBtn, "Last Date Over", "#FFF3E0", "#E65100", null, false);
                    return;
                }
                if (zAreEqual && complete) {
                    View accentBar2 = this.accentBar;
                    Intrinsics.checkNotNullExpressionValue(accentBar2, "accentBar");
                    applyAccent(accentBar2, "#1D9E75");
                    TextView statusBadge2 = this.statusBadge;
                    Intrinsics.checkNotNullExpressionValue(statusBadge2, "statusBadge");
                    applyBadge(statusBadge2, "Completed", "#E8F5E9", "#1B5E20");
                    MaterialButton surveyDoBtn2 = this.surveyDoBtn;
                    Intrinsics.checkNotNullExpressionValue(surveyDoBtn2, "surveyDoBtn");
                    applyButton(surveyDoBtn2, "Completed", "#E8F5E9", "#1B5E20", Integer.valueOf(R.drawable.ic_check), false);
                    return;
                }
                if (!zAreEqual && complete) {
                    View accentBar3 = this.accentBar;
                    Intrinsics.checkNotNullExpressionValue(accentBar3, "accentBar");
                    applyAccent(accentBar3, "#1D9E75");
                    TextView statusBadge3 = this.statusBadge;
                    Intrinsics.checkNotNullExpressionValue(statusBadge3, "statusBadge");
                    applyBadge(statusBadge3, "Completed", "#E1F5EE", "#0F6E56");
                    MaterialButton surveyDoBtn3 = this.surveyDoBtn;
                    Intrinsics.checkNotNullExpressionValue(surveyDoBtn3, "surveyDoBtn");
                    applyButton(surveyDoBtn3, "Completed", "#E1F5EE", "#0F6E56", Integer.valueOf(R.drawable.ic_check), false);
                    return;
                }
                View accentBar4 = this.accentBar;
                Intrinsics.checkNotNullExpressionValue(accentBar4, "accentBar");
                applyAccent(accentBar4, "#545996");
                TextView statusBadge4 = this.statusBadge;
                Intrinsics.checkNotNullExpressionValue(statusBadge4, "statusBadge");
                applyBadge(statusBadge4, "Pending", "#FAEEDA", "#854F0B");
                MaterialButton surveyDoBtn4 = this.surveyDoBtn;
                Intrinsics.checkNotNullExpressionValue(surveyDoBtn4, "surveyDoBtn");
                applyButton(surveyDoBtn4, "Take Survey", "#545996", "#FFFFFF", Integer.valueOf(R.drawable.ic_survey_check), true);
                MaterialButton materialButton = this.surveyDoBtn;
                final SurveyAdapter surveyAdapter = this.this$0;
                materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.SurveyAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SurveyAdapter.ViewHolder.onBind$lambda$0(surveyAdapter, survey, view);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(SurveyAdapter this$0, Survey survey, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(survey, "$survey");
            SurveyCallBack surveyCallBack = this$0.listener;
            if (surveyCallBack != null) {
                surveyCallBack.doTheSurvey(survey.getSurveyId(), survey.getType(), survey.getName());
            }
        }

        private final void applyAccent(View view, String hex) {
            view.setBackgroundColor(Color.parseColor(hex));
        }

        private final void applyBadge(TextView badge, String text, String bgHex, String textHex) {
            badge.setText(text);
            badge.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(bgHex)));
            badge.setTextColor(Color.parseColor(textHex));
        }

        private final void applyButton(MaterialButton btn, String text, String btnBg, String btnText, Integer iconRes, boolean enabled) {
            btn.setText(text);
            btn.setEnabled(enabled);
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(btnBg)));
            btn.setTextColor(Color.parseColor(btnText));
            btn.setIcon(iconRes != null ? ContextCompat.getDrawable(btn.getContext(), iconRes.intValue()) : null);
            btn.setIconTint(ColorStateList.valueOf(Color.parseColor(btnText)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<Survey> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.surveyList.clear();
        ArrayList<Survey> arrayList = list;
        this.surveyList.addAll(arrayList);
        this.fullList.clear();
        this.fullList.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final void setFilter(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.currentFilter = type;
        applyCombinedFilter$default(this, null, 1, null);
    }

    public static /* synthetic */ void applyCombinedFilter$default(SurveyAdapter surveyAdapter, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = surveyAdapter.currentQuery;
        }
        surveyAdapter.applyCombinedFilter(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void applyCombinedFilter(java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.survey.SurveyAdapter.applyCombinedFilter(java.lang.String):void");
    }

    public final void toggleSort() {
        this.isAscending = !this.isAscending;
        applyCombinedFilter$default(this, null, 1, null);
    }

    public final void setSurveyCallBack(SurveyFragment context) {
        this.listener = context;
    }
}